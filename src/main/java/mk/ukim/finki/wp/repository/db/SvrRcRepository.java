package mk.ukim.finki.wp.repository.db;

import java.util.List;

import mk.ukim.finki.wp.model.db.SvrRc;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;

public interface SvrRcRepository extends JpaSpecificationRepository<SvrRc> {

	public List<SvrRc> findByName(String name);
}
