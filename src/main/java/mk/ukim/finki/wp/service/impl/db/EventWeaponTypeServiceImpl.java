package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.EventWeaponType;
import mk.ukim.finki.wp.repository.db.EventWeaponTypeRepository;
import mk.ukim.finki.wp.service.db.EventWeaponTypeService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class EventWeaponTypeServiceImpl extends
		BaseEntityCrudServiceImpl<EventWeaponType, EventWeaponTypeRepository> implements EventWeaponTypeService {

	@Autowired
	private EventWeaponTypeRepository repository;

	@Override
	protected EventWeaponTypeRepository getRepository() {
		return repository;
	}

}
