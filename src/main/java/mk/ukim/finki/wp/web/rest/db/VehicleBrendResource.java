package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.VehicleBrend;
import mk.ukim.finki.wp.service.db.VehicleBrendService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/VehicleBrend")
public class VehicleBrendResource extends CrudResource<VehicleBrend, VehicleBrendService> {

	@Autowired
	private VehicleBrendService service;

	@Override
	public VehicleBrendService getService() {
		return service;
	}

}
