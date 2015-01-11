package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.Age;
import mk.ukim.finki.wp.repository.db.AgeRepository;
import mk.ukim.finki.wp.service.db.AgeService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class AgeServiceImpl extends
		BaseEntityCrudServiceImpl<Age, AgeRepository> implements AgeService {

	@Autowired
	private AgeRepository repository;

	@Override
	protected AgeRepository getRepository() {
		return repository;
	}

}
