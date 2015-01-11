package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.Vehicle;
import mk.ukim.finki.wp.repository.db.VehicleRepository;
import mk.ukim.finki.wp.service.db.VehicleService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class VehicleServiceImpl extends
		BaseEntityCrudServiceImpl<Vehicle, VehicleRepository> implements VehicleService {

	@Autowired
	private VehicleRepository repository;

	@Override
	protected VehicleRepository getRepository() {
		return repository;
	}

}
