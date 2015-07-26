package mk.ukim.finki.wp.specifications;

import mk.ukim.finki.wp.model.db.SpecifiedPerson;
import mk.ukim.finki.wp.model.db.UnspecifiedPerson;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UnspecifiedPersonSpecifications implements BaseSpecification<UnspecifiedPerson> {

	static Specification<UnspecifiedPerson> ethicity(final long ethicity) {
		return new Specification<UnspecifiedPerson>() {
			@Override
			public Predicate toPredicate(Root<UnspecifiedPerson> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Long> get("ethicity"), ethicity);
			}
		};
	}
	
	
	static Specification<UnspecifiedPerson> eyeColor(final long eyeColor) {
		return new Specification<UnspecifiedPerson>() {
			@Override
			public Predicate toPredicate(Root<UnspecifiedPerson> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<String> get("eyeColor"), eyeColor);
			}
		};
	}
	
	static Specification<UnspecifiedPerson> hairColor(final long hairColor) {
		return new Specification<UnspecifiedPerson>() {
			@Override
			public Predicate toPredicate(Root<UnspecifiedPerson> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<String> get("hairColor"), hairColor);
			}
		};
	}
	
	static Specification<UnspecifiedPerson> comment(final String comment) {
		return new Specification<UnspecifiedPerson>() {
			@Override
			public Predicate toPredicate(Root<UnspecifiedPerson> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(cb.lower(root.<String> get("comment")), "%"+comment.toLowerCase()+"%");
			}
		};
	}
	

	@Override
	public Specification<UnspecifiedPerson> getSpecification(String field, String value) {
		if (field.equals("ethicity")) 
			return ethicity(parseJsonString(value));
		else if(field.equals("eyeColor"))
			return eyeColor(parseJsonString(value));
		else if(field.equals("hairColor"))
			return hairColor(parseJsonString(value));
		else if(field.equals("comment"))
			return comment(value);
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
