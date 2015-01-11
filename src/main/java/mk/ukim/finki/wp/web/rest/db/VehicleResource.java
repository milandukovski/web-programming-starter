package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.Vehicle;
import mk.ukim.finki.wp.service.db.VehicleService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/Vehicle")
public class VehicleResource extends CrudResource<Vehicle, VehicleService> {

	@Autowired
	private VehicleService service;

	@Override
	public VehicleService getService() {
		return service;
	}

}
