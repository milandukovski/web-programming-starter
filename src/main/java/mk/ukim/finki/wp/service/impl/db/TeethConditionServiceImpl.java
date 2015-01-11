package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.TeethCondition;
import mk.ukim.finki.wp.repository.db.TeethConditionRepository;
import mk.ukim.finki.wp.service.db.TeethConditionService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class TeethConditionServiceImpl extends
		BaseEntityCrudServiceImpl<TeethCondition, TeethConditionRepository> implements TeethConditionService {

	@Autowired
	private TeethConditionRepository repository;

	@Override
	protected TeethConditionRepository getRepository() {
		return repository;
	}

}
