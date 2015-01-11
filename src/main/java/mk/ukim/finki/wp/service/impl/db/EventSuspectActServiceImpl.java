package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EventSuspectAct;
import mk.ukim.finki.wp.repository.db.EventSuspectActRepository;
import mk.ukim.finki.wp.service.db.EventSuspectActService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventSuspectActServiceImpl extends
		BaseEntityCrudServiceImpl<EventSuspectAct, EventSuspectActRepository> implements EventSuspectActService {

	@Autowired
	private EventSuspectActRepository repository;

	@Override
	protected EventSuspectActRepository getRepository() {
		return repository;
	}

}
