package upskill.ocm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import upskill.ocm.daos.StudentDao;
import upskill.ocm.dtos.Credentials;
import upskill.ocm.dtos.DtoEntityConverter;
import upskill.ocm.dtos.StudentDto;
import upskill.ocm.entities.Student;

@SpringBootTest
class UpskillApplicationTests {
@Autowired
private StudentDao studentDao;
@Autowired
private DtoEntityConverter dtoEntityConverter;
@Autowired
private Credentials cred;
	@Test
	public StudentDto getStudentByEmialAndPassword(Credentials cred ) {
		Student dbStudent = studentDao.findByEmail(cred.getEmail());
//		String rawPassword = cred.getPassword();
//		if(dbStudent != null && passwordEncoder.matches(rawPassword, dbStudent.getPassword())) {
//			StudentDto result = dtoEntityConverter.toStudentDto(dbStudent);
//			result.setPassword("********");
//			return result;
//		}
		if(dbStudent!=null&&cred.getPassword().equals(dbStudent.getPassword())) {
			StudentDto result = dtoEntityConverter.toStudentDto(dbStudent);
			System.out.println(result);
			return result;
		}
		return null;
	}
	
}
