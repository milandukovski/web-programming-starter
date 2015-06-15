package mk.ukim.finki.wp.service.impl.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EventPoliceStation;
import mk.ukim.finki.wp.repository.db.EventPoloiceStationRepository;
import mk.ukim.finki.wp.service.db.EventPoliceStationService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventPoliceStationServiceImpl extends
		BaseEntityCrudServiceImpl<EventPoliceStation, EventPoloiceStationRepository> implements EventPoliceStationService {

	@Autowired
	private EventPoloiceStationRepository repository;

	@Override
	protected EventPoloiceStationRepository getRepository() {
		return repository;
	}

	@Override
	public List<EventPoliceStation> findByName(String name) {
		return getRepository().findByName(name);
	}

}
