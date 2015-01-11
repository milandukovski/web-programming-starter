package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EventPointsOfEntry;
import mk.ukim.finki.wp.repository.db.EventPointsOfEntryRepository;
import mk.ukim.finki.wp.service.db.EventPointsOfEntryService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventPointsOfEntryServiceImpl extends
		BaseEntityCrudServiceImpl<EventPointsOfEntry, EventPointsOfEntryRepository> implements EventPointsOfEntryService {

	@Autowired
	private EventPointsOfEntryRepository repository;

	@Override
	protected EventPointsOfEntryRepository getRepository() {
		return repository;
	}

}
