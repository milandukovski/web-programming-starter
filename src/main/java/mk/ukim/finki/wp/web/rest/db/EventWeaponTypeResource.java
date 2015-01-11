package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventWeaponType;
import mk.ukim.finki.wp.service.db.EventWeaponTypeService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/EventWeaponType")
public class EventWeaponTypeResource extends CrudResource<EventWeaponType, EventWeaponTypeService> {

	@Autowired
	private EventWeaponTypeService service;

	@Override
	public EventWeaponTypeService getService() {
		return service;
	}

}
