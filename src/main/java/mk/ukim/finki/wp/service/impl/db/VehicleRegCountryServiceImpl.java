package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.VehicleRegCountry;
import mk.ukim.finki.wp.repository.db.VehicleRegCountryRepository;
import mk.ukim.finki.wp.service.db.VehicleRegCountryService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class VehicleRegCountryServiceImpl extends
		BaseEntityCrudServiceImpl<VehicleRegCountry, VehicleRegCountryRepository> implements VehicleRegCountryService {

	@Autowired
	private VehicleRegCountryRepository repository;

	@Override
	protected VehicleRegCountryRepository getRepository() {
		return repository;
	}

}
