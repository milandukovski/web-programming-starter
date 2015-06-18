package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.ArticleUnit;
import mk.ukim.finki.wp.service.db.ArticleUnitService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping("/data/rest/ArticleUnit")
public class ArticleUnitResource extends CrudResource<ArticleUnit, ArticleUnitService> {

	@Autowired
	private ArticleUnitService service;

	@Override
	public ArticleUnitService getService() {
		return service;
	}

}
