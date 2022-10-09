package upskill.ocm.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import upskill.ocm.entities.Lecturer;

public interface LecturerDao extends JpaRepository<Lecturer, Integer>{
	Lecturer findByLecturerId(int id);
	Lecturer findByEmail(String email);
}
