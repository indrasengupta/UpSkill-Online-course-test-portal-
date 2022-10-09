package upskill.ocm.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import upskill.ocm.entities.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{
	Student findByStudentId(int id);
	Student findByEmail(String email);
	@Query(value="select course_id from enrollment e where e.s_id=?",nativeQuery=true)
	List<Integer>findCourseIdByStudentId(int studentId);
}
