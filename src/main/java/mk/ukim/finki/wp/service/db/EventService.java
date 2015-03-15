package mk.ukim.finki.wp.service.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.service.BaseEntityCrudService;
import mk.ukim.finki.wp.web.EventCaseInfo;

public interface EventService extends BaseEntityCrudService<Event> {
	public List<EventCaseInfo> getCount(Date from, Date to);

	public List<EventCaseInfo> getCaseByCity(long id, Date from, Date to);
	
	public List<Event> getEventByCase(long id, long mid, Date from, Date to);
}
