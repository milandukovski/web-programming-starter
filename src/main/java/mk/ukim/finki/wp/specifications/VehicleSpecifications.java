package mk.ukim.finki.wp.specifications;

import mk.ukim.finki.wp.model.db.Vehicle;

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

public class VehicleSpecifications implements BaseSpecification<Vehicle> {

	public static DateTimeFormatter DATE_TIME = DateTimeFormat.forPattern("yyyy-MM-dd");

	static Specification<Vehicle> date(final DateTime date) {
		return new Specification<Vehicle>() {
			@Override
			public Predicate toPredicate(Root<Vehicle> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.between(root.<DateTime> get("checkOutTime"), date, date.plusDays(1));
			}
		};
	}
	

	static Specification<Vehicle> registration(final String registration) {
		return new Specification<Vehicle>() {
			@Override
			public Predicate toPredicate(Root<Vehicle> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(cb.lower(root.<String> get("registration")), "%"+registration.toLowerCase()+"%");
			}
		};
	}
	
	
	static Specification<Vehicle> regCountry(final long regCountry) {
		return new Specification<Vehicle>() {
			@Override
			public Predicate toPredicate(Root<Vehicle> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<String> get("regCountry"), regCountry);
			}
		};
	}
	
	static Specification<Vehicle> vehicleType(final long vehicleType) {
		return new Specification<Vehicle>() {
			@Override
			public Predicate toPredicate(Root<Vehicle> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<String> get("type"), vehicleType);
			}
		};
	}
	
	static Specification<Vehicle> brend(final long brend) {
		return new Specification<Vehicle>() {
			@Override
			public Predicate toPredicate(Root<Vehicle> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<String> get("brend"), brend);
			}
		};
	}

	@Override
	public Specification<Vehicle> getSpecification(String field, String value) {
		if (field.equals("date")) {
			DateTime date = parseForFilter(value);
			return date(date);
		}else if (field.equals("registration")) 
			return registration(value);
		else if(field.equals("regCountry"))
			return regCountry(parseJsonString(value));
		else if(field.equals("vehicleType"))
			return vehicleType(parseJsonString(value));
		else if(field.equals("brend"))
			return brend(parseJsonString(value));
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
