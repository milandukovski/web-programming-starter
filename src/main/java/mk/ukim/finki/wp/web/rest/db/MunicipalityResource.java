package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.service.db.MunicipalityService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/Municipality")
public class MunicipalityResource extends CrudResource<Municipality, MunicipalityService> {

	@Autowired
	private MunicipalityService service;

	@Override
	public MunicipalityService getService() {
		return service;
	}

}
