package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventCase;
import mk.ukim.finki.wp.service.db.EventCaseService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/EventCase")
public class EventCaseResource extends CrudResource<EventCase, EventCaseService> {

	@Autowired
	private EventCaseService service;

	@Override
	public EventCaseService getService() {
		return service;
	}

}
