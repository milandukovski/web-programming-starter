package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.Weight;
import mk.ukim.finki.wp.service.db.WeightService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/Weight")
public class WeightResource extends CrudResource<Weight, WeightService> {

	@Autowired
	private WeightService service;

	@Override
	public WeightService getService() {
		return service;
	}

}
