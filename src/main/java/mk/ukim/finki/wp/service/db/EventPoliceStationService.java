package mk.ukim.finki.wp.service.db;

import java.util.List;

import mk.ukim.finki.wp.model.db.EventPoliceStation;
import mk.ukim.finki.wp.service.BaseEntityCrudService;

public interface EventPoliceStationService extends BaseEntityCrudService<EventPoliceStation> {
	public List<EventPoliceStation> findByName(String name);
}
