package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.Weight;
import mk.ukim.finki.wp.repository.db.WeightRepository;
import mk.ukim.finki.wp.service.db.WeightService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class WeightServiceImpl extends
		BaseEntityCrudServiceImpl<Weight, WeightRepository> implements WeightService {

	@Autowired
	private WeightRepository repository;

	@Override
	protected WeightRepository getRepository() {
		return repository;
	}

}
