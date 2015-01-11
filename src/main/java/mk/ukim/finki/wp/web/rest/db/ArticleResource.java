package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.Article;
import mk.ukim.finki.wp.service.db.ArticleService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/Article")
public class ArticleResource extends CrudResource<Article, ArticleService> {

	@Autowired
	private ArticleService service;

	@Override
	public ArticleService getService() {
		return service;
	}

}
