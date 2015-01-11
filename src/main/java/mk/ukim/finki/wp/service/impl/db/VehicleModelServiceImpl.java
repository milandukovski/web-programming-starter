package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.VehicleModel;
import mk.ukim.finki.wp.repository.db.VehicleModelRepository;
import mk.ukim.finki.wp.service.db.VehicleModelService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class VehicleModelServiceImpl extends
		BaseEntityCrudServiceImpl<VehicleModel, VehicleModelRepository> implements VehicleModelService {

	@Autowired
	private VehicleModelRepository repository;

	@Override
	protected VehicleModelRepository getRepository() {
		return repository;
	}

}
