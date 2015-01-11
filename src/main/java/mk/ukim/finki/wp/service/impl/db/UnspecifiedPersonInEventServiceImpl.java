package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.UnspecifiedPersonInEvent;
import mk.ukim.finki.wp.repository.db.UnspecifiedPersonInEventRepository;
import mk.ukim.finki.wp.service.db.UnspecifiedPersonInEventService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class UnspecifiedPersonInEventServiceImpl extends
		BaseEntityCrudServiceImpl<UnspecifiedPersonInEvent, UnspecifiedPersonInEventRepository> implements UnspecifiedPersonInEventService {

	@Autowired
	private UnspecifiedPersonInEventRepository repository;

	@Override
	protected UnspecifiedPersonInEventRepository getRepository() {
		return repository;
	}

}
