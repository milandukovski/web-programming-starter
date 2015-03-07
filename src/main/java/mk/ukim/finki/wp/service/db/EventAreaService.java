package mk.ukim.finki.wp.service.db;

import java.util.List;

import mk.ukim.finki.wp.model.db.EventArea;
import mk.ukim.finki.wp.service.BaseEntityCrudService;

public interface EventAreaService extends BaseEntityCrudService<EventArea> {
	public List<EventArea> findByName(String name);
}
