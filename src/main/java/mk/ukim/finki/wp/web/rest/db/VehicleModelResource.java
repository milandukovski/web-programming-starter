package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.VehicleModel;
import mk.ukim.finki.wp.service.db.VehicleModelService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/VehicleModel")
public class VehicleModelResource extends CrudResource<VehicleModel, VehicleModelService> {

	@Autowired
	private VehicleModelService service;

	@Override
	public VehicleModelService getService() {
		return service;
	}

}
