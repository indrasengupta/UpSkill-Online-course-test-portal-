package upskill.ocm.dtos;

public class ReviewDto {
	private String review;
	private int courseId;
	private int studentId;
	
	public ReviewDto() {
	}

	public ReviewDto(String review, int courseId, int studentId) {
		this.review = review;
		this.courseId = courseId;
		this.studentId = studentId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
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
		return String.format("ReviewDto [review=%s, courseId=%s, studentId=%s]", review, courseId, studentId);
	}
	
}
