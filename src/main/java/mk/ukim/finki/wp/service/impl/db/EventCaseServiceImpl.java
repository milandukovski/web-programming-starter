package mk.ukim.finki.wp.service.impl.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EventCase;
import mk.ukim.finki.wp.repository.db.EventCaseRepository;
import mk.ukim.finki.wp.service.db.EventCaseService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventCaseServiceImpl extends
		BaseEntityCrudServiceImpl<EventCase, EventCaseRepository> implements EventCaseService {

	@Autowired
	private EventCaseRepository repository;

	@Override
	protected EventCaseRepository getRepository() {
		return repository;
	}

	@Override
	public List<EventCase> findByName(String name) {
		return getRepository().findByName(name);
	}

	@Override
	public List<EventCase> allCases() {
		// TODO Auto-generated method stub
		return getRepository().allCasesWithEvents();
	}

}
