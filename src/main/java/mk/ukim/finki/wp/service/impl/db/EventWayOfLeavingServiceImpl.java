package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EventWayOfLeaving;
import mk.ukim.finki.wp.repository.db.EventWayOfLeavingRepository;
import mk.ukim.finki.wp.service.db.EventWayOfLeavingService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventWayOfLeavingServiceImpl extends
		BaseEntityCrudServiceImpl<EventWayOfLeaving, EventWayOfLeavingRepository> implements EventWayOfLeavingService {

	@Autowired
	private EventWayOfLeavingRepository repository;

	@Override
	protected EventWayOfLeavingRepository getRepository() {
		return repository;
	}

}
