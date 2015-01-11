package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.SpecifiedPersonInEvent;
import mk.ukim.finki.wp.repository.db.SpecifiedPersonInEventRepository;
import mk.ukim.finki.wp.service.db.SpecifiedPersonInEventService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class SpecifiedPersonInEventServiceImpl extends
		BaseEntityCrudServiceImpl<SpecifiedPersonInEvent, SpecifiedPersonInEventRepository> implements SpecifiedPersonInEventService {

	@Autowired
	private SpecifiedPersonInEventRepository repository;

	@Override
	protected SpecifiedPersonInEventRepository getRepository() {
		return repository;
	}

}
