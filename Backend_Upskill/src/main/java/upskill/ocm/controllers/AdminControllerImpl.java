package upskill.ocm.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import upskill.ocm.dtos.AdminDto;
import upskill.ocm.dtos.Credentials;
import upskill.ocm.dtos.Demo;
import upskill.ocm.dtos.Response;
import upskill.ocm.entities.Lecturer;
import upskill.ocm.services.AdminServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class AdminControllerImpl {
	@Autowired
	private AdminServiceImpl adminService;

	@PostMapping("/admin/signup")
	public ResponseEntity<?> adminSignUp(@RequestBody AdminDto adminDto) {
		AdminDto result = adminService.saveAdmin(adminDto);
		return Response.success(result);
	}

	@PostMapping("/admin/login")
	public ResponseEntity<?> adminLogin(@RequestBody Credentials cred) {
		AdminDto result = adminService.getAdminByEmailAndPassword(cred);
		if(result==null)
			return Response.error("Admin not found!!!");
		return Response.success(result);
	}
	
	@GetMapping("/admin/profile/{id}")
	public ResponseEntity<?> adminProfile(@PathVariable("id") int id) {
		AdminDto result = adminService.getAdminProfile(id);
		if(result==null)
			return Response.error("Admin not found!!!");
		return Response.success(result);
	}
	
	@PutMapping("/admin/update/{id}")
	public ResponseEntity<?> updateAdminProfile(@PathVariable("id") int adminId, @RequestBody AdminDto AdminDto) {
		Map<String, Object> result = adminService.updateAdmin(adminId, AdminDto);
		return Response.success(result);
	}
	
	@GetMapping("/admin/all-lecturer")
	public ResponseEntity<?> findAllLecturer(){
		List<Lecturer> result=adminService.findLecturer();
		if(result==null)
			return Response.error("Lecturer not found!!!");
		return Response.success(result);
	}
	
	@DeleteMapping("/admin/removelecturer/{id}")
	public ResponseEntity<?> removeLecturer(@PathVariable("id") int lecturerId){
		Map<String,Object> result=adminService.removeLecturer(lecturerId);
		if(result.containsValue(1))
		return Response.success("lecturer removed!!");
		return Response.error("lecturer removal failed");
		
	}
	
	@PostMapping("/demo1")
	public ResponseEntity<?> democheck(@RequestBody Demo d) {
		System.out.println(d);
	List<Object> obj=(List<Object>) d.getData1();
	
		return Response.success(d);
	}
	
}
