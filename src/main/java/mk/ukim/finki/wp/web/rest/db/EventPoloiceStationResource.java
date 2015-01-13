package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventPoliceStation;
import mk.ukim.finki.wp.service.db.EventPoloiceStationService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/EventPoloiceStation")
public class EventPoloiceStationResource extends CrudResource<EventPoliceStation, EventPoloiceStationService> {

	@Autowired
	private EventPoloiceStationService service;

	@Override
	public EventPoloiceStationService getService() {
		return service;
	}

}
