package upskill.ocm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="admin")
public class Admin {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="a_id",insertable = false, updatable = false)
	private int adminId;
	private String firstName;
	private String lastName;
	@Column(name="email", unique=true)
	@NotNull
	private String email;
	@Column(length=600)
	@NotNull
	private String password;
	@ColumnDefault("'admin'")
	@Column(insertable=false)
	private String role="admin";
	@ColumnDefault("0")
	private byte isActive;

	public Admin() {
	}

	public Admin(String firstName, String lastName, @NotEmpty String email, @NotEmpty String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
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
		this.role = "admin";
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return String.format("Admin [adminId=%s, firstName=%s, lastName=%s, email=%s, role=%s, isActive=%s]", adminId,
				firstName, lastName, email, role, isActive);
	}

}
