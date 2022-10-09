package upskill.ocm.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import upskill.ocm.entities.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	Admin findByAdminId(int id);
	Admin findByEmail(String email);
}
