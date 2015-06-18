package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.BodyType;
import mk.ukim.finki.wp.service.db.BodyTypeService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/BodyType")
public class BodyTypeResource extends CrudResource<BodyType, BodyTypeService> {

	@Autowired
	private BodyTypeService service;

	@Override
	public BodyTypeService getService() {
		return service;
	}

}
