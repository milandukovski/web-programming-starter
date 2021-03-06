package mk.ukim.finki.wp.web.rest.db;

import mk.ukim.finki.wp.model.db.EyeColor;
import mk.ukim.finki.wp.service.db.EyeColorService;
import mk.ukim.finki.wp.web.CrudResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest/EyeColor")
public class EyeColorResource extends CrudResource<EyeColor, EyeColorService> {

  @Autowired
  private EyeColorService service;

  @Override
  public EyeColorService getService() {
    return service;
  }

}
