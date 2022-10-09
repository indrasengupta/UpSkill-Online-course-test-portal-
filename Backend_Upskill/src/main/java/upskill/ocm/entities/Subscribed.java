package upskill.ocm.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Subscribed {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "sd_id")
	private int sdId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "sn_id")
	private Subscription subscription;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "l_id")
	private Lecturer lecturer;

//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name = "sn_id")
//	private Subscription subscription;
//	
//	@JsonManagedReference
//	@ManyToOne
//	@JoinColumn(name = "l_id")
//	private Lecturer lecturer ;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdtimestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
	private Date createdtimestamp;

	public Subscribed() {
	}

	public Subscribed(Subscription subscription, Lecturer lecturer) {
		super();
		this.subscription = subscription;
		this.lecturer = lecturer;
	}

	public Subscribed(int sdId) {
		this.sdId = sdId;
	}

	public int getSdId() {
		return sdId;
	}

	public void setSdId(int sdId) {
		this.sdId = sdId;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Date getCreatedtimestamp() {
		return createdtimestamp;
	}

	public void setCreatedtimestamp(Date createdtimestamp) {
		this.createdtimestamp = createdtimestamp;
	}

	@Override
	public String toString() {
		return String.format("Subscribed [sdId=%s, subscription=%s, lecturer=%s, createdtimestamp=%s]", sdId,
				subscription, lecturer, createdtimestamp);
	}

}