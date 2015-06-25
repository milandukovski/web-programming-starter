package mk.ukim.finki.wp.repository.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import mk.ukim.finki.wp.model.db.EventCase;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;

public interface EventCaseRepository extends JpaSpecificationRepository<EventCase> {
	public List<EventCase> findByName(String name);
	
	@Query(value ="select * from mvr_event_cases where id in (SELECT distinct ecase_id from mvr_event where ecase_id)", nativeQuery = true)
	public List<EventCase> allCasesWithEvents();
	
}
