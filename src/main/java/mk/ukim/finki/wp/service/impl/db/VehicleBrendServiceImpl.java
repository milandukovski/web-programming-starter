package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.VehicleBrend;
import mk.ukim.finki.wp.repository.db.VehicleBrendRepository;
import mk.ukim.finki.wp.service.db.VehicleBrendService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class VehicleBrendServiceImpl extends
		BaseEntityCrudServiceImpl<VehicleBrend, VehicleBrendRepository> implements VehicleBrendService {

	@Autowired
	private VehicleBrendRepository repository;

	@Override
	protected VehicleBrendRepository getRepository() {
		return repository;
	}

}
