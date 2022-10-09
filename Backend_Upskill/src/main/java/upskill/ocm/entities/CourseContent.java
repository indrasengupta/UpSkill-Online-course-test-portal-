package upskill.ocm.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="course_content")
public class CourseContent {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="course_id",insertable = false, updatable = false)
	private int courseId;
	private String courseTitle;
	private String tags;
	@Column(columnDefinition = "TEXT")
	private String prerequisite;
	@Column(columnDefinition = "TEXT")
	private String syallbus;
	private String duration;
	private Double courseFee;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdtimestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
	private Date createdtimestamp;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "l_id")
//	private Lecturer lecturer;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "l_id")
	private Lecturer lecturer;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "coursecontent")
	private List<Videos> videosList;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "coursecontent")
	private List<Rating> ratingList;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "coursecontent")
	private List<Review> reviewList;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "coursecontent")
	private List<Questionbank> questionList;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "coursecontent")
	private List<Enrollment> enrollmentList;
	
	public CourseContent() {
	}

	public CourseContent(int courseId, String courseTitle, String tags, String prerequisite, String syallbus,
			String duration, Double courseFee, Date createdtimestamp, Lecturer lecturer, List<Videos> videosList,
			List<Rating> ratingList, List<Review> reviewList, List<Questionbank> questionList,
			List<Enrollment> enrollmentList) {
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.tags = tags;
		this.prerequisite = prerequisite;
		this.syallbus = syallbus;
		this.duration = duration;
		this.courseFee = courseFee;
		this.createdtimestamp = createdtimestamp;
		this.lecturer = lecturer;
		this.videosList = videosList;
		this.ratingList = ratingList;
		this.reviewList = reviewList;
		this.questionList = questionList;
		this.enrollmentList = enrollmentList;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

	public String getSyallbus() {
		return syallbus;
	}

	public void setSyallbus(String syallbus) {
		this.syallbus = syallbus;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(Double courseFee) {
		this.courseFee = courseFee;
	}

	public Date getCreatedtimestamp() {
		return createdtimestamp;
	}

	public void setCreatedtimestamp(Date createdtimestamp) {
		this.createdtimestamp = createdtimestamp;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public List<Videos> getVideosList() {
		return videosList;
	}

	public void setVideosList(List<Videos> videosList) {
		this.videosList = videosList;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public List<Questionbank> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Questionbank> questionList) {
		this.questionList = questionList;
	}

	public List<Enrollment> getEnrollmentList() {
		return enrollmentList;
	}

	public void setEnrollmentList(List<Enrollment> enrollmentList) {
		this.enrollmentList = enrollmentList;
	}

	@Override
	public String toString() {
		return String.format(
				"CourseContent [courseId=%s, courseTitle=%s, tags=%s, prerequisite=%s, syallbus=%s, duration=%s, courseFee=%s, createdtimestamp=%s]",
				courseId, courseTitle, tags, prerequisite, syallbus, duration, courseFee, createdtimestamp);
	}

}