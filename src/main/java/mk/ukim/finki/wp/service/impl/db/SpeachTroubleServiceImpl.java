package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.SpeachTrouble;
import mk.ukim.finki.wp.repository.db.SpeachTroubleRepository;
import mk.ukim.finki.wp.service.db.SpeachTroubleService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class SpeachTroubleServiceImpl extends
		BaseEntityCrudServiceImpl<SpeachTrouble, SpeachTroubleRepository> implements SpeachTroubleService {

	@Autowired
	private SpeachTroubleRepository repository;

	@Override
	protected SpeachTroubleRepository getRepository() {
		return repository;
	}

}
