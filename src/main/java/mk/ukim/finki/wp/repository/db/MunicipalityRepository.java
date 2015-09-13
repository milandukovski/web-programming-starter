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
	
	@Query(value = "select m.id, m.name, m.residents, count(*)as total, 0 as caseId " +
					"from mvr_municipalities m Join mvr_event e on m.id = e.opstina_id " +
					"where e.datum between date_format(?1, '%Y-%c-%e %H:%i:%s') and date_format(?2, '%Y-%c-%e %H:%i:%s') "+
					"group by m.id", nativeQuery = true)
	List<MunicipalityInfo> total(Date from, Date to);
	
	@Query(value = "select m.id, m.name, m.residents, count(*)as total, e.ecase_id as caseId "+
					"from mvr_municipalities m Join mvr_event e on m.id = e.opstina_id "+
					"where e.ecase_id=?1 && e.datum>=date_format(?2, '%Y-%c-%e %H:%i:%s') && e.datum <= date_format(?3, '%Y-%c-%e %H:%i:%s') "+
					"group by m.id", nativeQuery = true)
	List<MunicipalityInfo> getCaseTotal(long case_id,Date from, Date to);
	
}
