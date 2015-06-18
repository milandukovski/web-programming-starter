package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.City;
import mk.ukim.finki.wp.service.db.CityService;
import mk.ukim.finki.wp.web.CrudResource;


@RestController
@RequestMapping("/data/rest/City")
public class CityResource extends CrudResource<City, CityService> {

	@Autowired
	private CityService service;

	@Override
	public CityService getService() {
		return service;
	}

}
