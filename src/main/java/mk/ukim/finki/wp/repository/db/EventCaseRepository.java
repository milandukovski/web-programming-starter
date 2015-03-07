package mk.ukim.finki.wp.repository.db;

import java.util.List;

import mk.ukim.finki.wp.model.db.EventCase;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;

public interface EventCaseRepository extends JpaSpecificationRepository<EventCase> {
	public List<EventCase> findByName(String name);
}
