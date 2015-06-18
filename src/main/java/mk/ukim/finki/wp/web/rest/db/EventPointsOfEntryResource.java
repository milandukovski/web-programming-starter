package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventPointsOfEntry;
import mk.ukim.finki.wp.service.db.EventPointsOfEntryService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/EventPointsOfEntry")
public class EventPointsOfEntryResource extends CrudResource<EventPointsOfEntry, EventPointsOfEntryService> {

	@Autowired
	private EventPointsOfEntryService service;

	@Override
	public EventPointsOfEntryService getService() {
		return service;
	}

}
