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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="lecturer")
public class Lecturer {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="l_id",insertable = false, updatable = false)
	private int lecturerId;
	private String firstName;
	private String lastName;
	@Column(name="email", unique=true)
	@NotNull
	private String email;
	@Column(length=600)
	@NotNull
	private String password;
	private String gender;
	@Length(max = 10)
	private String phone;
	private String qualification;
	private int experience;
	@ColumnDefault("'lecturer'")
	@Column(insertable=false)
	private String role="lecturer";
	@ColumnDefault("0")
	private byte isActive;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdtimestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
	private Date createdtimestamp;
	@ColumnDefault("0")
	private byte isDeleted;
	
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "lecturer")
//	private Subscribed subscribed;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lecturer")
	private List<Subscribed> subscribedList;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lecturer")
	private List<CourseContent> coursecontentList;
	
//	@OneToMany(mappedBy = "lecturer")
//	private List<CourseContent> coursecontentList;
	
	public Lecturer() {
	}
	
	public Lecturer(String firstName, String lastName, @NotEmpty String email, @NotEmpty String password, String gender,
			String phone, String qualification, int experience) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.qualification = qualification;
		this.experience = experience;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = "lecturer";
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedtimestamp() {
		return createdtimestamp;
	}

	public void setCreatedtimestamp(Date createdtimestamp) {
		this.createdtimestamp = createdtimestamp;
	}

	public byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<Subscribed> getSubscribedList() {
		return subscribedList;
	}

	public void setSubscribedList(List<Subscribed> subscribedList) {
		this.subscribedList = subscribedList;
	}

	public List<CourseContent> getCoursecontentList() {
		return coursecontentList;
	}

	public void setCoursecontentList(List<CourseContent> coursecontentList) {
		this.coursecontentList = coursecontentList;
	}

	@Override
	public String toString() {
		return String.format(
				"Lecturer [lecturerId=%s, firstName=%s, lastName=%s, email=%s, password=%s, gender=%s, phone=%s, qualification=%s, experience=%s, role=%s, isActive=%s, createdtimestamp=%s, isDeleted=%s, subscribedList=%s, coursecontentList=%s]",
				lecturerId, firstName, lastName, email, password, gender, phone, qualification, experience, role,
				isActive, createdtimestamp, isDeleted, subscribedList, coursecontentList);
	}

}
