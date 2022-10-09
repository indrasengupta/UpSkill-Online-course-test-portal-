package upskill.ocm.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import upskill.ocm.dtos.AddCourseDto;
import upskill.ocm.dtos.CourseDetailsDto;
import upskill.ocm.dtos.CourseDto;
import upskill.ocm.dtos.RatingDto;
import upskill.ocm.dtos.Response;
import upskill.ocm.dtos.ReviewDto;
import upskill.ocm.services.CourseServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class CourseControllerImpl {
	@Autowired
	private CourseServiceImpl courseServiceImpl;
	
	@PostMapping("/course/addcourse/{id}")
	public ResponseEntity<?> addCourse(@PathVariable int id ,@RequestBody AddCourseDto add){
		System.out.println(add);
		courseServiceImpl.addCourse(id,add);
		System.out.println("After adding course:"+add);
		return Response.success("Course added successfully");
	}

//	@GetMapping("/course-content/{id}")
//	public ResponseEntity<?> getCourseContent(@PathVariable("id") int id) {
//		CourseDetailsDto result = courseServiceImpl.findCourse(id);
//		return Response.success(result);
//	}
	
	@GetMapping("/course-content/{id}")
	public ResponseEntity<?> getCourseContent(@PathVariable("id") int id) {
		CourseDetailsDto result = courseServiceImpl.findCourse(id);
		return Response.success(result);
	}

	@PostMapping("/course-content/addReview")
	public ResponseEntity<?> addCourseReview(@RequestBody ReviewDto reviewDto) {
		Map<String, Integer> result = courseServiceImpl.addORUpdateReview(reviewDto.getReview(),
				reviewDto.getCourseId(), reviewDto.getStudentId());
		if (result.containsValue(1))
			return Response.success(result);
		return Response.error("Review addition failed!!!");
	}
	
	@PostMapping("/course-content/addRating")
	public ResponseEntity<?> addCourseRating(@RequestBody RatingDto ratingDto) {
		Map<String, Integer> result = courseServiceImpl.addORUpdateRating(ratingDto.getRating(),
				ratingDto.getCourseId(), ratingDto.getStudentId());
		if (result.containsValue(1))
			return Response.success(result);
		return Response.error("Review addition failed!!!");
	}

	@GetMapping("/courses")
	public ResponseEntity<?> getAllCourse() {
		List<CourseDto> result = new ArrayList<>();
		result = courseServiceImpl.findAllCourse();
		return Response.success(result);
	}

	@GetMapping("/course-detail/{id}")
	public ResponseEntity<?> findCourse(@PathVariable("id") int id) {
		CourseDetailsDto result = courseServiceImpl.findCourse(id);
		//System.out.println("CourseDetailsDto: "+result);
		return Response.success(result);
	}

	@DeleteMapping("/course-remove/{id}")
	public ResponseEntity<?> removeCourse(@PathVariable("id") int id) {
		boolean result = courseServiceImpl.removeCourseByAdmin(id);
		return Response.success(result);
	}
}
