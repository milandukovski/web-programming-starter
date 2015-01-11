package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.SpeachTrouble;
import mk.ukim.finki.wp.service.db.SpeachTroubleService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/SpeachTrouble")
public class SpeachTroubleResource extends CrudResource<SpeachTrouble, SpeachTroubleService> {

	@Autowired
	private SpeachTroubleService service;

	@Override
	public SpeachTroubleService getService() {
		return service;
	}

}
