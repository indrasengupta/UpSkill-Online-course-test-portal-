package upskill.ocm.controllers;

import java.util.List;
import java.util.Map;

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
import upskill.ocm.dtos.Response;
import upskill.ocm.dtos.StudentDto;
import upskill.ocm.entities.Questionbank;
import upskill.ocm.services.StudentServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class StudentControllerImpl {
	@Autowired
	private StudentServiceImpl studentService;
//	@Autowired
//	private DtoEntityConverter dtoEntityConverter;

	@PostMapping("/student/signup")
	public ResponseEntity<?> studentSignUp(@RequestBody StudentDto studentDto) {
		StudentDto result = studentService.saveStudent(studentDto);
		return Response.success(result);
	}

	@PostMapping("/student/login")
	public ResponseEntity<?> studentLogin(@RequestBody Credentials cred) {
		StudentDto result = studentService.getStudentByEmailAndPassword(cred);
		// System.out.println(result.toString());
		if (result == null)
			return Response.error("Student not found!!!");
		return Response.success(result);
	}

	@GetMapping("/student/profile/{id}")
	public ResponseEntity<?> studentProfile(@PathVariable("id") int id) {
		StudentDto result = studentService.getStudentProfile(id);
		if (result == null)
			return Response.error("Student not found!!!");
		return Response.success(result);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<?> findStudentById(@PathVariable("id") int studentId) {

		StudentDto result = studentService.findStudentById(studentId);

		return Response.success(result);
	}

	@PutMapping("/student/update/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") int studentId, @RequestBody StudentDto studentDto) {
		Map<String, Object> result = studentService.updateStudent(studentId, studentDto);
		return Response.success(result);
	}

	@GetMapping("/student/courses/{id}")
	public ResponseEntity<?> studentCourseList(@PathVariable("id") int studentId) {
		List<CourseDetailsDto> result = studentService.findCourseByStudentId(studentId);
		return Response.success(result);
	}

	@GetMapping("/student/test/{courseId}")
	public ResponseEntity<?> giveTest(@PathVariable("courseId") int courseId) {
		System.out.println("in controller");
		List<Questionbank> result = studentService.findTestById(courseId);

		return Response.success(result);
	}
	
	@GetMapping("/student/enrollment/{courseId}/{studentId}")
	public ResponseEntity<?> newEnrollment(@PathVariable int courseId,@PathVariable int studentId) {
		String result=studentService.newStudentEnrollment(courseId, studentId);
		return Response.success(result);
	}
	
	@PutMapping("/student/result/{courseId}/{studentId}/{correct}")
	public ResponseEntity<?> updateResultOfStudent(@PathVariable int courseId,@PathVariable int studentId,@PathVariable double correct) {
		System.out.println("no of correct updated "+correct);
		System.out.println("no of course updated "+courseId);
		String result=studentService.studentResultUpdated(courseId, studentId,correct);
		
		System.out.println("no of rows updated "+result);
		return Response.success(result);
	}
}
