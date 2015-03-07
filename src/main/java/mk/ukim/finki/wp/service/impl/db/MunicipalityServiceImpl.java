package mk.ukim.finki.wp.service.impl.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.repository.db.MunicipalityRepository;
import mk.ukim.finki.wp.service.db.MunicipalityService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;
import mk.ukim.finki.wp.web.MunicipalityInfo;

@Service
public class MunicipalityServiceImpl extends
		BaseEntityCrudServiceImpl<Municipality, MunicipalityRepository> implements MunicipalityService {

	@Autowired
	private MunicipalityRepository repository;

	@Override
	protected MunicipalityRepository getRepository() {
		return repository;
	}

	@Override
	public List<MunicipalityInfo> total() {
		return repository.total();
	}
	
	public List<Municipality> findByName(String name){
		return getRepository().findByName(name);
	}

}
