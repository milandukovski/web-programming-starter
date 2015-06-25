package mk.ukim.finki.wp.web.util;


import mk.ukim.finki.wp.model.BaseEntity;
import mk.ukim.finki.wp.specifications.BaseSpecification;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import javax.servlet.http.HttpServletRequest;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Class for extracting parameters from http requests
 */
public class RequestProcessor {

  /**
   * Parsing sort parameter
   *
   * @param request The http get request
   * @return Sort object used in JpaRepository methods
   */
  public static Sort sorting(HttpServletRequest request) {
    Enumeration<String> keys = request.getParameterNames();
    while (keys.hasMoreElements()) {
      String key = keys.nextElement();
      if (key.startsWith("sorting")) {
        String field = key.substring(key.indexOf("[") + 1,
          key.indexOf("]"));
        String direction = request.getParameter(key);
        Sort sort = new Sort(Sort.Direction.fromString(direction),
          field);
        return sort;
      }
    }
    return new Sort("id");
  }

  /**
   * Creating multiple specifications using logical AND
   *
   * @param request        The http request
   * @param specifications BaseSpecification implementation
   * @param <T>            Domain entity class
   * @return
   */
  public static <T extends BaseEntity> Specification<T> getSpecifications(
    HttpServletRequest request, BaseSpecification<T> specifications) throws JSONException {
    Enumeration<String> keys = request.getParameterNames();
    Specification<T> result = null;
    while (keys.hasMoreElements()) {
      String key = keys.nextElement();
      if (key.startsWith("filter")) {

        String value = request.getParameter(key);
        JSONObject jsonObject = new JSONObject(value);
        Iterator fields = jsonObject.keys();
        while (fields.hasNext()) {
          String field = (String) fields.next();
          String val = jsonObject.getString(field);
          result = Specifications.where(result).and(
            specifications.getSpecification(field, val));
        }
      }
    }
    return result;
  }
}