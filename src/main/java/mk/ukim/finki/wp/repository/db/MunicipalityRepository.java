package mk.ukim.finki.wp.repository.db;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import mk.ukim.finki.wp.web.MunicipalityInfo;
import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;

public interface MunicipalityRepository extends
		JpaSpecificationRepository<Municipality> {

	@Query(value = "select m.name, m.description, count(*) as total "
			+ "from mvr_Event e, mvr_Municipalities m "
			+ "where e.opstina_id = m.id group by m.id", nativeQuery = true)
	List<MunicipalityInfo> total();

}
