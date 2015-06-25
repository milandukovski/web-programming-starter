package mk.ukim.finki.wp.repository.db;

import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.repository.JpaSpecificationRepository;
import mk.ukim.finki.wp.web.MunicipalityInfo;

import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;



public interface MunicipalityRepository extends
		JpaSpecificationRepository<Municipality> {

	public List<Municipality> findByName(String name);
	
//	@Query(value = "select b.id,b.name,b.description, case when a.total is null then 0 else a.total end as total, b.caseId from (select m.id, m.name, m.description, count(e.id) as total, 0 as caseId from mvr_event e INNER JOIN mvr_municipalities m ON e.opstina_id = m.id where e.datum>=DATE_FORMAT(?1, '%Y-%c-%e %H:%i:%s') && e.datum <= DATE_FORMAT(?2, '%Y-%c-%e %H:%i:%s') group by m.id)a right join (select m.id, m.name, m.description, 0 as total, 0 as caseId from mvr_event e RIGHT OUTER JOIN mvr_municipalities m ON e.opstina_id = m.id group by m.id) b ON a.id=b.id ", nativeQuery = true)
	@Query(value = "select m.id, m.name, m.residents, count(*)as total, 0 as caseId " +
					"from mvr_municipalities m Join mvr_event e on m.id = e.opstina_id " +
					"where e.datum between DATE_FORMAT(?1, '%Y-%c-%e %H:%i:%s') and DATE_FORMAT(?2, '%Y-%c-%e %H:%i:%s') "+
					"group by m.id", nativeQuery = true)
	List<MunicipalityInfo> total(Date from, Date to);
	
//	@Query(value = "select m.id, m.name, m.description, 0 as total, 0 as caseId from mvr_event e RIGHT OUTER JOIN mvr_municipalities m ON e.opstina_id = m.id group by m.id", nativeQuery = true)
//	List<MunicipalityInfo> getAllMunicipalities();
	
//	@Query(value = "select b.id, b.name, b.description, case when a.total is null then 0 else a.total end as total, a.ecase_id as caseId from (select m.id, m.name, m.description, count(e.id) as total, e.ecase_id from mvr_event e RIGHT OUTER JOIN mvr_municipalities m ON e.opstina_id = m.id where e.ecase_id=?1 && e.datum>=DATE_FORMAT(?2, '%Y-%c-%e %H:%i:%s') && e.datum <= DATE_FORMAT(?3, '%Y-%c-%e %H:%i:%s') group by m.id) a right join (select id, name, description, 0 as total from mvr_municipalities) b ON a.id=b.id ", nativeQuery = true)
	@Query(value = "select m.id, m.name, m.residents, count(*)as total, e.ecase_id as caseId "+
					"from mvr_municipalities m Join mvr_event e on m.id = e.opstina_id "+
					"where e.ecase_id=?1 && e.datum>=DATE_FORMAT(?2, '%Y-%c-%e %H:%i:%s') && e.datum <= DATE_FORMAT(?3, '%Y-%c-%e %H:%i:%s') "+
					"group by m.id", nativeQuery = true)
	List<MunicipalityInfo> getCaseTotal(long case_id,Date from, Date to);
	
}
