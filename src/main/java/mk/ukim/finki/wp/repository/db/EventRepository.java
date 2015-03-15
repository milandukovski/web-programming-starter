package mk.ukim.finki.wp.repository.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;
import mk.ukim.finki.wp.web.EventCaseInfo;

public interface EventRepository extends JpaSpecificationRepository<Event> {
	@Query(value = "select b.id, b.name, case when a.total is null then 0 else a.total end as total from (select ec.id, ec.name, count(e.id) as total from mvr_event e right join mvr_eventcases ec ON e.ecase_id =ec.id where e.datum>=DATE_FORMAT(?1, '%Y-%c-%e %H:%i:%s') && e.datum <= DATE_FORMAT(?2, '%Y-%c-%e %H:%i:%s') group by ec.id) a right join (select id, name, 0 as total from mvr_eventcases) b ON a.id=b.id ", nativeQuery = true)
	List<EventCaseInfo> getCount(Date from, Date to);
	
	@Query(value = "select ec.id, ec.name, count(e.id) as total from mvr_event e inner join mvr_eventcases ec ON e.ecase_id =ec.id where e.opstina_id=?1 && e.datum>=DATE_FORMAT(?2, '%Y-%c-%e %H:%i:%s') && e.datum <=DATE_FORMAT(?3, '%Y-%c-%e %H:%i:%s') group by ec.id ", nativeQuery = true)
	List<EventCaseInfo> getCaseByCity(long id, Date from, Date to);
	
	@Query(value = "SELECT * FROM mvr_event WHERE ecase_id=?1 && opstina_id=?2 && datum>=DATE_FORMAT(?3, '%Y-%c-%e %H:%i:%s') && datum <=DATE_FORMAT(?4, '%Y-%c-%e %H:%i:%s') ORDER BY `datum` DESC", nativeQuery = true)
	List<Event> getEventByCase(long id,long mid, Date from, Date to);
}
