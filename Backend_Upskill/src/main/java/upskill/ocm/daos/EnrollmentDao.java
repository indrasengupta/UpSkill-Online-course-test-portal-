package upskill.ocm.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import upskill.ocm.entities.Enrollment;

public interface EnrollmentDao extends JpaRepository<Enrollment, Integer>{
	@Modifying
	@Query(value="select * from enrollment where s_id=?" , nativeQuery = true)
	List<Enrollment> enrollmentListByStudentId(int id);
	
	@Modifying
	@Query(value=" insert into enrollment (course_id,s_id) values (?1,?2)" , nativeQuery = true)
	int newEnrollment(int courseId,int sId);

	@Modifying
	@Query(value="update enrollment set result=?  where course_id=? and s_id=?" , nativeQuery = true)
	int updateResult(double result, int courseId, int sId);
	
	@Modifying
	@Query(value="update enrollment set is_completed=1  where course_id=? and s_id=?" , nativeQuery = true)
	void updateCompletedStatus(int courseId, int sId);
}
