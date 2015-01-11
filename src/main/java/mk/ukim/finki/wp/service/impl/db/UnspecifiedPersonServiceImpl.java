package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.UnspecifiedPerson;
import mk.ukim.finki.wp.repository.db.UnspecifiedPersonRepository;
import mk.ukim.finki.wp.service.db.UnspecifiedPersonService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class UnspecifiedPersonServiceImpl extends
		BaseEntityCrudServiceImpl<UnspecifiedPerson, UnspecifiedPersonRepository> implements UnspecifiedPersonService {

	@Autowired
	private UnspecifiedPersonRepository repository;

	@Override
	protected UnspecifiedPersonRepository getRepository() {
		return repository;
	}

}
