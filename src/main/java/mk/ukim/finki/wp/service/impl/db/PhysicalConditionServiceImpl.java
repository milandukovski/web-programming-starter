package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.PhysicalCondition;
import mk.ukim.finki.wp.repository.db.PhysicalConditionRepository;
import mk.ukim.finki.wp.service.db.PhysicalConditionService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class PhysicalConditionServiceImpl extends
		BaseEntityCrudServiceImpl<PhysicalCondition, PhysicalConditionRepository> implements PhysicalConditionService {

	@Autowired
	private PhysicalConditionRepository repository;

	@Override
	protected PhysicalConditionRepository getRepository() {
		return repository;
	}

}
