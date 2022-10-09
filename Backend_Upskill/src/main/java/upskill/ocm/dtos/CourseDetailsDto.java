package upskill.ocm.dtos;

import java.util.List;

import upskill.ocm.entities.Review;
import upskill.ocm.entities.Videos;

public class CourseDetailsDto {
	private int courseId;
	private String courseTitle;
	private String tags;
	private String prerequisite;
	private String syallbus;
	private String duration;
	private Double courseFee;
	private String faculty;
	private String video1;
	private String video1Name;
	private String video2;
	private String video2Name;
	private int lecturerId;
	private List<Videos> videosList;
	private List<Review> reviewList;
	private float avgRating;

	public CourseDetailsDto() {
	}
//id, courseTitle, prerequisite, syallbus, duration,
	// courseFee, facalty, video1, video1Name, video2, video2Name, videoList,
	// avgRatting

	public CourseDetailsDto(int courseId, String courseTitle, String tags, String prerequisite, String syallbus,
			String duration, Double courseFee, String faculty, String video1, String video1Name, String video2,
			String video2Name, int lecturerId, List<Videos> videosList, List<Review> reviewList, float avgRating) {
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.tags = tags;
		this.prerequisite = prerequisite;
		this.syallbus = syallbus;
		this.duration = duration;
		this.courseFee = courseFee;
		this.faculty = faculty;
		this.video1 = video1;
		this.video1Name = video1Name;
		this.video2 = video2;
		this.video2Name = video2Name;
		this.lecturerId = lecturerId;
		this.videosList = videosList;
		this.reviewList = reviewList;
		this.avgRating = avgRating;
	}

	public CourseDetailsDto(int courseId, String courseTitle, String prerequisite, String syallbus, String duration,
			Double courseFee, String faculty, String video1, String video1Name, String video2, String video2Name,
			List<Videos> videosList, List<Review> reviewList, float avgRating) {
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.prerequisite = prerequisite;
		this.syallbus = syallbus;
		this.duration = duration;
		this.courseFee = courseFee;
		this.faculty = faculty;
		this.video1 = video1;
		this.video1Name = video1Name;
		this.video2 = video2;
		this.video2Name = video2Name;
		this.videosList = videosList;
		this.reviewList = reviewList;
		this.avgRating = avgRating;
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

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getVideo1() {
		return video1;
	}

	public void setVideo1(String video1) {
		this.video1 = video1;
	}

	public String getVideo1Name() {
		return video1Name;
	}

	public void setVideo1Name(String video1Name) {
		this.video1Name = video1Name;
	}

	public String getVideo2() {
		return video2;
	}

	public void setVideo2(String video2) {
		this.video2 = video2;
	}

	public String getVideo2Name() {
		return video2Name;
	}

	public void setVideo2Name(String video2Name) {
		this.video2Name = video2Name;
	}

	public int getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(int lecturerId) {
		this.lecturerId = lecturerId;
	}

	public List<Videos> getVideosList() {
		return videosList;
	}

	public void setVideosList(List<Videos> videosList) {
		this.videosList = videosList;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public float getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(float avgRating) {
		this.avgRating = avgRating;
	}

	@Override
	public String toString() {
		return String.format(
				"CourseDetailsDto [courseId=%s, courseTitle=%s, tags=%s, prerequisite=%s, syallbus=%s, duration=%s, courseFee=%s, faculty=%s, video1=%s, video1Name=%s, video2=%s, video2Name=%s, lecturerId=%s, videosList=%s, reviewList=%s, avgRating=%s]",
				courseId, courseTitle, tags, prerequisite, syallbus, duration, courseFee, faculty, video1, video1Name,
				video2, video2Name, lecturerId, videosList, reviewList, avgRating);
	}

}
