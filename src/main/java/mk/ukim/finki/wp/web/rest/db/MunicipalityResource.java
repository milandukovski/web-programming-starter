package mk.ukim.finki.wp.web.rest.db;

import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.service.db.MunicipalityService;
import mk.ukim.finki.wp.web.CrudResource;
import mk.ukim.finki.wp.web.MunicipalityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/data/rest/Municipality")
public class MunicipalityResource extends CrudResource<Municipality, MunicipalityService> {

  @Autowired
  private MunicipalityService service;

  @Override
  public MunicipalityService getService() {
    return service;
  }

  @RequestMapping(value = "/total/{from}/{to}", method = RequestMethod.GET, produces = "application/json")
  public List<MunicipalityInfo> getInfoOnMunicipality(
    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
    return getService().total(from, to);
  }

  @RequestMapping(value = "/total1", method = RequestMethod.GET, produces = "application/json")
  public List<MunicipalityInfo> getInfoOnMunicipality2() {
    return getService().getAllMunicipalities();
  }

  @RequestMapping(value = "/total1/{id}/{from}/{to}", method = RequestMethod.GET, produces = "application/json")
  public List<MunicipalityInfo> getInfoOnMunicipality3(@PathVariable long id,
                                                       @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                                                       @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
    return getService().getCaseTotal(id, from, to);
  }

}