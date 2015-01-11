package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.service.db.EventService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/Event")
public class EventResource extends CrudResource<Event, EventService> {

	@Autowired
	private EventService service;

	@Override
	public EventService getService() {
		return service;
	}

}
