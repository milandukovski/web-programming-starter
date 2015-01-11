package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.Age;
import mk.ukim.finki.wp.service.db.AgeService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/Age")
public class AgeResource extends CrudResource<Age, AgeService> {

	@Autowired
	private AgeService service;

	@Override
	public AgeService getService() {
		return service;
	}

}
