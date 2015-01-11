package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.SvrRc;
import mk.ukim.finki.wp.service.db.SvrRcService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/SvrRc")
public class SvrRcResource extends CrudResource<SvrRc, SvrRcService> {

	@Autowired
	private SvrRcService service;

	@Override
	public SvrRcService getService() {
		return service;
	}

}
