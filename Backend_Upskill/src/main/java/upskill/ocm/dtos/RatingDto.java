package upskill.ocm.dtos;

public class RatingDto {
	private String rating;
	private int courseId;
	private int studentId;
	
	public RatingDto() {
	}

	public RatingDto(String rating, int courseId, int studentId) {
		this.rating = rating;
		this.courseId = courseId;
		this.studentId = studentId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return String.format("RatingDto [rating=%s, courseId=%s, studentId=%s]", rating, courseId, studentId);
	}

}
