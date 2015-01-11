package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventArea;
import mk.ukim.finki.wp.service.db.EventAreaService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/EventArea")
public class EventAreaResource extends CrudResource<EventArea, EventAreaService> {

	@Autowired
	private EventAreaService service;

	@Override
	public EventAreaService getService() {
		return service;
	}

}
