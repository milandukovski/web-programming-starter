package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.Height;
import mk.ukim.finki.wp.service.db.HeightService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/Height")
public class HeightResource extends CrudResource<Height, HeightService> {

	@Autowired
	private HeightService service;

	@Override
	public HeightService getService() {
		return service;
	}

}
