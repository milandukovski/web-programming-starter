package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.PhysicalCondition;
import mk.ukim.finki.wp.service.db.PhysicalConditionService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/PhysicalCondition")
public class PhysicalConditionResource extends CrudResource<PhysicalCondition, PhysicalConditionService> {

	@Autowired
	private PhysicalConditionService service;

	@Override
	public PhysicalConditionService getService() {
		return service;
	}

}
