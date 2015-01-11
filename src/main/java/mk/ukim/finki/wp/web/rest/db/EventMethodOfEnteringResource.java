package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventMethodOfEntering;
import mk.ukim.finki.wp.service.db.EventMethodOfEnteringService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/EventMethodOfEntering")
public class EventMethodOfEnteringResource extends CrudResource<EventMethodOfEntering, EventMethodOfEnteringService> {

	@Autowired
	private EventMethodOfEnteringService service;

	@Override
	public EventMethodOfEnteringService getService() {
		return service;
	}

}
