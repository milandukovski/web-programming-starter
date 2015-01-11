package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.Ethnicity;
import mk.ukim.finki.wp.repository.db.EthnicityRepository;
import mk.ukim.finki.wp.service.db.EthnicityService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EthnicityServiceImpl extends
		BaseEntityCrudServiceImpl<Ethnicity, EthnicityRepository> implements EthnicityService {

	@Autowired
	private EthnicityRepository repository;

	@Override
	protected EthnicityRepository getRepository() {
		return repository;
	}

}
