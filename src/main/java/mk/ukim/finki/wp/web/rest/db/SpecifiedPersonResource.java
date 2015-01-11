package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.SpecifiedPerson;
import mk.ukim.finki.wp.service.db.SpecifiedPersonService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/SpecifiedPerson")
public class SpecifiedPersonResource extends CrudResource<SpecifiedPerson, SpecifiedPersonService> {

	@Autowired
	private SpecifiedPersonService service;

	@Override
	public SpecifiedPersonService getService() {
		return service;
	}

}
