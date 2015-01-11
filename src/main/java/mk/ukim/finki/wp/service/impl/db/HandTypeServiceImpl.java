package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.HandType;
import mk.ukim.finki.wp.repository.db.HandTypeRepository;
import mk.ukim.finki.wp.service.db.HandTypeService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class HandTypeServiceImpl extends
		BaseEntityCrudServiceImpl<HandType, HandTypeRepository> implements HandTypeService {

	@Autowired
	private HandTypeRepository repository;

	@Override
	protected HandTypeRepository getRepository() {
		return repository;
	}

}
