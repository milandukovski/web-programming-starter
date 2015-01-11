package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.VehicleType;
import mk.ukim.finki.wp.service.db.VehicleTypeService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/VehicleType")
public class VehicleTypeResource extends CrudResource<VehicleType, VehicleTypeService> {

	@Autowired
	private VehicleTypeService service;

	@Override
	public VehicleTypeService getService() {
		return service;
	}

}
