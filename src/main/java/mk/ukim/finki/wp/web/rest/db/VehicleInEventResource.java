package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.VehicleInEvent;
import mk.ukim.finki.wp.service.db.VehicleInEventService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/VehicleInEvent")
public class VehicleInEventResource extends CrudResource<VehicleInEvent, VehicleInEventService> {

	@Autowired
	private VehicleInEventService service;

	@Override
	public VehicleInEventService getService() {
		return service;
	}

}
