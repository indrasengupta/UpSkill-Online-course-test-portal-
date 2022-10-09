package upskill.ocm.dtos;

public class AdminDto {
	private int adminId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
	
	public AdminDto() {
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return String.format("AdminDto [adminId=%s, firstName=%s, lastName=%s, email=%s, password=%s, role=%s]",
				adminId, firstName, lastName, email, password, role);
	}

}
