package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.City;
import mk.ukim.finki.wp.repository.db.CityRepository;
import mk.ukim.finki.wp.service.db.CityService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class CityServiceImpl extends
		BaseEntityCrudServiceImpl<City, CityRepository> implements CityService {

	@Autowired
	private CityRepository repository;

	@Override
	protected CityRepository getRepository() {
		return repository;
	}

}
