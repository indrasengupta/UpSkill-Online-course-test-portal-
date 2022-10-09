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
@Table(name="videos")
public class Videos {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="v_id",insertable = false, updatable = false)
	private int videoId;
	private String vName;
	private String video;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdtimestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
	private Date createdtimestamp;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "course_id")
//	private CourseContent coursecontent;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "course_id")
	private CourseContent coursecontent;

	public Videos() {
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

	@Override
	public String toString() {
		return String.format("Videos [videoId=%s, vName=%s, video=%s, createdtimestamp=%s, coursecontent=%s]", videoId,
				vName, video, createdtimestamp, coursecontent);
	}
	
	

}