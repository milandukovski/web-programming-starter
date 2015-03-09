package mk.ukim.finki.wp.repository.db;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;
import mk.ukim.finki.wp.web.EventCaseInfo;

public interface EventRepository extends JpaSpecificationRepository<Event> {
	@Query(value = "select ec.id, ec.name, count(e.id) as total from mvr_event e right join mvr_eventcases ec ON e.ecase_id =ec.id group by ec.id", nativeQuery = true)
	ArrayList<EventCaseInfo> getCount();
}
