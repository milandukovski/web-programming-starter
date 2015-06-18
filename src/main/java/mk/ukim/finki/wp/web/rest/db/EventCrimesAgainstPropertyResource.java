package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventCrimesAgainstProperty;
import mk.ukim.finki.wp.service.db.EventCrimesAgainstPropertyService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/EventCrimesAgainstProperty")
public class EventCrimesAgainstPropertyResource extends CrudResource<EventCrimesAgainstProperty, EventCrimesAgainstPropertyService> {

	@Autowired
	private EventCrimesAgainstPropertyService service;

	@Override
	public EventCrimesAgainstPropertyService getService() {
		return service;
	}

}
