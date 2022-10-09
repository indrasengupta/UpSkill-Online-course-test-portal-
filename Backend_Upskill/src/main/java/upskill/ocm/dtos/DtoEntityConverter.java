package upskill.ocm.dtos;

import org.springframework.stereotype.Component;

import upskill.ocm.entities.Admin;
import upskill.ocm.entities.CourseContent;
import upskill.ocm.entities.Lecturer;
import upskill.ocm.entities.Student;

@Component
public class DtoEntityConverter {

	public Student toStudentEntity(StudentDto studentDto) {
		Student student = new Student();
		student.setStudentId(studentDto.getStudentId());
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		student.setPassword(studentDto.getPassword());
		student.setGender(studentDto.getGender());
		student.setPhone(studentDto.getPhone());
		student.setDateOfBirth(studentDto.getDateOfBirth());
		student.setAddress(studentDto.getAddress());
		student.setDistrict(studentDto.getDistrict());
		student.setPincode(studentDto.getPincode());
		return student;
	}

	public StudentDto toStudentDto(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setStudentId(student.getStudentId());
		studentDto.setFirstName(student.getFirstName());
		studentDto.setLastName(student.getLastName());
		studentDto.setEmail(student.getEmail());
		studentDto.setPassword(student.getPassword());
		studentDto.setGender(student.getGender());
		studentDto.setPhone(student.getPhone());
		studentDto.setDateOfBirth(student.getDateOfBirth());
		studentDto.setAddress(student.getAddress());
		studentDto.setDistrict(student.getDistrict());
		studentDto.setPincode(student.getPincode());
		studentDto.setRole(student.getRole());
		return studentDto;
	}

	public Lecturer toLecturerEntity(LecturerDto lecturerDto) {
		Lecturer lecturer = new Lecturer();
		lecturer.setLecturerId(lecturerDto.getLecturerId());
		lecturer.setFirstName(lecturerDto.getFirstName());
		lecturer.setLastName(lecturerDto.getLastName());
		lecturer.setEmail(lecturerDto.getEmail());
		lecturer.setPassword(lecturerDto.getPassword());
		lecturer.setGender(lecturerDto.getGender());
		lecturer.setPhone(lecturerDto.getPhone());
		lecturer.setQualification(lecturerDto.getQualification());
		lecturer.setExperience(lecturerDto.getExperience());
		lecturer.setIsDeleted(lecturerDto.getIsDeleted());
		return lecturer;
	}

	public LecturerDto toLecturerDto(Lecturer lecturer) {
		LecturerDto lecturerDto = new LecturerDto();
		lecturerDto.setLecturerId(lecturer.getLecturerId());
		lecturerDto.setFirstName(lecturer.getFirstName());
		lecturerDto.setLastName(lecturer.getLastName());
		lecturerDto.setEmail(lecturer.getEmail());
		lecturerDto.setPassword(lecturer.getPassword());
		lecturerDto.setGender(lecturer.getGender());
		lecturerDto.setPhone(lecturer.getPhone());
		lecturerDto.setQualification(lecturer.getQualification());
		lecturerDto.setExperience(lecturer.getExperience());
		lecturerDto.setIsDeleted(lecturer.getIsDeleted());
		lecturerDto.setRole(lecturer.getRole());
		return lecturerDto;
	}

	public Admin toAdminEntity(AdminDto adminDto) {
		Admin admin = new Admin();
		admin.setAdminId(adminDto.getAdminId());
		admin.setFirstName(adminDto.getFirstName());
		admin.setLastName(adminDto.getLastName());
		admin.setEmail(adminDto.getEmail());
		admin.setPassword(adminDto.getPassword());
		return admin;
	}

	public AdminDto toAdminDto(Admin admin) {
		AdminDto adminDto = new AdminDto();
		adminDto.setAdminId(admin.getAdminId());
		adminDto.setFirstName(admin.getFirstName());
		adminDto.setLastName(admin.getLastName());
		adminDto.setEmail(admin.getEmail());
		adminDto.setPassword(admin.getPassword());
		adminDto.setRole(admin.getRole());
		return adminDto;
	}

	public CourseDetailsDto toCourseContentDto(CourseContent courseContent) {
		CourseDetailsDto courseContentDto = new CourseDetailsDto();
		courseContentDto.setCourseId(courseContent.getCourseId());
		courseContentDto.setCourseTitle(courseContent.getCourseTitle());
		courseContentDto.setPrerequisite(courseContent.getPrerequisite());
		courseContentDto.setTags(courseContent.getTags());
		courseContentDto.setSyallbus(courseContent.getSyallbus());
		courseContentDto.setDuration(courseContent.getDuration());
		courseContentDto.setCourseFee(courseContent.getCourseFee());
		courseContentDto.setVideosList(courseContent.getVideosList());
		courseContentDto.setReviewList(courseContent.getReviewList());
		return courseContentDto;
	}

	public CourseDetailsDto toCourseContentByStudentDTO(CourseContent entity) {
		if (entity == null)
			return null;
		CourseDetailsDto dto = new CourseDetailsDto();
		dto.setCourseId(entity.getCourseId());
		dto.setCourseTitle(entity.getCourseTitle());
		dto.setPrerequisite(entity.getPrerequisite());
		dto.setTags(entity.getTags());
		dto.setSyallbus(entity.getSyallbus());
		dto.setDuration(entity.getDuration());
		dto.setCourseFee(entity.getCourseFee());
		return dto;
	}

	public CourseContent toCourseContentEntity(CourseDetailsDto dto) {
		CourseContent entity = new CourseContent();
		entity.setCourseId(dto.getCourseId());
		entity.setCourseTitle(dto.getCourseTitle());
		entity.setDuration(dto.getDuration());
		entity.setTags(dto.getTags());
		entity.setSyallbus(dto.getSyallbus());
		entity.setPrerequisite(dto.getPrerequisite());
		entity.setCourseFee(dto.getCourseFee());
		return entity;
	}
	
	public CourseContent toCourseContent(CourseDetailsDto addCourseDto) {
		CourseContent courseContent=new CourseContent();
		courseContent.setCourseTitle(addCourseDto.getCourseTitle());
		courseContent.setTags(addCourseDto.getTags());
		courseContent.setPrerequisite(addCourseDto.getPrerequisite());
		courseContent.setSyallbus(addCourseDto.getSyallbus());
		courseContent.setCourseFee(addCourseDto.getCourseFee());
		courseContent.setDuration(addCourseDto.getDuration());
		//courseContent.setLecturer(addCourseDto.getLecturerId());
		
		return courseContent;
	}

	public CourseDetailsDto toAddCourseDto(CourseContent courseContent) {
		CourseDetailsDto addCourseDto=new CourseDetailsDto();
		addCourseDto.setCourseTitle(courseContent.getCourseTitle());
		addCourseDto.setTags(courseContent.getTags());
		addCourseDto.setPrerequisite(courseContent.getPrerequisite());
		addCourseDto.setSyallbus(courseContent.getSyallbus());
		addCourseDto.setCourseFee(courseContent.getCourseFee());
		
		return addCourseDto;
	}
}
