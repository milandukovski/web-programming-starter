package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.Nationality;
import mk.ukim.finki.wp.service.db.NationalityService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/Nationality")
public class NationalityResource extends CrudResource<Nationality, NationalityService> {

	@Autowired
	private NationalityService service;

	@Override
	public NationalityService getService() {
		return service;
	}

}
