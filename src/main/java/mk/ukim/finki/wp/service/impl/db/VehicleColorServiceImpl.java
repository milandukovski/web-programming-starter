package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.VehicleColor;
import mk.ukim.finki.wp.repository.db.VehicleColorRepository;
import mk.ukim.finki.wp.service.db.VehicleColorService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class VehicleColorServiceImpl extends
		BaseEntityCrudServiceImpl<VehicleColor, VehicleColorRepository> implements VehicleColorService {

	@Autowired
	private VehicleColorRepository repository;

	@Override
	protected VehicleColorRepository getRepository() {
		return repository;
	}

}
