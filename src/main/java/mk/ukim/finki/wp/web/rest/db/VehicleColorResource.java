package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.VehicleColor;
import mk.ukim.finki.wp.service.db.VehicleColorService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/VehicleColor")
public class VehicleColorResource extends CrudResource<VehicleColor, VehicleColorService> {

	@Autowired
	private VehicleColorService service;

	@Override
	public VehicleColorService getService() {
		return service;
	}

}
