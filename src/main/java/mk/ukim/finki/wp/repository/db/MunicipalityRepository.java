package mk.ukim.finki.wp.repository.db;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import mk.ukim.finki.wp.web.MunicipalityInfo;
import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;

public interface MunicipalityRepository extends
		JpaSpecificationRepository<Municipality> {

	public List<Municipality> findByName(String name);
	
	@Query(value = "select m.id, m.name, m.description, count(e.id) as total, 0 as caseId from mvr_event e RIGHT OUTER JOIN mvr_municipalities m ON e.opstina_id = m.id group by m.id", nativeQuery = true)
	List<MunicipalityInfo> total();
	
	@Query(value = "select m.id, m.name, m.description, 0 as total, 0 as caseId from mvr_event e RIGHT OUTER JOIN mvr_municipalities m ON e.opstina_id = m.id group by m.id", nativeQuery = true)
	List<MunicipalityInfo> getAllMunicipalities();
	
	@Query(value = "select b.id, b.name, b.description, case when a.total is null then 0 else a.total end as total, a.ecase_id as caseId from (select m.id, m.name, m.description, count(e.id) as total, e.ecase_id from mvr_event e RIGHT OUTER JOIN mvr_municipalities m ON e.opstina_id = m.id where e.ecase_id=?1 group by m.id) a right join (select m.id, m.name, m.description, 0 as total, e.ecase_id from mvr_event e RIGHT OUTER JOIN mvr_municipalities m ON e.opstina_id = m.id group by m.id) b ON a.id=b.id ", nativeQuery = true)
	List<MunicipalityInfo> getCaseTotal(long case_id);
	
}
