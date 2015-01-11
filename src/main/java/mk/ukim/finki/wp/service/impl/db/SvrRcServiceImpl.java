package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.SvrRc;
import mk.ukim.finki.wp.repository.db.SvrRcRepository;
import mk.ukim.finki.wp.service.db.SvrRcService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class SvrRcServiceImpl extends
		BaseEntityCrudServiceImpl<SvrRc, SvrRcRepository> implements SvrRcService {

	@Autowired
	private SvrRcRepository repository;

	@Override
	protected SvrRcRepository getRepository() {
		return repository;
	}

}
