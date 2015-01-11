package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.VehicleType;
import mk.ukim.finki.wp.repository.db.VehicleTypeRepository;
import mk.ukim.finki.wp.service.db.VehicleTypeService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class VehicleTypeServiceImpl extends
		BaseEntityCrudServiceImpl<VehicleType, VehicleTypeRepository> implements VehicleTypeService {

	@Autowired
	private VehicleTypeRepository repository;

	@Override
	protected VehicleTypeRepository getRepository() {
		return repository;
	}

}
