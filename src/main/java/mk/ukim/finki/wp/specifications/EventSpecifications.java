package mk.ukim.finki.wp.specifications;

import mk.ukim.finki.wp.model.db.Event;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EventSpecifications implements BaseSpecification<Event> {

  public static DateTimeFormatter DATE_TIME = DateTimeFormat
    .forPattern("yyyy-MM-dd ");

  static Specification<Event> date(final DateTime date) {
    return new Specification<Event>() {

      @Override
      public Predicate toPredicate(Root<Event> root,
                                   CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.between(root.<DateTime>get("checkOutTime"), date,
          date.plusDays(1));
      }

    };
  }

  static Specification<Event> datumFrom(final DateTime date) {
    return new Specification<Event>() {

      @Override
      public Predicate toPredicate(Root<Event> root,
                                   CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.greaterThanOrEqualTo(root.<DateTime>get("datum"), date);
      }

    };
  }

  static Specification<Event> dateTo(final DateTime date) {
    return new Specification<Event>() {

      @Override
      public Predicate toPredicate(Root<Event> root,
                                   CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.lessThanOrEqualTo(root.<DateTime>get("checkOutTime"), date);
      }

    };
  }

  static Specification<Event> employee(final Long id) {
    return new Specification<Event>() {

      @Override
      public Predicate toPredicate(Root<Event> root,
                                   CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.equal(root.<Long>get("employeeId"), id);
      }

    };
  }

  static Specification<Event> checkOutValidity(final boolean invalid) {
    return new Specification<Event>() {
      @Override
      public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.equal(root.get("invalidCheckOut"), invalid);
      }

    };
  }


  static Specification<Event> durationValidity(final boolean invalid) {
    return new Specification<Event>() {
      @Override
      public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.equal(root.get("invalid"), invalid);
      }

    };
  }

  static Specification<Event> checkInValidity(final boolean invalid) {
    return new Specification<Event>() {
      @Override
      public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.equal(root.<Boolean>get("invalidCheckIn"), invalid);
      }

    };
  }

  static Specification<Event> shift(final Long id) {
    return new Specification<Event>() {
      @Override
      public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.equal(root.<Long>get("shiftId"), id);
      }

    };
  }

  static Specification<Event> checkInOutType(final Long id) {
    return new Specification<Event>() {
      @Override
      public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.equal(root.<Long>get("checkInOutTypeId"), id);
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
    } else if (field.equals("employee")) {
      return employee(Long.parseLong(value));
    } else if (field.equals("checkInOutType")) {
      return checkInOutType(Long.parseLong(value));
    } else if (field.equals("checkIn_invalid")) {
      return checkInValidity(Boolean.parseBoolean(value));
    } else if (field.equals("checkOut_invalid")) {
      return checkOutValidity(Boolean.parseBoolean(value));
    } else if (field.equals("duration_invalid")) {
      return durationValidity(Boolean.parseBoolean(value));
    } else if (field.equals("shift")) {
      return shift(Long.parseLong(value));
    }
    return null;
  }

  public static DateTime parseForFilter(String dateString) {
    DateTime date = DATE_TIME.parseDateTime(dateString.replace("\"", ""));
    date = date.withTime(0, 0, 0, 0);
    return date;
  }
}
