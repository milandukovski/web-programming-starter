package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.HumanCharacteristics;
import mk.ukim.finki.wp.repository.db.HumanCharacteristicsRepository;
import mk.ukim.finki.wp.service.db.HumanCharacteristicsService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class HumanCharacteristicsServiceImpl extends
		BaseEntityCrudServiceImpl<HumanCharacteristics, HumanCharacteristicsRepository> implements HumanCharacteristicsService {

	@Autowired
	private HumanCharacteristicsRepository repository;

	@Override
	protected HumanCharacteristicsRepository getRepository() {
		return repository;
	}

}
