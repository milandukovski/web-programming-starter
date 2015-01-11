package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EventCrimesAgainstProperty;
import mk.ukim.finki.wp.repository.db.EventCrimesAgainstPropertyRepository;
import mk.ukim.finki.wp.service.db.EventCrimesAgainstPropertyService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventCrimesAgainstPropertyServiceImpl extends
		BaseEntityCrudServiceImpl<EventCrimesAgainstProperty, EventCrimesAgainstPropertyRepository> implements EventCrimesAgainstPropertyService {

	@Autowired
	private EventCrimesAgainstPropertyRepository repository;

	@Override
	protected EventCrimesAgainstPropertyRepository getRepository() {
		return repository;
	}

}
