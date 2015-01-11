package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.HairColor;
import mk.ukim.finki.wp.repository.db.HairColorRepository;
import mk.ukim.finki.wp.service.db.HairColorService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class HairColorServiceImpl extends
		BaseEntityCrudServiceImpl<HairColor, HairColorRepository> implements HairColorService {

	@Autowired
	private HairColorRepository repository;

	@Override
	protected HairColorRepository getRepository() {
		return repository;
	}

}
