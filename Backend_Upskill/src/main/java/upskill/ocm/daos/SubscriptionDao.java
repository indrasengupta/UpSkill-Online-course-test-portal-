package upskill.ocm.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import upskill.ocm.entities.Subscription;

public interface SubscriptionDao extends JpaRepository<Subscription, Integer> {

}
