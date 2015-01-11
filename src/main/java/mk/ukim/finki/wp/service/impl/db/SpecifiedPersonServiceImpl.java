package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.SpecifiedPerson;
import mk.ukim.finki.wp.repository.db.SpecifiedPersonRepository;
import mk.ukim.finki.wp.service.db.SpecifiedPersonService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class SpecifiedPersonServiceImpl extends
		BaseEntityCrudServiceImpl<SpecifiedPerson, SpecifiedPersonRepository> implements SpecifiedPersonService {

	@Autowired
	private SpecifiedPersonRepository repository;

	@Override
	protected SpecifiedPersonRepository getRepository() {
		return repository;
	}

}
