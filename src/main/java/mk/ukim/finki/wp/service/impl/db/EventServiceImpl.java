package mk.ukim.finki.wp.service.impl.db;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.repository.db.EventRepository;
import mk.ukim.finki.wp.service.db.EventService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;
import mk.ukim.finki.wp.web.EventCaseInfo;

@Service
public class EventServiceImpl extends
		BaseEntityCrudServiceImpl<Event, EventRepository> implements EventService {

	@Autowired
	private EventRepository repository;

	@Override
	protected EventRepository getRepository() {
		return repository;
	}
	
	@Override
	public ArrayList<EventCaseInfo> getCount() {
		// TODO Auto-generated method stub
		return repository.getCount();
	}

}
