package mk.ukim.finki.wp.web.rest.db;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.model.db.EventArea;
import mk.ukim.finki.wp.model.db.EventCase;
import mk.ukim.finki.wp.model.db.EventCommonArea;
import mk.ukim.finki.wp.model.db.EventPoliceStation;
import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.model.db.SvrRc;
import mk.ukim.finki.wp.service.db.EventService;
import mk.ukim.finki.wp.service.db.MunicipalityService;
import mk.ukim.finki.wp.service.impl.db.MunicipalityServiceImpl;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/Event")
public class EventResource extends CrudResource<Event, EventService> {

	@Autowired
	private EventService service;

	@Override
	public EventService getService() {
		return service;
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String postFile(@RequestParam(value="file", required=false) MultipartFile file,
	                       @RequestParam(value="data") Object data) throws Exception {
		
		if(file == null){
			doUpload();
		}
	    System.out.println(data.toString());
	    
	    return "OK!";
	}
	
	public void doUpload(){
		String csvData = "data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		
		try {
			br = new BufferedReader(new FileReader(csvData));
			@SuppressWarnings("unused")
			String column = br.readLine();
			while ((line = br.readLine()) != null) {
				Event entity = new Event();
				
				String fields[] = line.split(cvsSplitBy);
				
				//set datum
				String t[] = fields[0].split("/");
				DateTime datum = new DateTime(Integer.parseInt(t[2]), Integer.parseInt(t[1]), Integer.parseInt(t[0]), 0, 0);
				entity.setDatum(datum);
				
				//set SVR
				SvrRc svrRc = new SvrRc();
				svrRc.setName(fields[1]);
				entity.setSvrRC(svrRc);
				
				//set Police Station
				EventPoliceStation policeStation = new EventPoliceStation();
				policeStation.setName(fields[2]);
				entity.setPoliceStation(policeStation);
				
				//set OpstaOblast
				EventCommonArea commonArea = new EventCommonArea();
				commonArea.setName(fields[3]);
				entity.setCommonArea(commonArea);
				
				//set Area Crime
				EventArea area = new EventArea();
				area.setName(fields[4]);
				entity.setArea(area);
				
				// set Event Case
				EventCase ecase = new EventCase();
				ecase.setName(fields[5]);
				entity.setEcase(ecase);
				
				//set datum na slucuvanje
				String st[] = fields[6].split("/");
				String sh[] = fields[7].split(":");
				DateTime startingDate = new DateTime(Integer.parseInt(st[2]), Integer.parseInt(st[1]), Integer.parseInt(st[0]), Integer.parseInt(sh[0]), Integer.parseInt(sh[0]));
				entity.setStaringDate(startingDate);
				
				//Set vreme na slucuvanje
				entity.setStartingTime(startingDate);
				
				//Set opstina
				String opstina = fields[8].substring(0,1).toUpperCase() + fields[8].substring(1).toLowerCase();
				MunicipalityServiceImpl MS = new MunicipalityServiceImpl();
				List<Municipality> opstini = MS.findByName("Скопје");
				for (Municipality municipality : opstini) {
					System.out.println(municipality.getName());
				}
				
				if(true == true)break;
				Municipality municipality = new Municipality();
				municipality.setName(opstina);
				entity.setOpstina(municipality);
				
				//Set location
				entity.setLocation(fields[9]);
				
				
				//Set Description
				entity.setEventDescription(fields[10]);
				
				//Set shteta
				entity.setMaterialCost(fields[11]);
				
				//Set benefits
				entity.setBenefit(fields[12]);
				
				//Area ??
				/*
				entity.setArea(null);
				entity.setPoint(null);
				entity.setWeaponType(null);
				entity.setWayOfLeaving(null);
				entity.setMethod(null);
				entity.setObjectOfAttack(null);
				entity.setSuspectAct(null);
				entity.setPropertyCrime(null);
				*/
				
				System.out.println(opstina);
				getService().save(entity);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
