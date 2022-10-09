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
@Table(name="review")
public class Review {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="review_id",insertable = false, updatable = false)
	private int reviewId;
	private String review;
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
	
	public Review() {
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
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
		return String.format("Review [reviewId=%s, review=%s, createdtimestamp=%s]", reviewId, review,
				createdtimestamp);
	}

}