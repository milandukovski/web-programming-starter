package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EventMethodOfEntering;
import mk.ukim.finki.wp.repository.db.EventMethodOfEnteringRepository;
import mk.ukim.finki.wp.service.db.EventMethodOfEnteringService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventMethodOfEnteringServiceImpl extends
		BaseEntityCrudServiceImpl<EventMethodOfEntering, EventMethodOfEnteringRepository> implements EventMethodOfEnteringService {

	@Autowired
	private EventMethodOfEnteringRepository repository;

	@Override
	protected EventMethodOfEnteringRepository getRepository() {
		return repository;
	}

}
