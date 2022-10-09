package upskill.ocm.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upskill.ocm.daos.CourseContentDao;
import upskill.ocm.daos.RatingDao;
import upskill.ocm.daos.ReviewDao;
import upskill.ocm.daos.VideosDao;
import upskill.ocm.dtos.AddCourseDto;
import upskill.ocm.dtos.CourseDetailsDto;
import upskill.ocm.dtos.CourseDto;
import upskill.ocm.entities.CourseContent;
import upskill.ocm.entities.Rating;
import upskill.ocm.entities.Review;
import upskill.ocm.entities.Videos;

@Service
@Transactional
public class CourseServiceImpl {
	@Autowired
	private CourseContentDao courseContentDao;
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private RatingDao ratingDao;
	@Autowired
	private VideosDao videoDao;
	@Autowired
	private LecturerServiceImpl lecturerServiceImpl;
//	private DtoEntityConverter dtoEntityConverter;
	
	public void addCourse(int id, AddCourseDto addCourseDto){
		courseContentDao.saveCourseContent(addCourseDto.getCourseTitle(), addCourseDto.getCourseFee(), addCourseDto.getDuration(), addCourseDto.getPrerequisite(), addCourseDto.getSyallbus(), addCourseDto.getTags(), id);
	
	List<CourseContent> list= lecturerServiceImpl.findLecturerCourse(id);
	int cid= list.get(list.size()-1).getCourseId();	
	
			System.out.println(cid+"######################");
	videoDao.addVideos(addCourseDto.getVideourl1(), cid, addCourseDto.getVideoName1());
		videoDao.addVideos(addCourseDto.getVideourl2(), cid, addCourseDto.getVideoName2());
	}
	
	
	
//	public CourseDetailsDto getCourseContent(int courseId) {
//		// CourseContent courseContent =
//		// courseContentDao.findCourseContentById(courseId);
//		CourseContent courseContent = courseContentDao.getById(courseId);
//		System.out.println("CourseContent entity : "+courseContent);
//		CourseDetailsDto courseContentDto = dtoEntityConverter.toCourseContentDto(courseContent);
//		return courseContentDto;
//	}

	public Map<String, Integer> addORUpdateReview(String courseReview, int courseId, int studentId) {
		Review dbReview = reviewDao.getReviewByCourseIdAndStudentId(courseId, studentId);
		if (dbReview == null) {
			int reviewRows = reviewDao.saveReview(courseReview, courseId, studentId);
			if (reviewRows != 0)
				return Collections.singletonMap("Rows inserted", 1);
			return Collections.singletonMap("Rows inserted", 0);
		} else {
			int reviewRows = reviewDao.updateReview(courseReview, courseId, studentId);
			if (reviewRows != 0)
				return Collections.singletonMap("Rows updated", 1);
			return Collections.singletonMap("Rows updated", 0);
		}
	}
	
	public Map<String, Integer> addORUpdateRating(String courseRating, int courseId, int studentId) {
		Rating dbRating = ratingDao.getRatingByCourseIdAndStudentId(courseId, studentId);
		if (dbRating == null) {
			int ratingRows = ratingDao.saveRating(courseRating, courseId, studentId);
			if (ratingRows != 0)
				return Collections.singletonMap("Rows inserted", 1);
			return Collections.singletonMap("Rows inserted", 0);
		} else {
			int ratingRows = ratingDao.updateRating(courseRating, courseId, studentId);
			if (ratingRows != 0)
				return Collections.singletonMap("Rows updated", 1);
			return Collections.singletonMap("Rows updated", 0);
		}
	}

