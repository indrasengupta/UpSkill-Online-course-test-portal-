package upskill.ocm.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

//import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="subscription")
public class Subscription {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="sn_id",insertable = false, updatable = false)
	private int snId;
	private String snPlan;
	private int snDuration;
	private double snAmount;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subscription")
	private List<Subscribed> subscribedList;

	public Subscription() {
	}

	public int getSnId() {
		return snId;
	}

	public void setSnId(int snId) {
		this.snId = snId;
	}

	public String getSnPlan() {
		return snPlan;
	}

	public void setSnPlan(String snPlan) {
		this.snPlan = snPlan;
	}

	public int getSnDuration() {
		return snDuration;
	}

	public void setSnDuration(int snDuration) {
		this.snDuration = snDuration;
	}

	public double getSnAmount() {
		return snAmount;
	}

	public void setSnAmount(double snAmount) {
		this.snAmount = snAmount;
	}

	public List<Subscribed> getSubscribedList() {
		return subscribedList;
	}

	public void setSubscribedList(List<Subscribed> subscribedList) {
		this.subscribedList = subscribedList;
	}

	@Override
	public String toString() {
		return String.format("Subscription [snId=%s, snPlan=%s, snDuration=%s, snAmount=%s]", snId, snPlan, snDuration,
				snAmount);
	}

}