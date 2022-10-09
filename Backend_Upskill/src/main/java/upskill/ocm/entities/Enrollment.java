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

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="enrollment")
public class Enrollment {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="e_id",insertable = false, updatable = false)
	private int enrollId;
	@ColumnDefault("0")
	private byte isCompleted;
	@ColumnDefault("0")
	private double result;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdtimestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
	private Date createdtimestamp;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "course_id")
//	private CourseContent coursecontent;
//		
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "s_id")
//	private Student student;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "course_id")
	private CourseContent coursecontent;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "s_id")
	private Student student;
	
	public Enrollment() {
	}

	public int getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(int enrollId) {
		this.enrollId = enrollId;
	}

	public byte getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(byte isCompleted) {
		this.isCompleted = isCompleted;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return String.format("Enrollment [enrollId=%s, isCompleted=%s, result=%s, createdtimestamp=%s]",
				enrollId, isCompleted, result, createdtimestamp);
	}

}
