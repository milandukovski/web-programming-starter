package mk.ukim.finki.wp.service.impl.db;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.repository.db.EventRepository;
import mk.ukim.finki.wp.service.db.EventService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;
import mk.ukim.finki.wp.web.EventCaseInfo;

@Service
public class EventServiceImpl extends
		BaseEntityCrudServiceImpl<Event, EventRepository> implements
		EventService {

	@Autowired
	private EventRepository repository;

	@Override
	protected EventRepository getRepository() {
		return repository;
	}

	@Override
	public List<EventCaseInfo> getCount(Date from, Date to) {
		// TODO Auto-generated method stub
		return repository.getCount(from, to);
	}

	@Override
	public List<EventCaseInfo> getCaseByCity(long id, Date from, Date to) {
		// TODO Auto-generated method stub
		return repository.getCaseByCity(id, from, to);
	}

	@Override
	public List<Event> getEventByCase(long id, long mid, Date from, Date to) {
		// TODO Auto-generated method stub
		return repository.getEventByCase(id, mid, from, to);
	}

}
