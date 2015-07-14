package mk.ukim.finki.wp.web.rest.db;

import mk.ukim.finki.wp.model.db.view.EventView;
import mk.ukim.finki.wp.service.db.*;
import mk.ukim.finki.wp.web.CrudResource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data/rest/EventView")
public class EventViewResource extends CrudResource<EventView, EventViewService> {

	@Autowired
	private EventViewService service;

	@Override
	public EventViewService getService() {
		return service;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<EventView> getAll(){
		return getService().findAll();
	}
}
