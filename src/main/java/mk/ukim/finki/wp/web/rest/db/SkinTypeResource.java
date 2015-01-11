package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.SkinType;
import mk.ukim.finki.wp.service.db.SkinTypeService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/SkinType")
public class SkinTypeResource extends CrudResource<SkinType, SkinTypeService> {

	@Autowired
	private SkinTypeService service;

	@Override
	public SkinTypeService getService() {
		return service;
	}

}
