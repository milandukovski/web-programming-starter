package mk.ukim.finki.wp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import mk.ukim.finki.wp.model.db.Ethnicity;
import mk.ukim.finki.wp.service.impl.db.EthnicityServiceImpl;

@RequestMapping("/data/rest/ethnicity")
public class EthnicityController extends CrudResource<Ethnicity, EthnicityServiceImpl> {
	@Autowired
	EthnicityServiceImpl service;
	
	@Override
	public EthnicityServiceImpl getService() {
		// TODO Auto-generated method stub
		return service;
	}

}
