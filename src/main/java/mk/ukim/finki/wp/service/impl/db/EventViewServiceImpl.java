package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.view.EventView;
import mk.ukim.finki.wp.repository.db.EventViewRepository;
import mk.ukim.finki.wp.service.db.EventViewService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventViewServiceImpl extends
		BaseEntityCrudServiceImpl<EventView, EventViewRepository> implements
		EventViewService {

	@Autowired
	private EventViewRepository repository;

	@Override
	protected EventViewRepository getRepository() {
		return repository;
	}
}
