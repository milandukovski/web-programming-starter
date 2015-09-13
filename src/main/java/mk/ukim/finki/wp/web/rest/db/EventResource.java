package mk.ukim.finki.wp.web.rest.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import mk.ukim.finki.wp.model.db.Event;
import mk.ukim.finki.wp.model.db.EventArea;
import mk.ukim.finki.wp.model.db.EventCase;
import mk.ukim.finki.wp.model.db.EventCommonArea;
import mk.ukim.finki.wp.model.db.EventPoliceStation;
import mk.ukim.finki.wp.model.db.Municipality;
import mk.ukim.finki.wp.model.db.SvrRc;
import mk.ukim.finki.wp.service.db.EventAreaService;
import mk.ukim.finki.wp.service.db.EventCaseService;
import mk.ukim.finki.wp.service.db.EventCommonAreaService;
import mk.ukim.finki.wp.service.db.EventPoliceStationService;
import mk.ukim.finki.wp.service.db.EventService;
import mk.ukim.finki.wp.service.db.MunicipalityService;
import mk.ukim.finki.wp.service.db.SvrRcService;
import mk.ukim.finki.wp.specifications.BaseSpecification;
import mk.ukim.finki.wp.specifications.EventSpecifications;
import mk.ukim.finki.wp.web.CrudResource;
import mk.ukim.finki.wp.web.EventCaseInfo;

@RestController
@RequestMapping("/data/rest/Event")
public class EventResource extends CrudResource<Event, EventService> {

	@Override
	public BaseSpecification<Event> getSpecification() {
		return new EventSpecifications();
	}

	@Autowired
	private EventService service;

	@Autowired
	private MunicipalityService municipalityService;

	@Autowired
	private SvrRcService SvrRcService;

	@Autowired
	private EventPoliceStationService PoliceStationService;

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

	private HashSet<String> municipalitiesOfSkopje = new HashSet<String>();
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Event> getAll(){
		return getService().findAll();
	}
	
	@RequestMapping(value = "/all/{from}/{to}", method = RequestMethod.GET, produces = "application/json")
	public LinkedList<Object> getAllFromToDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) throws JsonProcessingException{
		
		LinkedList<Object> map = new LinkedList<Object>();
		
		//EventCase
		List<EventCase> ec= CaseService.allCases();
		
		map.add(municipalityService.total(from, to));
		

		for(EventCase c : ec){
			map.add(municipalityService.getCaseTotal(c.getId(), from, to));
		}
		
		return map;
	}

	@RequestMapping(value = "/count/{from}/{to}", method = RequestMethod.GET, produces = "application/json")
	public List<EventCaseInfo> getInfoOnMunicipality(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
		return getService().getCount(from, to);
	}

	@RequestMapping(value = "/count/{id}/{from}/{to}", method = RequestMethod.GET, produces = "application/json")
	public List<EventCaseInfo> getCaseByCity(@PathVariable long id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
		return getService().getCaseByCity(id, from, to);
	}

	@RequestMapping(value = "/events/{id}/{municipality}/{from}/{to}", method = RequestMethod.GET, produces = "application/json")
	public List<Event> getEventByCase(@PathVariable long id,
			@PathVariable long municipality,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
		return getService().getEventByCase(id, municipality, from, to);
	}

