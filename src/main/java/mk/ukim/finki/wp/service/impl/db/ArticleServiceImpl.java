package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.Article;
import mk.ukim.finki.wp.repository.db.ArticleRepository;
import mk.ukim.finki.wp.service.db.ArticleService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class ArticleServiceImpl extends
		BaseEntityCrudServiceImpl<Article, ArticleRepository> implements ArticleService {

	@Autowired
	private ArticleRepository repository;

	@Override
	protected ArticleRepository getRepository() {
		return repository;
	}

}
