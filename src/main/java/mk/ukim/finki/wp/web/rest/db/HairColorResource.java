package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.HairColor;
import mk.ukim.finki.wp.service.db.HairColorService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/HairColor")
public class HairColorResource extends CrudResource<HairColor, HairColorService> {

	@Autowired
	private HairColorService service;

	@Override
	public HairColorService getService() {
		return service;
	}

}
