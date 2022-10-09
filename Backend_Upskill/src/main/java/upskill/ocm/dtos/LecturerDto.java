package upskill.ocm.dtos;

public class LecturerDto {
	private int lecturerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
	private String phone;
	private String qualification;
	private int experience;
	private byte isDeleted;
	private String role;
	private byte isActive;
	
	public LecturerDto() {
	}
	
	public int getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(int lecturerId) {
		this.lecturerId = lecturerId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return String.format(
				"LecturerDto [lecturerId=%s, firstName=%s, lastName=%s, email=%s, password=%s, gender=%s, phone=%s, qualification=%s, experience=%s, isDeleted=%s, role=%s, isActive=%s]",
				lecturerId, firstName, lastName, email, password, gender, phone, qualification, experience, isDeleted,
				role, isActive);
	}
	
}
