package upskill.ocm.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import upskill.ocm.entities.CourseContent;

public interface CourseContentDao extends JpaRepository<CourseContent, Integer>{
	//CourseContent findCourseContentById(int id);
	CourseContent findByCourseId(int id);
	@Modifying
	@Query(value="insert into course_content(course_title,course_fee,duration,prerequisite,syallbus,tags,l_id) values(?,?,?,?,?,?,?)",nativeQuery=true)
		public int saveCourseContent(String courseTitle,double courseFee,String duration,String prerequisite,String syallbus,String tags,int l_id);

}
