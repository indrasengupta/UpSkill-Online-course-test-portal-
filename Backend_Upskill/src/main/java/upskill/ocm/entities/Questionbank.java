package upskill.ocm.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="questionbank")
public class Questionbank {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="q_id",insertable = false, updatable = false)
	private int qId;
	private String question;  
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String  answer;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdtimestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
	private Date createdtimestamp;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "course_id")
//	private CourseContent coursecontent;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "course_id")
	private CourseContent coursecontent;
	
	public Questionbank() {	
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getCreatedtimestamp() {
		return createdtimestamp;
	}

	public void setCreatedtimestamp(Date createdtimestamp) {
		this.createdtimestamp = createdtimestamp;
	}

	public CourseContent getCoursecontent() {
		return coursecontent;
	}

	public void setCoursecontent(CourseContent coursecontent) {
		this.coursecontent = coursecontent;
	}

	@Override
	public String toString() {
		return String.format(
				"Questionbank [qId=%s, question=%s, option1=%s, option2=%s, option3=%s, option4=%s, answer=%s, createdtimestamp=%s]",
				qId, question, option1, option2, option3, option4, answer, createdtimestamp);
	}

}