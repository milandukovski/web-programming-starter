package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.VehicleInEvent;
import mk.ukim.finki.wp.repository.db.VehicleInEventRepository;
import mk.ukim.finki.wp.service.db.VehicleInEventService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class VehicleInEventServiceImpl extends
		BaseEntityCrudServiceImpl<VehicleInEvent, VehicleInEventRepository> implements VehicleInEventService {

	@Autowired
	private VehicleInEventRepository repository;

	@Override
	protected VehicleInEventRepository getRepository() {
		return repository;
	}

}
