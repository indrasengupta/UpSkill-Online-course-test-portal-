package upskill.ocm.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="student")
public class Student {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="s_id",insertable = false, updatable = false)
	private int studentId;
	private String firstName;
	private String lastName;
	@NotNull
	@Column(name="email", unique=true)
	private String email;
	@NotNull
	@Column(length=600)
	private String password;
	private String gender;
	@Length(max = 10)  
	private String phone;
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private String address;
	private String district;
	private int pincode;
	@ColumnDefault("'student'")
//	@Column(insertable=false)
	private String role="student";
	@ColumnDefault("0")
	private byte isActive;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdtimestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
	private Date createdTimestamp;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Review> reviewList;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Rating> ratingList;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Enrollment> enrollmentList;
	
	public Student() {
	}
	
	public Student(String firstName, String lastName, String email, String password, String gender, String phone,
			Date dateOfBirth, String address, String district, int pincode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.district = district;
		this.pincode = pincode;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = "student";
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

	public List<Enrollment> getEnrollmentList() {
		return enrollmentList;
	}

	public void setEnrollmentList(List<Enrollment> enrollmentList) {
		this.enrollmentList = enrollmentList;
	}

	@Override
	public String toString() {
		return String.format(
				"Student [studentId=%s, firstName=%s, lastName=%s, email=%s, password=%s, gender=%s, phone=%s, dateOfBirth=%s, address=%s, district=%s, pincode=%s, role=%s, isActive=%s, createdTimestamp=%s]",
				studentId, firstName, lastName, email, password, gender, phone, dateOfBirth, address, district, pincode,
				role, isActive, createdTimestamp);
	}

}
