package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventWayOfLeaving;
import mk.ukim.finki.wp.service.db.EventWayOfLeavingService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/EventWayOfLeaving")
public class EventWayOfLeavingResource extends CrudResource<EventWayOfLeaving, EventWayOfLeavingService> {

	@Autowired
	private EventWayOfLeavingService service;

	@Override
	public EventWayOfLeavingService getService() {
		return service;
	}

}
