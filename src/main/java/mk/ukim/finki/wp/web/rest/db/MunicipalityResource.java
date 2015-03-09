package mk.ukim.finki.wp.web.rest.db;

import mk.ukim.finki.wp.web.MunicipalityInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.service.db.MunicipalityService;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/Municipality")
public class MunicipalityResource extends CrudResource<Municipality, MunicipalityService> {

    @Autowired
    private MunicipalityService service;

    @Override
    public MunicipalityService getService() {
        return service;
    }
   
    @RequestMapping(value = "/total", method = RequestMethod.GET, produces = "application/json")
    public List<MunicipalityInfo> getInfoOnMunicipality(){
        return getService().total();
    }
    
    @RequestMapping(value = "/total1", method = RequestMethod.GET, produces = "application/json")
    public List<MunicipalityInfo> getInfoOnMunicipality2(){
        return getService().getAllMunicipalities();
    }
    
    @RequestMapping(value = "/total1/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<MunicipalityInfo> getInfoOnMunicipality3(@PathVariable long id){
        return getService().getCaseTotal(id);
    }
   
}