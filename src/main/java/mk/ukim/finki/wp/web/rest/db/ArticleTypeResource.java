package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.ArticleType;
import mk.ukim.finki.wp.service.db.ArticleTypeService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/ArticleType")
public class ArticleTypeResource extends CrudResource<ArticleType, ArticleTypeService> {

	@Autowired
	private ArticleTypeService service;

	@Override
	public ArticleTypeService getService() {
		return service;
	}

}
