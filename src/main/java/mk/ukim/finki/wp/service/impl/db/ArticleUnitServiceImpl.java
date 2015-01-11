package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.ArticleUnit;
import mk.ukim.finki.wp.repository.db.ArticleUnitRepository;
import mk.ukim.finki.wp.service.db.ArticleUnitService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class ArticleUnitServiceImpl extends
		BaseEntityCrudServiceImpl<ArticleUnit, ArticleUnitRepository> implements ArticleUnitService {

	@Autowired
	private ArticleUnitRepository repository;

	@Override
	protected ArticleUnitRepository getRepository() {
		return repository;
	}

}
