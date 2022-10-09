package upskill.ocm.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upskill.ocm.daos.AdminDao;
import upskill.ocm.daos.LecturerDao;
import upskill.ocm.dtos.AdminDto;
import upskill.ocm.dtos.Credentials;
import upskill.ocm.dtos.DtoEntityConverter;
import upskill.ocm.entities.Admin;
import upskill.ocm.entities.Lecturer;

@Service
@Transactional
public class AdminServiceImpl {
	@Autowired
	private DtoEntityConverter dtoEntityConverter;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private LecturerDao lecturerDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public AdminDto saveAdmin(AdminDto adminDto) {
		String rawPassword = adminDto.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		
		adminDto.setPassword(encPassword);
		Admin admin = dtoEntityConverter.toAdminEntity(adminDto);
		admin = adminDao.save(admin);
		adminDto = dtoEntityConverter.toAdminDto(admin);
		adminDto.setPassword("*******");
		return adminDto;
	}

	public AdminDto getAdminByEmail(String adminEmail ) {
		Admin admin = adminDao.findByEmail(adminEmail);
		AdminDto adminDto = dtoEntityConverter.toAdminDto(admin);
		return adminDto;
	}

	public AdminDto getAdminByEmailAndPassword(Credentials cred ) {
		Admin dbAdmin = adminDao.findByEmail(cred.getEmail());
		String rawPassword = cred.getPassword();
		if(dbAdmin != null && passwordEncoder.matches(rawPassword, dbAdmin.getPassword())) {
			AdminDto result = dtoEntityConverter.toAdminDto(dbAdmin);
			result.setPassword("********");
			return result;
		}
		return null;
	}
	
	public AdminDto getAdminProfile(int id) {
		Admin dbAdmin = adminDao.findByAdminId(id);
		if(dbAdmin != null) {
			AdminDto result = dtoEntityConverter.toAdminDto(dbAdmin);
			return result;
		}
		return null;
	}
	
	public Map<String, Object> updateAdmin(int adminId, AdminDto adminDto) {
		if (adminDao.existsById(adminId)) {
			adminDto.setAdminId(adminId);
			String rawPassword = adminDto.getPassword();
			String encPassword = passwordEncoder.encode(rawPassword);
			adminDto.setPassword(encPassword);
			Admin admin = dtoEntityConverter.toAdminEntity(adminDto);
			admin = adminDao.save(admin);
			return Collections.singletonMap("changedRows", 1);
		}
		return Collections.singletonMap("changedRows", 0);
	}
	
	public List<Lecturer> findLecturer(){
		List<Lecturer> lect=lecturerDao.findAll();
		return lect;
	}
	
	public Map<String,Object> removeLecturer(int id) {
		if(lecturerDao.existsById(id)) {
		lecturerDao.deleteById(id);
		return Collections.singletonMap("AffectedRows", 1);
		}
		return Collections.singletonMap("AffectedRows", 0);
	}
}
