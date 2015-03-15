package mk.ukim.finki.wp.service.db;

import java.util.Date;
import java.util.List;

import mk.ukim.finki.wp.web.MunicipalityInfo;
import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.service.BaseEntityCrudService;

public interface MunicipalityService extends BaseEntityCrudService<Municipality> {
    
	public List<MunicipalityInfo> total(Date from, Date to);
    
    public List<MunicipalityInfo> getAllMunicipalities();
    
    public List<MunicipalityInfo> getCaseTotal(long case_id, Date from, Date to);

    public List<Municipality> findByName(String name);
}