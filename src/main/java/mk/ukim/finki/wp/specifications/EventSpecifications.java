package mk.ukim.finki.wp.specifications;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.model.db.SvrRc;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EventSpecifications implements BaseSpecification<Event> {

	public static DateTimeFormatter DATE_TIME = DateTimeFormat
			.forPattern("yyyy-MM-dd");

	static Specification<Event> date(final DateTime date) {
		return new Specification<Event>() {

			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.between(root.<DateTime> get("checkOutTime"), date,
						date.plusDays(1));
			}

		};
	}

	static Specification<Event> datumFrom(final DateTime date) {
		return new Specification<Event>() {

			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.greaterThanOrEqualTo(root.<DateTime> get("datum"),
						date);
			}

		};
	}

	static Specification<Event> dateTo(final DateTime date) {
		return new Specification<Event>() {

			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.lessThanOrEqualTo(
						root.<DateTime> get("checkOutTime"), date);
			}

		};
	}

	static Specification<Event> svrrc(final long id) {
		return new Specification<Event>() {

			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Long> get("svrRC"), id);
			}

		};
	}

	static Specification<Event> policeStation(final long id) {
		return new Specification<Event>() {
			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Long> get("policeStation"), id);
			}

		};
	}

	static Specification<Event> durationValidity(final boolean invalid) {
		return new Specification<Event>() {
			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("invalid"), invalid);
			}

		};
	}

	static Specification<Event> checkInValidity(final boolean invalid) {
		return new Specification<Event>() {
			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Boolean> get("invalidCheckIn"), invalid);
			}

		};
	}

	static Specification<Event> shift(final Long id) {
		return new Specification<Event>() {
			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Long> get("shiftId"), id);
			}

		};
	}

	static Specification<Event> checkInOutType(final Long id) {
		return new Specification<Event>() {
			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Long> get("checkInOutTypeId"), id);
			}

		};
	}

	static Specification<Event> betweenDate(final DateTime from,
			final DateTime to) {
		return new Specification<Event>() {
			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.between(root.<DateTime> get("datum"), from, to);
			}

		};
	}

	static Specification<Event> eventCase(final long id) {
		return new Specification<Event>() {
			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Long> get("ecase"), id);
			}

		};
	}

	static Specification<Event> municipality(final long id) {
		return new Specification<Event>() {
			@Override
			public Predicate toPredicate(Root<Event> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.<Long> get("opstina"), id);
			}

		};
	}

	@Override
	public Specification<Event> getSpecification(String field, String value) {
		if (field.equals("date")) {
			DateTime date = parseForFilter(value);
			return date(date);
		} else if (field.equals("datumFrom")) {
			DateTime date = parseForFilter(value);
			return datumFrom(date);
		} else if (field.equals("dateTo")) {
			DateTime date = parseForFilter(value);
			return dateTo(date);
		} else if (field.equals("svrrc")) {
			try {
				return svrrc(parseJsonString(value));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (field.equals("checkInOutType")) {
			return checkInOutType(Long.parseLong(value));
		} else if (field.equals("checkIn_invalid")) {
			return checkInValidity(Boolean.parseBoolean(value));
		} else if (field.equals("policeStation")) {
			try {
				return policeStation(parseJsonString(value));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (field.equals("duration_invalid")) {
			return durationValidity(Boolean.parseBoolean(value));
		} else if (field.equals("shift")) {
			return shift(Long.parseLong(value));
		} else if (field.equals("caseByMunicipality")) {
			try {
				return caseByMunicipality(value);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	 * **/
	private static long parseJsonString(String json) throws JSONException {
		JSONObject jsonObj = new JSONObject(json);
		Long pom = jsonObj.getLong("id");
		return pom;
	}

	private static Specification<Event> caseByMunicipality(String value)
			throws JSONException {
		JSONObject jsonObj = new JSONObject(value);
		Long caseId = jsonObj.getLong("caseId");
		Long mid = jsonObj.getLong("mid");
		String from = jsonObj.getString("from");
		String to = jsonObj.getString("to");
		DateTime dateF = parseForFilter(from);
		DateTime dateT = parseForFilter(to);
		return Specifications.<Event>where(null).or(municipality(mid))
		        .or(eventCase(caseId)).or(betweenDate(dateF,dateT));
	}
}
