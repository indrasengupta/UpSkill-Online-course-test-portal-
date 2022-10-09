package upskill.ocm.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import upskill.ocm.dtos.CourseDetailsDto;
import upskill.ocm.dtos.Credentials;
import upskill.ocm.dtos.DtoEntityConverter;
import upskill.ocm.dtos.LecturerDto;
import upskill.ocm.dtos.QuestionBankDto;
import upskill.ocm.dtos.Response;
import upskill.ocm.dtos.SubscribedPlanDto;
import upskill.ocm.dtos.SubscriptionDetailDto;
import upskill.ocm.dtos.VideosDto;
import upskill.ocm.entities.CourseContent;
import upskill.ocm.entities.Subscription;
import upskill.ocm.services.LecturerServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class LecturerControllerImpl {
	@Autowired
	private LecturerServiceImpl lecturerService;
	@Autowired
	private DtoEntityConverter dtoEntityConverter;
	
	@PostMapping("/lecturer/addvideos")
	public ResponseEntity<?> addVideos(@RequestBody VideosDto videosDto){
		
	lecturerService.addVideoByLecturer(videosDto);
		return Response.success("videos added successfully");
	}

	@PostMapping("/lecturer/signup")
	public ResponseEntity<?> lecturerSignUp(@RequestBody LecturerDto lecturerDto) {
		LecturerDto result = lecturerService.saveLecturer(lecturerDto);
		return Response.success(result);
	}

	@PostMapping("/lecturer/login")
	public ResponseEntity<?> lecturerLogin(@RequestBody Credentials cred) {
		LecturerDto result = lecturerService.getLecturerByEmailAndPassword(cred);
		// System.out.println(result.toString());
		if (result == null)
			return Response.error("Lecturer not found!!!");
		return Response.success(result);
	}

	@GetMapping("/lecturer/profile/{id}")
	public ResponseEntity<?> lecturerProfile(@PathVariable("id") int id) {
		LecturerDto result = lecturerService.getLecturerProfile(id);
		if (result == null)
			return Response.error("Lecturer not found!!!");
		return Response.success(result);
	}
	
	@PostMapping("/lecturer/addtest/{courseId}")
	public ResponseEntity<?> addTest(@RequestBody QuestionBankDto questionBankDto,@PathVariable("courseId") int id){
		System.out.println("QuestionbankDto : "+questionBankDto+' '+"Course Id : "+id);
	lecturerService.saveTest(questionBankDto,id);
		return Response.success("test added successfully");
	}

	@GetMapping("/subscription")
	public ResponseEntity<?> getAllSubscriptionPlans() {
		List<Subscription> result = new ArrayList<>();
		result = lecturerService.subscriptionPlans();
		return Response.success(result);
	}

	@GetMapping("/subscription-detail/{id}")
	public ResponseEntity<?> subscriptionDetailById(@PathVariable("id") int id) {
		SubscriptionDetailDto sb = lecturerService.subscribedLecturer(id);
		System.out.println("subscription-detail");
		System.out.println(sb);
		return Response.success(sb);
	}

	@PostMapping("/buy-plan")
	public ResponseEntity<?> addLectuererSubscribedPlan(@RequestBody SubscribedPlanDto spd) {
		if (spd != null) {
			lecturerService.addSubscribedPlanByLecturer(spd);
			return Response.success("succesfully buyed-plan");
		}
		return Response.error("ERROR while buying-plan");
	}

	@PostMapping("/remove-plan")
	public ResponseEntity<?> removeLectuererSubscribedPlan(@RequestBody SubscribedPlanDto spd) {
		if (spd != null) {
			lecturerService.removeExpiredPlan(spd);
			return Response.success("succesfully removed-plan");
		}
		return Response.error("ERROR while removing-plan");
	}

	@PutMapping("/lecturer/update/{id}")
	public ResponseEntity<?> updateLecturer(@PathVariable("id") int lecturerId, @RequestBody LecturerDto lecturerDto) {
		Map<String, Object> result = lecturerService.updateLecturer(lecturerId, lecturerDto);
		return Response.success(result);
	}

	@GetMapping("/lecturer/{id}")
	public ResponseEntity<?> findLecturerById(@PathVariable("id") int lecturerId) {
		LecturerDto result = lecturerService.findLecturerById(lecturerId);
		return Response.success(result);

	}

	@GetMapping("/lecturer/courses/{id}")
	public ResponseEntity<?> findCourseByLecturer(@PathVariable("id") int lecturerId) {
		List<CourseContent> list = lecturerService.findLecturerCourse(lecturerId);
		Stream<CourseDetailsDto> results = list.stream().map(s -> dtoEntityConverter.toCourseContentDto(s));
		return Response.success(results);
	}
}
