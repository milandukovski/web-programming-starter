package mk.ukim.finki.wp.web.rest.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
import mk.ukim.finki.wp.service.db.*;
import mk.ukim.finki.wp.web.EventCaseInfo;
import mk.ukim.finki.wp.web.rest.CrudResource;

@RestController
@RequestMapping("/data/rest/Event")
public class EventResource extends CrudResource<Event, EventService> {

	@Autowired
	private EventService service;
	
	@Autowired
	private MunicipalityService municipalityService;
	
	@Autowired
	private SvrRcService SvrRcService;

	@Autowired
	private EventPoloiceStationService PoliceStationService;
	
	@Autowired
	private EventCommonAreaService CommonAreaService;
	
	@Autowired
	private EventAreaService AreaService;
	
	@Autowired
	private EventCaseService CaseService;
	
	@Override
	public EventService getService() {
		return service;
	}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
	 public ArrayList<EventCaseInfo> getInfoOnMunicipality(){
	      return getService().getCount();
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
		String cvsSplitBy = "\t";
		
		try {
			br = new BufferedReader(new FileReader(csvData));
			br.readLine();
			while ((line = br.readLine()) != null) {
				Event entity = new Event();
				
				String fields[] = line.split(cvsSplitBy);
				
				//set datum
				String t[] = fields[0].split("/");
				DateTime datum = new DateTime(Integer.parseInt(t[2]), Integer.parseInt(t[0]), Integer.parseInt(t[1]), 0, 0);
				entity.setDatum(datum);
				
				//set SVR
				List<SvrRc> svrs = SvrRcService.findByName(fields[1]);
				if(svrs == null || svrs.size() == 0){
					SvrRc svrRc = new SvrRc();
					svrRc.setName(fields[1]);
					SvrRcService.save(svrRc);
					entity.setSvrRC(svrRc);
				}
				else{
					entity.setSvrRC(svrs.get(0));
				}
				//set Police Station
				List<EventPoliceStation> policeStations = PoliceStationService.findByName(fields[2]);
				if(policeStations == null || policeStations.size() == 0){
					EventPoliceStation policeStation = new EventPoliceStation();
					policeStation.setName(fields[2]);
					PoliceStationService.save(policeStation);
					entity.setPoliceStation(policeStation);
				}else{
					entity.setPoliceStation(policeStations.get(0));
				}
	
				//set OpstaOblast
				List<EventCommonArea> commonAreas = CommonAreaService.findByName(fields[3]);
				if(commonAreas == null || commonAreas.size()==0){
					EventCommonArea commonArea = new EventCommonArea();
					commonArea.setName(fields[3]);
					CommonAreaService.save(commonArea);
					entity.setCommonArea(commonArea);
				}else{
					entity.setCommonArea(commonAreas.get(0));
				}
				
				//set Area Crime
				List<EventArea> areas = AreaService.findByName(fields[4]);
				if(areas == null || areas.size()==0){
					EventArea area = new EventArea();
					area.setName(fields[4]);
					AreaService.save(area);
					entity.setArea(area);
				}else{
					entity.setArea(areas.get(0));
				}
				
				
				// set Event Case
				List<EventCase> cases = CaseService.findByName(fields[5]);
				if(cases == null || cases.size()==0){
					EventCase ecase = new EventCase();
					ecase.setName(fields[5]);
					CaseService.save(ecase);
					entity.setEcase(ecase);
				}else{
					entity.setEcase(cases.get(0));
				}
				
				//set datum na slucuvanje
				String st[] = fields[6].split("/");
				String parts [] = fields[7].split(" ");
				String sh[] = parts[0].split(":");
				Date date = new Date();
				date.setYear(Integer.parseInt(st[2]));
				date.setMonth(Integer.parseInt(st[0]));
				date.setDate(Integer.parseInt(st[1]));
				date.setHours(Integer.parseInt(sh[0]));
				date.setMinutes(Integer.parseInt(sh[0]));
				date.setSeconds(0);
				
				if(parts[1].equals("PM") && !sh[0].equals("12"))
					date.setHours(date.getHours()+12);
					
				DateTime startingDate = new DateTime(date.getYear(),date.getMonth() , date.getDate(), date.getHours(), date.getMinutes());
				
				entity.setStaringDate(startingDate);
				
				//Set vreme na slucuvanje
				entity.setStartingTime(startingDate);
				
				//Set opstina
				String opstina = fields[8].substring(0,1).toUpperCase() + fields[8].substring(1).toLowerCase();
				List<Municipality> opstini = municipalityService.findByName(opstina);
				if(opstini == null || opstini.size() == 0) {
					Municipality op = new Municipality();
					municipalityService.save(op);
					entity.setOpstina(op);
				}else{
					entity.setOpstina(opstini.get(0));
				}
				
				//Set location
				entity.setLocation(fields[9]);
				
				
				//Set Description
				entity.setEventDescription(fields[10]);
				
				//Set shteta
				entity.setMaterialCost(fields[11]);
				
				//Set benefits
				if(fields.length==13)
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
