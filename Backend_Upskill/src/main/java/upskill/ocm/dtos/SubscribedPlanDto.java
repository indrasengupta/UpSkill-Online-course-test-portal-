package upskill.ocm.dtos;

public class SubscribedPlanDto {

	private int lId;
	private int SnId;
	private String firstName;
	private String lastName;
	private String email;
	private double snAmount;
	private String snPlan;
	private String snDuration;
	
	
	
	public SubscribedPlanDto() {
		
	}



	public int getlId() {
		return lId;
	}



	public void setlId(int lId) {
		this.lId = lId;
	}



	public int getSnId() {
		return SnId;
	}



	public void setSnId(int snId) {
		SnId = snId;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public double getSnAmount() {
		return snAmount;
	}



	public void setSnAmount(double snAmount) {
		this.snAmount = snAmount;
	}



	public String getSnPlan() {
		return snPlan;
	}



	public void setSnPlan(String snPlan) {
		this.snPlan = snPlan;
	}



	public String getSnDuration() {
		return snDuration;
	}



	public void setSnDuration(String snDuration) {
		this.snDuration = snDuration;
	}



	@Override
	public String toString() {
		return String.format(
				"Your plan Details are as follows \n lecturerId is = %s \n SnId = %s \n  FirstName = %s \n lastName = %s \n email = %s \n snAmount = %s \n  snPlan = %s \n snDuration = %s ",
				lId, SnId, firstName, lastName, email, snAmount, snPlan, snDuration);
	}
	
	
	
}
