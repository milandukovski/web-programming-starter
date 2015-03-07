package mk.ukim.finki.wp.repository.db;

import java.util.List;

import mk.ukim.finki.wp.model.db.EventPoliceStation;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;

public interface EventPoloiceStationRepository extends JpaSpecificationRepository<EventPoliceStation> {
	public List<EventPoliceStation> findByName(String name);
}
