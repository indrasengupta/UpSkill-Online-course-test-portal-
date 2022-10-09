package upskill.ocm.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import upskill.ocm.entities.Subscribed;
@Repository
public interface SubscribedDao extends JpaRepository<Subscribed, Integer> {

@Modifying
@Query(value = "insert into subscribed (l_id,sn_id) values (?1,?2)" , nativeQuery = true)
void insertPlan(int lId,int snId);

@Modifying
@Query(value = "delete from  subscribed where l_id = (?1)" , nativeQuery = true)
void removePlan(int lId);

	
}