	// FIND COURSE BY ID
	public CourseDetailsDto findCourse(int id) {
		try {
			CourseContent course = new CourseContent();
			course = courseContentDao.findByCourseId(id);
			//System.out.println("Course entity : "+course);
			String courseTitle = course.getCourseTitle().toUpperCase();
			String prerequisite = course.getPrerequisite();
			String syallbus = course.getSyallbus();
			String duration = course.getDuration();
			Double courseFee = course.getCourseFee();
			String facalty = course.getLecturer().getFirstName() + " " + course.getLecturer().getLastName();
			String video1 = course.getVideosList().get(0).getVideo();
			String video1Name = course.getVideosList().get(0).getvName();
			String video2 = course.getVideosList().get(1).getVideo();
			String video2Name = course.getVideosList().get(1).getvName();
			List<Videos> videoList = course.getVideosList();
			List<Review> reviewList = course.getReviewList();
			float avgRatting = 0;
			for (int j = 0; j < course.getRatingList().size(); j++) {

				avgRatting = avgRatting + course.getRatingList().get(j).getRating();

			}
			avgRatting = avgRatting / course.getRatingList().size();

			CourseDetailsDto courseDetailsDTO = new CourseDetailsDto(id, courseTitle, prerequisite, syallbus, duration,
					courseFee, facalty, video1, video1Name, video2, video2Name, videoList, reviewList, avgRatting);
			return courseDetailsDTO;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
//	// FIND COURSE CONTENT AND REVIEWDTOLIST BY COURSE ID
//		public CourseContentDto findCourseAndReviewDtoListByCourseId(int id) {
//			try {
//				CourseContent course = new CourseContent();
//				course = courseContentDao.findByCourseId(id);
//				List<ReviewDto> reviewDtoList = reviewDao.getReviewListByCourseId(id);
//				//System.out.println("Course entity : "+course);
//				String courseTitle = course.getCourseTitle().toUpperCase();
//				String prerequisite = course.getPrerequisite();
//				String syallbus = course.getSyallbus();
//				String duration = course.getDuration();
//				Double courseFee = course.getCourseFee();
//				String facalty = course.getLecturer().getFirstName() + " " + course.getLecturer().getLastName();
//				String video1 = course.getVideosList().get(0).getVideo();
//				String video1Name = course.getVideosList().get(0).getvName();
//				String video2 = course.getVideosList().get(1).getVideo();
//				String video2Name = course.getVideosList().get(1).getvName();
//				List<Videos> videoList = course.getVideosList();
//				//List<ReviewDto> reviewDtoList = course.getReviewList();
//				float avgRatting = 0;
//				for (int j = 0; j < course.getRatingList().size(); j++) {
//
//					avgRatting = avgRatting + course.getRatingList().get(j).getRating();
//
//				}
//				avgRatting = avgRatting / course.getRatingList().size();
//
//				CourseContentDto courseContentDto = new CourseContentDto(id, courseTitle, prerequisite, syallbus, duration,
//						courseFee, facalty, video1, video1Name, video2, video2Name, videoList, reviewDtoList, avgRatting);
//				return courseContentDto;
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			return null;
//		}

	// LIST OF ALL COURSES
	public List<CourseDto> findAllCourse() {
		List<CourseContent> courseList = courseContentDao.findAll();
		List<CourseDto> courseDtoList = new ArrayList<CourseDto>();
		for (int i = 0; i < courseList.size(); i++) {
			int id = courseList.get(i).getCourseId();
			String title = courseList.get(i).getCourseTitle().toUpperCase();
			Double fee = courseList.get(i).getCourseFee();
			String firstName = courseList.get(i).getLecturer().getFirstName();
			String lastName = courseList.get(i).getLecturer().getLastName();
			String duration = courseList.get(i).getDuration();
			float avgRatting = 0;
			for (int j = 0; j < courseList.get(i).getRatingList().size(); j++) {

				avgRatting = avgRatting + courseList.get(i).getRatingList().get(j).getRating();

			}

			avgRatting = avgRatting / courseList.get(i).getRatingList().size();
			courseDtoList.add(new CourseDto(id, title, fee, firstName, lastName, duration, avgRatting));
		}

		return courseDtoList;
	}

	public boolean removeCourseByAdmin(int id) {
		System.out.println("ID = " + id);
		if (id >= 0) {
			courseContentDao.deleteById(id);
			return true;
		}
		return false;
	}
}
