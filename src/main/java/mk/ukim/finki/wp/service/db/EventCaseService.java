package mk.ukim.finki.wp.service.db;

import java.util.List;

import mk.ukim.finki.wp.model.db.EventCase;
import mk.ukim.finki.wp.service.BaseEntityCrudService;

public interface EventCaseService extends BaseEntityCrudService<EventCase> {
	public List<EventCase> findByName(String name);
}
