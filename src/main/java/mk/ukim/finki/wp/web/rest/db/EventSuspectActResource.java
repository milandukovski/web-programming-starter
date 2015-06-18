package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventSuspectAct;
import mk.ukim.finki.wp.service.db.EventSuspectActService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/EventSuspectAct")
public class EventSuspectActResource extends CrudResource<EventSuspectAct, EventSuspectActService> {

	@Autowired
	private EventSuspectActService service;

	@Override
	public EventSuspectActService getService() {
		return service;
	}

}
