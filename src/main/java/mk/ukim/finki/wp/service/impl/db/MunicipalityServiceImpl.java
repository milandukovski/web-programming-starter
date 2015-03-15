package mk.ukim.finki.wp.service.impl.db;

import java.util.Date;
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
	public List<MunicipalityInfo> total(Date from, Date to) {
		return repository.total(from,to);
	}
	
	public List<Municipality> findByName(String name){
		return getRepository().findByName(name);
	}
	
	@Override
	public List<MunicipalityInfo> getAllMunicipalities() {
		// TODO Auto-generated method stub
		return repository.getAllMunicipalities();
	}

	@Override
	public List<MunicipalityInfo> getCaseTotal(long case_id, Date from, Date to) {
		// TODO Auto-generated method stub
		return repository.getCaseTotal(case_id,from,to);
	}

}
