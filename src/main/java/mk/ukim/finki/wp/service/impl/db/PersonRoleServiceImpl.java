package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.PersonRole;
import mk.ukim.finki.wp.repository.db.PersonRoleRepository;
import mk.ukim.finki.wp.service.db.PersonRoleService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class PersonRoleServiceImpl extends
		BaseEntityCrudServiceImpl<PersonRole, PersonRoleRepository> implements PersonRoleService {

	@Autowired
	private PersonRoleRepository repository;

	@Override
	protected PersonRoleRepository getRepository() {
		return repository;
	}

}
