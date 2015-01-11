package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.UnspecifiedPersonInEvent;
import mk.ukim.finki.wp.service.db.UnspecifiedPersonInEventService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/UnspecifiedPersonInEvent")
public class UnspecifiedPersonInEventResource extends CrudResource<UnspecifiedPersonInEvent, UnspecifiedPersonInEventService> {

	@Autowired
	private UnspecifiedPersonInEventService service;

	@Override
	public UnspecifiedPersonInEventService getService() {
		return service;
	}

}
