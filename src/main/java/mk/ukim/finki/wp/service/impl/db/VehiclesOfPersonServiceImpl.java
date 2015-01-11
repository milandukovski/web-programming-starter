package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.VehiclesOfPerson;
import mk.ukim.finki.wp.repository.db.VehiclesOfPersonRepository;
import mk.ukim.finki.wp.service.db.VehiclesOfPersonService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class VehiclesOfPersonServiceImpl extends
		BaseEntityCrudServiceImpl<VehiclesOfPerson, VehiclesOfPersonRepository> implements VehiclesOfPersonService {

	@Autowired
	private VehiclesOfPersonRepository repository;

	@Override
	protected VehiclesOfPersonRepository getRepository() {
		return repository;
	}

}
