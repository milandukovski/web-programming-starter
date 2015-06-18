package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.UnspecifiedPerson;
import mk.ukim.finki.wp.service.db.UnspecifiedPersonService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/UnspecifiedPerson")
public class UnspecifiedPersonResource extends CrudResource<UnspecifiedPerson, UnspecifiedPersonService> {

	@Autowired
	private UnspecifiedPersonService service;

	@Override
	public UnspecifiedPersonService getService() {
		return service;
	}

}
