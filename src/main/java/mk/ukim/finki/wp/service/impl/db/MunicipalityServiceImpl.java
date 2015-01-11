package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.repository.db.MunicipalityRepository;
import mk.ukim.finki.wp.service.db.MunicipalityService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class MunicipalityServiceImpl extends
		BaseEntityCrudServiceImpl<Municipality, MunicipalityRepository> implements MunicipalityService {

	@Autowired
	private MunicipalityRepository repository;

	@Override
	protected MunicipalityRepository getRepository() {
		return repository;
	}

}
