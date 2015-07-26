package mk.ukim.finki.wp.specifications;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.model.db.SpecifiedPerson;

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

public class SpecifiedPersonSpecifications implements BaseSpecification<SpecifiedPerson> {

	public static DateTimeFormatter DATE_TIME = DateTimeFormat.forPattern("yyyy-MM-dd");

	static Specification<SpecifiedPerson> firstName(final String firstName) {
		return new Specification<SpecifiedPerson>() {
			@Override
			public Predicate toPredicate(Root<SpecifiedPerson> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(cb.lower(root.<String> get("firstName")), "%"+firstName.toLowerCase()+"%");
			}
		};
	}
	

	static Specification<SpecifiedPerson> lastName(final String lastName) {
		return new Specification<SpecifiedPerson>() {
			@Override
			public Predicate toPredicate(Root<SpecifiedPerson> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(cb.lower(root.<String> get("lastName")), "%"+lastName.toLowerCase()+"%");
			}
		};
	}
	
	static Specification<SpecifiedPerson> comment(final String comment) {
		return new Specification<SpecifiedPerson>() {
			@Override
			public Predicate toPredicate(Root<SpecifiedPerson> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(cb.lower(root.<String> get("comment")), "%"+comment.toLowerCase()+"%");
			}
		};
	}
	
	static Specification<SpecifiedPerson> municipality(final long municipality) {
		return new Specification<SpecifiedPerson>() {
			@Override
			public Predicate toPredicate(Root<SpecifiedPerson> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Long> get("currentOpstina"), municipality);
			}
		};
	}
	
	
	static Specification<SpecifiedPerson> dateFrom(final DateTime date) {
		return new Specification<SpecifiedPerson>() {

			@Override
			public Predicate toPredicate(Root<SpecifiedPerson> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.greaterThanOrEqualTo(root.<DateTime> get("birthDate"), date);
			}

		};
	}
	
	static Specification<SpecifiedPerson> nationality(final long nationality) {
		return new Specification<SpecifiedPerson>() {
			@Override
			public Predicate toPredicate(Root<SpecifiedPerson> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Long> get("nationality"), nationality);
			}
		};
	}

	@Override
	public Specification<SpecifiedPerson> getSpecification(String field, String value) {
		if (field.equals("firstName")) {
			return firstName(value);
		}else if (field.equals("lastName")) 
			return lastName(value);
		else if(field.equals("dateFrom")){
			DateTime date = parseForFilter(value);
			return dateFrom(date);
		}
		else if(field.equals("municipality"))
			return municipality(parseJsonString(value));
		else if(field.equals("nationality"))
			return nationality(parseJsonString(value));
		else if(field.equals("comment"))
			return comment(value);
		return null;
	}

	public static DateTime parseForFilter(String dateString) {
		DateTime date = DATE_TIME.parseDateTime(dateString.replace("\"", ""));
		date = date.withTime(0, 0, 0, 0);
		return date;
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
