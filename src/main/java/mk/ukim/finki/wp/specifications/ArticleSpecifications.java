package mk.ukim.finki.wp.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.jpa.domain.Specification;

import mk.ukim.finki.wp.model.db.Article;

public class ArticleSpecifications implements BaseSpecification<Article> {
	
	static Specification<Article> articleUnit(final long unit) {
		return new Specification<Article>() {
			@Override
			public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<String> get("unit"), unit);
			}
		};
	}
	

	@Override
	public Specification<Article> getSpecification(String field, String value) {
		if(field.equals("unit"))
			return articleUnit(parseJsonString(value));
		return null;
	}


	/**
	 * parameters String json - Json string of one entity return long id of
	 * entity
	 **/
	private static long parseJsonString(String json) {
		
		Long pom = -1L;
		try {
			JSONObject jsonObj = new JSONObject(json);
			pom = jsonObj.getLong("id");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pom;
	}
}
