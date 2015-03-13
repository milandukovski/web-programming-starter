package mk.ukim.finki.wp.service.db;

import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.service.BaseEntityCrudService;
import mk.ukim.finki.wp.web.EventCaseInfo;

public interface EventService extends BaseEntityCrudService<Event> {
	public List<EventCaseInfo> getCount();
	
	public List<EventCaseInfo> getCaseByCity(long id);
}
