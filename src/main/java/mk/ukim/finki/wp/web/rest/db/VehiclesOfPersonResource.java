package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.VehiclesOfPerson;
import mk.ukim.finki.wp.service.db.VehiclesOfPersonService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/VehiclesOfPerson")
public class VehiclesOfPersonResource extends CrudResource<VehiclesOfPerson, VehiclesOfPersonService> {

	@Autowired
	private VehiclesOfPersonService service;

	@Override
	public VehiclesOfPersonService getService() {
		return service;
	}

}
