package upskill.ocm.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upskill.ocm.daos.LecturerDao;
import upskill.ocm.daos.QuestionbankDao;
import upskill.ocm.daos.SubscribedDao;
import upskill.ocm.daos.SubscriptionDao;
import upskill.ocm.daos.VideosDao;
import upskill.ocm.dtos.Credentials;
import upskill.ocm.dtos.DtoEntityConverter;
import upskill.ocm.dtos.LecturerDto;
import upskill.ocm.dtos.QuestionBankDto;
import upskill.ocm.dtos.SubscribedPlanDto;
import upskill.ocm.dtos.SubscriptionDetailDto;
import upskill.ocm.dtos.VideosDto;
import upskill.ocm.entities.CourseContent;
import upskill.ocm.entities.Lecturer;
import upskill.ocm.entities.Subscribed;
import upskill.ocm.entities.Subscription;

@Service
@Transactional
public class LecturerServiceImpl {
	@Autowired
	private DtoEntityConverter dtoEntityConverter;
	@Autowired
	private LecturerDao lecturerDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	SubscriptionDao subscriptionDao;
	@Autowired
	SubscribedDao subscribedDao;
	@Autowired
	private QuestionbankDao questionBankDao;
	@Autowired
	private VideosDao videosDao;
	@Autowired
	JavaMailSender jms;

	public LecturerDto saveLecturer(LecturerDto lecturerDto) {
		String rawPassword = lecturerDto.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		lecturerDto.setPassword(encPassword);
		Lecturer lecturer = dtoEntityConverter.toLecturerEntity(lecturerDto);
		lecturer = lecturerDao.save(lecturer);
		lecturerDto = dtoEntityConverter.toLecturerDto(lecturer);
		lecturerDto.setPassword("*******");
		return lecturerDto;
	}

	public LecturerDto getLecturerByEmail(String lecturerEmail) {
		Lecturer lecturer = lecturerDao.findByEmail(lecturerEmail);
		LecturerDto lecturerDto = dtoEntityConverter.toLecturerDto(lecturer);
		return lecturerDto;
	}

	public LecturerDto getLecturerByEmailAndPassword(Credentials cred) {
		Lecturer dbLecturer = lecturerDao.findByEmail(cred.getEmail());
		String rawPassword = cred.getPassword();
		if (dbLecturer != null && passwordEncoder.matches(rawPassword, dbLecturer.getPassword())) {
			LecturerDto result = dtoEntityConverter.toLecturerDto(dbLecturer);
			result.setPassword("********");
			return result;
		}
		return null;
	}
	
	public void saveTest(QuestionBankDto qBankDto,int id) {
		questionBankDao.saveTest(qBankDto.getAnswer(),qBankDto.getOption1(),qBankDto.getOption2(),qBankDto.getOption3(),qBankDto.getOption4(),qBankDto.getQuestion(),id);
			
	}

	public List<Subscription> subscriptionPlans() {

		List<Subscription> list = new ArrayList<Subscription>();
		list = subscriptionDao.findAll();
		return list;

	}

	public SubscriptionDetailDto subscribedLecturer(int id) {
		Lecturer lec = new Lecturer();
		lec = lecturerDao.findByLecturerId(id);

		try {

			if (lec.getSubscribedList().get(0) == null) {
				throw new NullPointerException();
			}

			else {
				//Subscribed s = lec.getSubscribedList().get(0);
				Subscribed s = lec.getSubscribedList().get(lec.getSubscribedList().size()-1);
				String planName = s.getSubscription().getSnPlan();
				double planCost = s.getSubscription().getSnAmount();
				int planDuration = s.getSubscription().getSnDuration();

				Date activationDate = s.getCreatedtimestamp();

				LocalDate ad = LocalDate.of(activationDate.getYear() + 1900, activationDate.getMonth() + 1,
						activationDate.getDate());
				System.out.println(ad);
				int daysCompleted = (int) ChronoUnit.DAYS.between(ad, LocalDate.now());

				int daysleft = planDuration - daysCompleted;
				String planStatus = daysleft >= 0 ? "active" : "expire";

				SubscriptionDetailDto sd = new SubscriptionDetailDto(planName, planCost, planDuration, activationDate,
						daysleft, planStatus);
				return sd;
			}
		} catch (Exception e) {
			System.out.println("Dear Leacturer,Please purchase the Subscription Plan");
		}
		return null;
	}

	public void addSubscribedPlanByLecturer(SubscribedPlanDto spd) {
		
		StringBuilder sb=new StringBuilder("");
		
		System.out.println(spd.toString());
		
		
//		sb.append("\n\n"+ "Amount = Rs. "+");
//        String message = sb.toString();
//        //send mail to customer
////      message.concat(order.getTotalAmount()+" ("+order.getOrderDateTime()+") ");
//        System.out.println("Message sent to mail = "+message);
        SimpleMailMessage mesg = new SimpleMailMessage();
        mesg.setTo(spd.getEmail());
        mesg.setSubject("Succesfully Puchased Plan");
        mesg.setText(spd.toString());
        mesg.setFrom("Online_Course_Management_System");
        mesg.setSentDate(new Date());
        jms.send(mesg);
		
		
		subscribedDao.insertPlan(spd.getlId(), spd.getSnId());

	}

	public void removeExpiredPlan(SubscribedPlanDto spd) {
		// Subscribed obj = new Subscribed();
		subscribedDao.removePlan(spd.getlId());

	}

	public LecturerDto getLecturerProfile(int id) {
		Lecturer dbLecturer = lecturerDao.findByLecturerId(id);
		if (dbLecturer != null) {
			LecturerDto result = dtoEntityConverter.toLecturerDto(dbLecturer);
			return result;
		}
		return null;
	}

	public Map<String, Object> updateLecturer(int lecturerId, LecturerDto lecturerDto) {
		if (lecturerDao.existsById(lecturerId)) {
			lecturerDto.setLecturerId(lecturerId);
//			Lecturer lecturer = dtoEntityConverter.toLecturerEntity(lecturerDto);
			String rawPassword = lecturerDto.getPassword();
			String encPassword = passwordEncoder.encode(rawPassword);
			lecturerDto.setPassword(encPassword);
			Lecturer lecturer = dtoEntityConverter.toLecturerEntity(lecturerDto);
			lecturer = lecturerDao.save(lecturer);
			return Collections.singletonMap("changedRows", 1);
		}
		return Collections.singletonMap("changedRows", 0);
	}

	public LecturerDto findLecturerById(int lecturerId) {
		Lecturer lecturer = lecturerDao.getById(lecturerId);

		return dtoEntityConverter.toLecturerDto(lecturer);
	}

	public List<CourseContent> findLecturerCourse(int lecturerId) {
		Optional<Lecturer> lecturer = lecturerDao.findById(lecturerId);
		if (lecturer.isPresent())
			return lecturer.get().getCoursecontentList();
		return null;
	}
	
	public void addVideoByLecturer(VideosDto videosDto ) {
		videosDao.addVideos(videosDto.getVideo(),videosDto.getCourseId(),videosDto.getvName());
			
	}
}
