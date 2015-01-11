package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.SpecifiedPersonInEvent;
import mk.ukim.finki.wp.service.db.SpecifiedPersonInEventService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/SpecifiedPersonInEvent")
public class SpecifiedPersonInEventResource extends CrudResource<SpecifiedPersonInEvent, SpecifiedPersonInEventService> {

	@Autowired
	private SpecifiedPersonInEventService service;

	@Override
	public SpecifiedPersonInEventService getService() {
		return service;
	}

}
