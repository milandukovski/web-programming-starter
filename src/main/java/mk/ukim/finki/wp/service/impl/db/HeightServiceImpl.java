package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.Height;
import mk.ukim.finki.wp.repository.db.HeightRepository;
import mk.ukim.finki.wp.service.db.HeightService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class HeightServiceImpl extends
		BaseEntityCrudServiceImpl<Height, HeightRepository> implements HeightService {

	@Autowired
	private HeightRepository repository;

	@Override
	protected HeightRepository getRepository() {
		return repository;
	}

}
