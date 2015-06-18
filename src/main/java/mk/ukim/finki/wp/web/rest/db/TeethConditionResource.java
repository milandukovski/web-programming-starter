package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.TeethCondition;
import mk.ukim.finki.wp.service.db.TeethConditionService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/TeethCondition")
public class TeethConditionResource extends CrudResource<TeethCondition, TeethConditionService> {

	@Autowired
	private TeethConditionService service;

	@Override
	public TeethConditionService getService() {
		return service;
	}

}
