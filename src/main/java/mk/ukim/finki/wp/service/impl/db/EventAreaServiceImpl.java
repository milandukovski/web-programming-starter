package mk.ukim.finki.wp.service.impl.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EventArea;
import mk.ukim.finki.wp.repository.db.EventAreaRepository;
import mk.ukim.finki.wp.service.db.EventAreaService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventAreaServiceImpl extends
		BaseEntityCrudServiceImpl<EventArea, EventAreaRepository> implements EventAreaService {

	@Autowired
	private EventAreaRepository repository;

	@Override
	protected EventAreaRepository getRepository() {
		return repository;
	}

	@Override
	public List<EventArea> findByName(String name) {
		return getRepository().findByName(name);
	}

}
