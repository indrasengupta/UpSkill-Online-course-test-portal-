package upskill.ocm.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import upskill.ocm.entities.Questionbank;

public interface QuestionbankDao extends JpaRepository<Questionbank, Integer>{
	@Modifying
	@Query(value="insert into questionbank(answer,option1,option2,option3,option4,question,course_id) values(?,?,?,?,?,?,?)",nativeQuery=true)
	public void saveTest(String answer,String option1,String option2,String option3,String option4,String question,int course_id);
	
	@Query(value="select * from questionbank where course_id=? Limit 10",nativeQuery=true)
	public List<Questionbank> getTest(int id);
}
