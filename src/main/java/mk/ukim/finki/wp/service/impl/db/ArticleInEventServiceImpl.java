package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.ArticleInEvent;
import mk.ukim.finki.wp.repository.db.ArticleInEventRepository;
import mk.ukim.finki.wp.service.db.ArticleInEventService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class ArticleInEventServiceImpl extends
		BaseEntityCrudServiceImpl<ArticleInEvent, ArticleInEventRepository> implements ArticleInEventService {

	@Autowired
	private ArticleInEventRepository repository;

	@Override
	protected ArticleInEventRepository getRepository() {
		return repository;
	}

}
