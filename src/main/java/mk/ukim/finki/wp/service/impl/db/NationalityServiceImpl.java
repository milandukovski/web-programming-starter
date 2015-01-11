package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.Nationality;
import mk.ukim.finki.wp.repository.db.NationalityRepository;
import mk.ukim.finki.wp.service.db.NationalityService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class NationalityServiceImpl extends
		BaseEntityCrudServiceImpl<Nationality, NationalityRepository> implements NationalityService {

	@Autowired
	private NationalityRepository repository;

	@Override
	protected NationalityRepository getRepository() {
		return repository;
	}

}
