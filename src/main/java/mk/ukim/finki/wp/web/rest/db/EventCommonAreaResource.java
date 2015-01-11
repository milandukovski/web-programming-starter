package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventCommonArea;
import mk.ukim.finki.wp.service.db.EventCommonAreaService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/EventCommonArea")
public class EventCommonAreaResource extends CrudResource<EventCommonArea, EventCommonAreaService> {

	@Autowired
	private EventCommonAreaService service;

	@Override
	public EventCommonAreaService getService() {
		return service;
	}

}