//	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView  postFile(@RequestParam("file") MultipartFile file)
			throws Exception {

		System.out.println(file.getSize());
		initilaziedSkopje();
		doUpload(file.getInputStream());

		return new ModelAndView("redirect:/main.jsp");
	}

	private void initilaziedSkopje() {
		if (municipalitiesOfSkopje.isEmpty()) {
			municipalitiesOfSkopje.add("Карпош");
			municipalitiesOfSkopje.add("Ѓорче Петров");
			municipalitiesOfSkopje.add("Бутел");
			municipalitiesOfSkopje.add("Шуто Оризари");
			municipalitiesOfSkopje.add("Чаир");
			municipalitiesOfSkopje.add("Гази Баба");
			municipalitiesOfSkopje.add("Сарај");
			municipalitiesOfSkopje.add("Аеродром");
			municipalitiesOfSkopje.add("Центар");
			municipalitiesOfSkopje.add("Кисела Вода");
		}
	}

	private String capitalizeString(String string) {
		char[] chars = string.toLowerCase().toCharArray();
		boolean found = false;
		for (int i = 0; i < chars.length; i++) {
			if (!found && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				found = true;
			} else if (Character.isWhitespace(chars[i]) || chars[i] == '.'
					|| chars[i] == '\'') { // You can add other chars here
				found = false;
			}
		}
		return String.valueOf(chars);
	}
	
	private double getNumberValue(String s){
		if(s.isEmpty() || s == null)
			return 0d;
		String[] parts = s.split(" ");
		String value = parts[0].replaceAll(",", "");
		return Double.parseDouble(value);
	}

	public void doUpload(InputStream is) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\t";
		try {
			br = new BufferedReader(new InputStreamReader(is, "UTF8"));
			br.readLine();
			while ((line = br.readLine()) != null) {
				Event entity = new Event();
				String fields[] = line.split(cvsSplitBy);
				// set datum
				String t[] = fields[0].split("/");
				DateTime datum = new DateTime(Integer.parseInt(t[2]),
						Integer.parseInt(t[0]), Integer.parseInt(t[1]), 0, 0);
				entity.setDatum(datum);
				// set SVR
				List<SvrRc> svrs = SvrRcService.findByName(fields[1]);
				if (svrs == null || svrs.size() == 0) {
					SvrRc svrRc = new SvrRc();
					svrRc.setName(fields[1]);
					SvrRcService.save(svrRc);
					entity.setSvrRC(svrRc);
				} else {
					entity.setSvrRC(svrs.get(0));
				}
				// set Police Station
				List<EventPoliceStation> policeStations = PoliceStationService
						.findByName(fields[2]);
				if (policeStations == null || policeStations.size() == 0) {
					EventPoliceStation policeStation = new EventPoliceStation();
					policeStation.setName(fields[2]);
					PoliceStationService.save(policeStation);
					entity.setPoliceStation(policeStation);
				} else {
					entity.setPoliceStation(policeStations.get(0));
				}
				// set OpstaOblast
				List<EventCommonArea> commonAreas = CommonAreaService
						.findByName(fields[3]);
				if (commonAreas == null || commonAreas.size() == 0) {
					EventCommonArea commonArea = new EventCommonArea();
					commonArea.setName(fields[3]);
					CommonAreaService.save(commonArea);
					entity.setCommonArea(commonArea);
				} else {
					entity.setCommonArea(commonAreas.get(0));
				}
				// set Area Crime
				List<EventArea> areas = AreaService.findByName(fields[4]);
				if (areas == null || areas.size() == 0) {
					EventArea area = new EventArea();
					area.setName(fields[4]);
					AreaService.save(area);
					entity.setArea(area);
				} else {
					entity.setArea(areas.get(0));
				}
				// set Event Case
				List<EventCase> cases = CaseService.findByName(fields[5]);
				if (cases == null || cases.size() == 0) {
					EventCase ecase = new EventCase();
					ecase.setName(fields[5]);
					CaseService.save(ecase);
					entity.setEcase(ecase);
				} else {
					entity.setEcase(cases.get(0));
				}
				
				// set datum na slucuvanje
				String st[] = fields[6].split("/");
				String parts[] = fields[7].split(" ");
				String sh[] = parts[0].split(":");
				Date date = new Date();
				date.setYear(Integer.parseInt(st[2]));
				date.setMonth(Integer.parseInt(st[0]));
				date.setDate(Integer.parseInt(st[1]));
				date.setHours(Integer.parseInt(sh[0]));
				date.setMinutes(Integer.parseInt(sh[0]));
				date.setSeconds(0);
				if (parts[1].equals("PM") && !sh[0].equals("12"))
					date.setHours(date.getHours() + 12);
				DateTime startingDate = new DateTime(date.getYear(),
						date.getMonth(), date.getDate(), date.getHours(),
						date.getMinutes());
				entity.setStaringDate(startingDate);
				// Set vreme na slucuvanje
				entity.setStartingTime(startingDate);

				// Set opstina
				String opstina = capitalizeString(fields[8]);
				if (municipalitiesOfSkopje.contains(opstina))
					opstina = "Скопје";
				else if (opstina.equals("Сандево"))
					opstina = "Чучер Сандево";
				else if(opstina.equals("Ку﻿маново")){ // poima nema ama samo eden e vakov primer sto paga
					opstina="Куманово";
				}
				List<Municipality> opstini = municipalityService
						.findByName(opstina);
				if (opstini == null || opstini.size() == 0) {
					Municipality op = new Municipality();
					op.setName(opstina+" ????");
					municipalityService.save(op);
					entity.setOpstina(op);
				} else {
					entity.setOpstina(opstini.get(0));
				}
				// Set location
				entity.setLocation(fields[9]);
				// Set Description
				entity.setEventDescription(fields[10]);
				// Set shteta
				entity.setMaterialCost(getNumberValue(fields[11]));
				// Set benefits
				if (fields.length == 13)
					entity.setBenefit(getNumberValue(fields[12]));
				// Area ??
				/*
				 * entity.setArea(null); entity.setPoint(null);
				 * entity.setWeaponType(null); entity.setWayOfLeaving(null);
				 * entity.setMethod(null); entity.setObjectOfAttack(null);
				 * entity.setSuspectAct(null); entity.setPropertyCrime(null);
				 */
				getService().save(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
