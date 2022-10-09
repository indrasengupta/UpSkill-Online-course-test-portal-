package upskill.ocm.dtos;

import java.util.Date;

public class SubscriptionDetailDto {
private	String planName;
private	double planCost;
private	int planDuration;
private	Date activationDate;
private	int daysLeft ;
private String planStatus;

public SubscriptionDetailDto() {

}

public SubscriptionDetailDto(String planName, double planCost, int planDuration, Date activationDate, int daysLeft,String planStatus) {
	super();
	this.planName = planName;
	this.planCost = planCost;
	this.planDuration = planDuration;
	this.activationDate = activationDate;
	this.daysLeft = daysLeft;
	this.planStatus=planStatus;
}

public String getPlanName() {
	return planName;
}

public void setPlanName(String planName) {
	this.planName = planName;
}

public double getPlanCost() {
	return planCost;
}

public void setPlanCost(double planCost) {
	this.planCost = planCost;
}

public int getPlanDuration() {
	return planDuration;
}

public void setPlanDuration(int planDuration) {
	this.planDuration = planDuration;
}

public Date getActivationDate() {
	return activationDate;
}

public void setActivationDate(Date activationDate) {
	this.activationDate = activationDate;
}

public int getDaysLeft() {
	return daysLeft;
}

public void setDaysLeft(int daysLeft) {
	this.daysLeft = daysLeft;
}



public String getPlanStatus() {
	return planStatus;
}

public void setPlanStatus(String planStatus) {
	this.planStatus = planStatus;
}

@Override
public String toString() {
	return String.format(
			"SubscriptionDetailDTO [planName=%s, planCost=%s, planDuration=%s, activationDate=%s, daysLeft=%s, planStatus=%s]",
			planName, planCost, planDuration, activationDate, daysLeft, planStatus);
}




}
