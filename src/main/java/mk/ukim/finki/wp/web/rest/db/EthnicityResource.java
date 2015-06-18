package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.Ethnicity;
import mk.ukim.finki.wp.service.db.EthnicityService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/Ethnicity")
public class EthnicityResource extends CrudResource<Ethnicity, EthnicityService> {

	@Autowired
	private EthnicityService service;

	@Override
	public EthnicityService getService() {
		return service;
	}

}
