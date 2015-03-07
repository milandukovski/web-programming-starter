package mk.ukim.finki.wp.repository.db;

import java.util.List;

import mk.ukim.finki.wp.model.db.EventArea;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;

public interface EventAreaRepository extends JpaSpecificationRepository<EventArea> {
	public List<EventArea> findByName(String name);
}
