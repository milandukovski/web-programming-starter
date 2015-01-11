package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EyeColor;
import mk.ukim.finki.wp.repository.db.EyeColorRepository;
import mk.ukim.finki.wp.service.db.EyeColorService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EyeColorServiceImpl extends
		BaseEntityCrudServiceImpl<EyeColor, EyeColorRepository> implements EyeColorService {

	@Autowired
	private EyeColorRepository repository;

	@Override
	protected EyeColorRepository getRepository() {
		return repository;
	}

}
