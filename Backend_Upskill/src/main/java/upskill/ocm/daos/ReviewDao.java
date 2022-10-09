package upskill.ocm.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import upskill.ocm.dtos.ReviewDto;
import upskill.ocm.entities.Review;

public interface ReviewDao extends JpaRepository<Review, Integer> {
	@Modifying
	@Query(value="INSERT INTO REVIEW(review,course_id,s_id) VALUES(?,?,?)",nativeQuery=true)
	int saveReview(String review, int courseId, int studentId);
	
	@Modifying
	@Query(value="UPDATE REVIEW SET review=? WHERE course_id=? AND s_id=?",nativeQuery=true)
	int updateReview(String review, int courseId, int studentId);
	
	@Query(value="SELECT * FROM REVIEW WHERE course_id=? AND s_id=?",nativeQuery=true)
	Review getReviewByCourseIdAndStudentId(int courseId, int studentId);
	
	@Query(value="select r.review, r.course_id, r.s_id, s.first_name, s.last_name from review r join student s on r.s_id=s.s_id where course_id=?",nativeQuery=true)
	List<ReviewDto> getReviewListByCourseId(int courseId);
}
