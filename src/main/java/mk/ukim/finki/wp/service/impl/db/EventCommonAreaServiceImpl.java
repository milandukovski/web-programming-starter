package mk.ukim.finki.wp.service.impl.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EventCommonArea;
import mk.ukim.finki.wp.repository.db.EventCommonAreaRepository;
import mk.ukim.finki.wp.service.db.EventCommonAreaService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventCommonAreaServiceImpl extends
		BaseEntityCrudServiceImpl<EventCommonArea, EventCommonAreaRepository> implements EventCommonAreaService {

	@Autowired
	private EventCommonAreaRepository repository;

	@Override
	protected EventCommonAreaRepository getRepository() {
		return repository;
	}

	@Override
	public List<EventCommonArea> findByName(String name) {
		return getRepository().findByName(name);
	}

}
