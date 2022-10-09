package upskill.ocm.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upskill.ocm.daos.CourseContentDao;
import upskill.ocm.daos.EnrollmentDao;
import upskill.ocm.daos.QuestionbankDao;
import upskill.ocm.daos.StudentDao;
import upskill.ocm.dtos.CourseDetailsDto;
import upskill.ocm.dtos.Credentials;
import upskill.ocm.dtos.DtoEntityConverter;
import upskill.ocm.dtos.StudentDto;
import upskill.ocm.entities.CourseContent;
import upskill.ocm.entities.Questionbank;
import upskill.ocm.entities.Student;

@Service
@Transactional
public class StudentServiceImpl {
@Autowired
private DtoEntityConverter dtoEntityConverter;
@Autowired
private StudentDao studentDao;
@Autowired
private CourseContentDao courseContentDao;
@Autowired
private QuestionbankDao questionBankDao;
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
private EnrollmentDao enrollmentDao;

public StudentDto saveStudent(StudentDto studentDto) {
	String rawPassword = studentDto.getPassword();
	String encPassword = passwordEncoder.encode(rawPassword);
	studentDto.setPassword(encPassword);
	Student student = dtoEntityConverter.toStudentEntity(studentDto);
	student = studentDao.save(student);
	studentDto = dtoEntityConverter.toStudentDto(student);
	studentDto.setPassword("*******");
	return studentDto;
}

public StudentDto getStudentByEmail(String studentEmail ) {
	Student student = studentDao.findByEmail(studentEmail);
	StudentDto studentDto = dtoEntityConverter.toStudentDto(student);
	return studentDto;
}

public StudentDto getStudentByEmailAndPassword(Credentials cred ) {
	Student dbStudent = studentDao.findByEmail(cred.getEmail());
	String rawPassword = cred.getPassword();
	if(dbStudent != null && passwordEncoder.matches(rawPassword, dbStudent.getPassword())) {
		StudentDto result = dtoEntityConverter.toStudentDto(dbStudent);
		result.setPassword("********");
		return result;
	}
	return null;
}

public StudentDto getStudentProfile(int id) {
	Student dbStudent = studentDao.findByStudentId(id);
	if(dbStudent != null) {
		StudentDto result = dtoEntityConverter.toStudentDto(dbStudent);
		return result;
	}
	return null;
}

public StudentDto findStudentById(int studentId)
{
	Student student= studentDao.getById(studentId);
	
	return dtoEntityConverter.toStudentDto(student);
}

public Map<String,Object> updateStudent(int studentId,StudentDto studentDto)
{
	
	if(studentDao.existsById(studentId)) {
		studentDto.setStudentId(studentId);
//		Student student = dtoEntityConverter.toStudentEntity(studentDto);
		String rawPassword = studentDto.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		studentDto.setPassword(encPassword);
		Student student = dtoEntityConverter.toStudentEntity(studentDto);

		student = studentDao.save(student);
		return Collections.singletonMap("changedRows", 1);
	}
	return Collections.singletonMap("changedRows", 0);
}

public List<CourseDetailsDto> findCourseByStudentId(int studentId){
	List<Integer> courseIdList = studentDao.findCourseIdByStudentId(studentId);
	List<CourseDetailsDto> coursect=new ArrayList<>();
	 for (Integer i : courseIdList) {
            CourseContent ct=courseContentDao.getById(i);
            CourseDetailsDto ccd=dtoEntityConverter.toCourseContentByStudentDTO(ct);
            coursect.add(ccd);
        }
	 return coursect;
}

public List<Questionbank> findTestById(int id) { 
	  System.out.println("in service");
List<Questionbank> questionBank=questionBankDao.getTest(id);

return questionBank;
}

public String newStudentEnrollment(int courseId, int sId) {
	int result = enrollmentDao.newEnrollment(courseId, sId);

	return "number of rows inserted" + result;
}

public String studentResultUpdated(int courseId, int sId,double result) {
	int result1 = enrollmentDao.updateResult(result, courseId, sId);
	enrollmentDao.updateCompletedStatus(courseId, sId);
	System.out.println("service result "+result);
	return "number of rows Updated " + result1;
}

}
