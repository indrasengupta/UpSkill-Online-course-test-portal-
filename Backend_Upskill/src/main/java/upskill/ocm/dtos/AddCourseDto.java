package upskill.ocm.dtos;

public class AddCourseDto {

	private String courseTitle;
	private String tags;
	private String prerequisite;
	private String syallbus;
	private Double courseFee;
	private String duration;
	private int lecturerId;
	private String videoName1;
	private String videourl1;
	private String videoName2;
	private String videourl2;
	
	public AddCourseDto() {
		
	}

	public AddCourseDto(String courseTitle, String tags, String prerequisite, String syallbus, Double courseFee,
			String duration, int lecturerId, String videoName1, String videourl1, String videoName2, String videourl2) {
		super();
		this.courseTitle = courseTitle;
		this.tags = tags;
		this.prerequisite = prerequisite;
		this.syallbus = syallbus;
		this.courseFee = courseFee;
		this.duration = duration;
		this.lecturerId = lecturerId;
		this.videoName1 = videoName1;
		this.videourl1 = videourl1;
		this.videoName2 = videoName2;
		this.videourl2 = videourl2;
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

	public Double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(Double courseFee) {
		this.courseFee = courseFee;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(int lecturerId) {
		this.lecturerId = lecturerId;
	}

	public String getVideoName1() {
		return videoName1;
	}

	public void setVideoName1(String videoName1) {
		this.videoName1 = videoName1;
	}

	public String getVideourl1() {
		return videourl1;
	}

	public void setVideourl1(String videourl1) {
		this.videourl1 = videourl1;
	}

	public String getVideoName2() {
		return videoName2;
	}

	public void setVideoName2(String videoName2) {
		this.videoName2 = videoName2;
	}

	public String getVideourl2() {
		return videourl2;
	}

	public void setVideourl2(String videourl2) {
		this.videourl2 = videourl2;
	}

	@Override
	public String toString() {
		return String.format(
				"AddCourseDto [courseTitle=%s, tags=%s, prerequisite=%s, syallbus=%s, courseFee=%s, duration=%s, lecturerId=%s, videoName1=%s, videourl1=%s, videoName2=%s, videourl2=%s]",
				courseTitle, tags, prerequisite, syallbus, courseFee, duration, lecturerId, videoName1, videourl1,
				videoName2, videourl2);
	}
	
		
	
}
