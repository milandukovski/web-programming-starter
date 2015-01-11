package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.SkinType;
import mk.ukim.finki.wp.repository.db.SkinTypeRepository;
import mk.ukim.finki.wp.service.db.SkinTypeService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class SkinTypeServiceImpl extends
		BaseEntityCrudServiceImpl<SkinType, SkinTypeRepository> implements SkinTypeService {

	@Autowired
	private SkinTypeRepository repository;

	@Override
	protected SkinTypeRepository getRepository() {
		return repository;
	}

}
