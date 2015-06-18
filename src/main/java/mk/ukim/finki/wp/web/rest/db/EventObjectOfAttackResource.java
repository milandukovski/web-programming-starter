package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.EventObjectOfAttack;
import mk.ukim.finki.wp.service.db.EventObjectOfAttackService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/EventObjectOfAttack")
public class EventObjectOfAttackResource extends CrudResource<EventObjectOfAttack, EventObjectOfAttackService> {

	@Autowired
	private EventObjectOfAttackService service;

	@Override
	public EventObjectOfAttackService getService() {
		return service;
	}

}
