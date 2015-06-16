package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.BaseEntity;
import mk.ukim.finki.wp.service.BaseEntityCrudService;
import mk.ukim.finki.wp.specifications.BaseSpecification;
import mk.ukim.finki.wp.web.util.RequestProcessor;
import org.json.JSONException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

public abstract class CrudResource<T extends BaseEntity, S extends BaseEntityCrudService<T>> {

  public abstract S getService();


  public BaseSpecification<T> getSpecification() {
    return null;
  }

  @RequestMapping(value = "/import", method = RequestMethod.POST, produces = "application/json")
  public void importEntities(@RequestBody @Valid List<T> entities,
                             HttpServletRequest request, HttpServletResponse response) {
    for (T entity : entities) {
      getService().save(entity);
    }
  }

  @RequestMapping(value = "/paged", method = RequestMethod.GET, produces = "application/json")
  public Page<T> getAll(@RequestParam int page, @RequestParam int count,
                        HttpServletRequest request) throws JSONException {
    Sort sort = RequestProcessor.sorting(request);
    Pageable pageable = new PageRequest(page - 1, count, sort);
    BaseSpecification<T> baseSpecification = getSpecification();
    Specification<T> specification = null;
    if (baseSpecification != null) {
      specification = RequestProcessor.getSpecifications(request, baseSpecification);
    }
    if (specification != null) {
      return getService().findAll(specification, pageable);
    }

    return getService().findAll(pageable);
  }


  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  public T create(@RequestBody @Valid T entity, HttpServletRequest request,
                  HttpServletResponse response) {
    getService().save(entity);
    return entity;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
  @Deprecated
  public void edit(@PathVariable Long id, @RequestBody @Valid T jsonEntity,
                   HttpServletRequest request, HttpServletResponse response) {
    T persistentEntity = getService().findOne(id);
    copyFields(jsonEntity, persistentEntity);
    getService().save(persistentEntity);
  }

  private void copyFields(T from, T to) {
    // TODO Auto-generated method stub

  }

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  public List<T> getAll() {
    return getService().findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  public T get(@PathVariable Long id, HttpServletRequest request,
               HttpServletResponse response) {
    T entity = getService().findOne(id);
    if (entity == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
    return entity;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
  public void delete(@PathVariable Long id, HttpServletRequest request,
                     HttpServletResponse response) {
    getService().delete(id);
  }

}
