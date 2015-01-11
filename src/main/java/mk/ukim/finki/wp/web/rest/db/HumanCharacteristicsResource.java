package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.HumanCharacteristics;
import mk.ukim.finki.wp.service.db.HumanCharacteristicsService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/HumanCharacteristics")
public class HumanCharacteristicsResource extends CrudResource<HumanCharacteristics, HumanCharacteristicsService> {

	@Autowired
	private HumanCharacteristicsService service;

	@Override
	public HumanCharacteristicsService getService() {
		return service;
	}

}
