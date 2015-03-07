package mk.ukim.finki.wp.service.db;

import java.util.List;

import mk.ukim.finki.wp.model.db.EventCommonArea;
import mk.ukim.finki.wp.service.BaseEntityCrudService;

public interface EventCommonAreaService extends BaseEntityCrudService<EventCommonArea> {
	public List<EventCommonArea> findByName(String name);
}
