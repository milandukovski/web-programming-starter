package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventPoliceStation;
import mk.ukim.finki.wp.service.db.EventPoliceStationService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/EventPoliceStation")
public class EventPoliceStationResource extends CrudResource<EventPoliceStation, EventPoliceStationService> {

	@Autowired
	private EventPoliceStationService service;

	@Override
	public EventPoliceStationService getService() {
		return service;
	}

}
