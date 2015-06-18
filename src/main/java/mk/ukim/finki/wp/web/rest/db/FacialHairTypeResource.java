package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.FacialHairType;
import mk.ukim.finki.wp.service.db.FacialHairTypeService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/FacialHairType")
public class FacialHairTypeResource extends CrudResource<FacialHairType, FacialHairTypeService> {

	@Autowired
	private FacialHairTypeService service;

	@Override
	public FacialHairTypeService getService() {
		return service;
	}

}
