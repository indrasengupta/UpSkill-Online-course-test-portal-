package upskill.ocm.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import upskill.ocm.entities.Rating;

public interface RatingDao extends JpaRepository<Rating, Integer>{
	@Modifying
	@Query(value="INSERT INTO RATING(rating,course_id,s_id) VALUES(?,?,?)",nativeQuery=true)
	int saveRating(String rating, int courseId, int studentId);
	
	@Modifying
	@Query(value="UPDATE RATING SET rating=? WHERE course_id=? AND s_id=?",nativeQuery=true)
	int updateRating(String rating, int courseId, int studentId);
	
	@Query(value="SELECT * FROM Rating WHERE course_id=? AND s_id=?",nativeQuery=true)
	Rating getRatingByCourseIdAndStudentId(int courseId, int studentId);
}
