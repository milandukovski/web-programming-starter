package mk.ukim.finki.wp.repository.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;
import mk.ukim.finki.wp.web.EventCaseInfo;

public interface EventRepository extends JpaSpecificationRepository<Event> {
	@Query(value = "select ec.id, ec.name, count(e.id) as total from mvr_event e right join mvr_eventcases ec ON e.ecase_id =ec.id group by ec.id", nativeQuery = true)
	List<EventCaseInfo> getCount();
	
	@Query(value = "select ec.id, ec.name, count(e.id) as total from mvr_event e inner join mvr_eventcases ec ON e.ecase_id =ec.id where e.opstina_id=?1 group by ec.id ", nativeQuery = true)
	List<EventCaseInfo> getCaseByCity(long id);
}
