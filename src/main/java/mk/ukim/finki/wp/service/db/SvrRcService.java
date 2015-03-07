package mk.ukim.finki.wp.service.db;

import java.util.List;

import mk.ukim.finki.wp.model.db.SvrRc;
import mk.ukim.finki.wp.service.BaseEntityCrudService;

public interface SvrRcService extends BaseEntityCrudService<SvrRc> {
	public List<SvrRc> findByName(String name);
}
