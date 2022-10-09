package upskill.ocm.dtos;

public class CourseDto {
		private int courseId;
		private String title;
		private Double fee;
		private	String firstName;
		private	String lastName;
		private	String duration;
		private	float avgRating;
		
		public CourseDto() {
		}

		public CourseDto(int courseId, String title, Double fee, String firstName, String lastName, String duration,
				float avgRating) {
			super();
			this.courseId = courseId;
			this.title = title;
			this.fee = fee;
			this.firstName = firstName;
			this.lastName = lastName;
			this.duration = duration;
			this.avgRating = avgRating;
		}



		public int getCourseId() {
			return courseId;
		}



		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}



		public String getTitle() {
			return title;
		}



		public void setTitle(String title) {
			this.title = title;
		}



		public Double getFee() {
			return fee;
		}



		public void setFee(Double fee) {
			this.fee = fee;
		}



		public String getFirstName() {
			return firstName;
		}



		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}



		public String getLastName() {
			return lastName;
		}



		public void setLastName(String lastName) {
			this.lastName = lastName;
		}



		public String getDuration() {
			return duration;
		}



		public void setDuration(String duration) {
			this.duration = duration;
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
					"CourseDto [courseId=%s, title=%s, fee=%s, firstName=%s, lastName=%s, duration=%s, avgRating=%s]",
					courseId, title, fee, firstName, lastName, duration, avgRating);
		}

}
