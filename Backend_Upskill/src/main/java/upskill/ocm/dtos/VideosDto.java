package upskill.ocm.dtos;

import java.util.Date;

public class VideosDto {

	private int videoId;
	private String vName;
	private String video;
	private int courseId;
	
	private Date createdtimestamp;
	
//	private CourseContent coursecontent;

	public VideosDto() {
	
	}

	public VideosDto(int videoId, String vName, String video, int courseId, Date createdtimestamp
			) {
		super();
		this.videoId = videoId;
		this.vName = vName;
		this.video = video;
		this.courseId = courseId;
		this.createdtimestamp = createdtimestamp;
		
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Date getCreatedtimestamp() {
		return createdtimestamp;
	}

	public void setCreatedtimestamp(Date createdtimestamp) {
		this.createdtimestamp = createdtimestamp;
	}

	

	@Override
	public String toString() {
		return String.format(
				"VideoDto [videoId=%s, vName=%s, video=%s, courseId=%s, createdtimestamp=%s]",
				videoId, vName, video, courseId, createdtimestamp);
	}
	
	
}
