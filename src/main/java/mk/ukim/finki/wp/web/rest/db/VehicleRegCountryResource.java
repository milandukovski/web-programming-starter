package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.VehicleRegCountry;
import mk.ukim.finki.wp.service.db.VehicleRegCountryService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/VehicleRegCountry")
public class VehicleRegCountryResource extends CrudResource<VehicleRegCountry, VehicleRegCountryService> {

	@Autowired
	private VehicleRegCountryService service;

	@Override
	public VehicleRegCountryService getService() {
		return service;
	}

}
