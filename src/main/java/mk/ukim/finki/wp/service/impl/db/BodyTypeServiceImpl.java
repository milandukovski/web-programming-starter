package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.BodyType;
import mk.ukim.finki.wp.repository.db.BodyTypeRepository;
import mk.ukim.finki.wp.service.db.BodyTypeService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class BodyTypeServiceImpl extends
		BaseEntityCrudServiceImpl<BodyType, BodyTypeRepository> implements BodyTypeService {

	@Autowired
	private BodyTypeRepository repository;

	@Override
	protected BodyTypeRepository getRepository() {
		return repository;
	}

}
