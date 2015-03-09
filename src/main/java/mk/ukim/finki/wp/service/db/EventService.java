package mk.ukim.finki.wp.service.db;

import java.util.ArrayList;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.service.BaseEntityCrudService;
import mk.ukim.finki.wp.web.EventCaseInfo;

public interface EventService extends BaseEntityCrudService<Event> {
	public ArrayList<EventCaseInfo> getCount();
}
