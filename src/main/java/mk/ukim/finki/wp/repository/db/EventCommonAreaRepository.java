package mk.ukim.finki.wp.repository.db;

import java.util.List;

import mk.ukim.finki.wp.model.db.EventCommonArea;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;

public interface EventCommonAreaRepository extends JpaSpecificationRepository<EventCommonArea> {
	public List<EventCommonArea> findByName(String name);
}
