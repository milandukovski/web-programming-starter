package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EventObjectOfAttack;
import mk.ukim.finki.wp.repository.db.EventObjectOfAttackRepository;
import mk.ukim.finki.wp.service.db.EventObjectOfAttackService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventObjectOfAttackServiceImpl extends
		BaseEntityCrudServiceImpl<EventObjectOfAttack, EventObjectOfAttackRepository> implements EventObjectOfAttackService {

	@Autowired
	private EventObjectOfAttackRepository repository;

	@Override
	protected EventObjectOfAttackRepository getRepository() {
		return repository;
	}

}
