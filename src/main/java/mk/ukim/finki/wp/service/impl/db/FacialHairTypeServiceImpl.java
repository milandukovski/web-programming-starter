package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.FacialHairType;
import mk.ukim.finki.wp.repository.db.FacialHairTypeRepository;
import mk.ukim.finki.wp.service.db.FacialHairTypeService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class FacialHairTypeServiceImpl extends
		BaseEntityCrudServiceImpl<FacialHairType, FacialHairTypeRepository> implements FacialHairTypeService {

	@Autowired
	private FacialHairTypeRepository repository;

	@Override
	protected FacialHairTypeRepository getRepository() {
		return repository;
	}

}
