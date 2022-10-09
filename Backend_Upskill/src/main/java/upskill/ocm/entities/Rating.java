package upskill.ocm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="rating")
public class Rating {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="rating_id",insertable = false, updatable = false)
	private int ratingId;
	private float rating;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "course_id")
//	private CourseContent coursecontent;
	
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

	public Rating() {
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
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
		return String.format("Rating [ratingId=%s, rating=%s]", ratingId, rating);
	}

}