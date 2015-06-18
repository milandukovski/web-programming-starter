package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.HandType;
import mk.ukim.finki.wp.service.db.HandTypeService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/HandType")
public class HandTypeResource extends CrudResource<HandType, HandTypeService> {

	@Autowired
	private HandTypeService service;

	@Override
	public HandTypeService getService() {
		return service;
	}

}
