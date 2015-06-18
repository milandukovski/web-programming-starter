package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.PersonRole;
import mk.ukim.finki.wp.service.db.PersonRoleService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/PersonRole")
public class PersonRoleResource extends CrudResource<PersonRole, PersonRoleService> {

	@Autowired
	private PersonRoleService service;

	@Override
	public PersonRoleService getService() {
		return service;
	}

}
