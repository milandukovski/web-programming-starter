package mk.ukim.finki.wp.service.impl.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.db.ArticleType;
import mk.ukim.finki.wp.repository.db.ArticleTypeRepository;
import mk.ukim.finki.wp.service.db.ArticleTypeService;
import mk.ukim.finki.wp.service.impl.BaseEntityCrudServiceImpl;

@Service
public class ArticleTypeServiceImpl extends
		BaseEntityCrudServiceImpl<ArticleType, ArticleTypeRepository> implements ArticleTypeService {

	@Autowired
	private ArticleTypeRepository repository;

	@Override
	protected ArticleTypeRepository getRepository() {
		return repository;
	}

}
