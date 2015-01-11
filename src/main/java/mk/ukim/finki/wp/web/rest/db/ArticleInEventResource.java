package mk.ukim.finki.wp.web.rest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.ArticleInEvent;
import mk.ukim.finki.wp.service.db.ArticleInEventService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/ArticleInEvent")
public class ArticleInEventResource extends CrudResource<ArticleInEvent, ArticleInEventService> {

	@Autowired
	private ArticleInEventService service;

	@Override
	public ArticleInEventService getService() {
		return service;
	}

}
