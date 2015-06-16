package mk.ukim.finki.wp.model.db;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumns;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mk.ukim.finki.wp.json.CustomDateDeserializer;
import mk.ukim.finki.wp.json.ShortDateSerializer;
import mk.ukim.finki.wp.json.TimeDeserializer;
import mk.ukim.finki.wp.json.TimeSerializer;
import mk.ukim.finki.wp.model.BaseEntity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="mvr_event")
public class Event extends BaseEntity{
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonSerialize(using = ShortDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private DateTime datum;
	
	@ManyToOne()
	private SvrRc svrRC;
	
	@ManyToOne()
	private EventPoliceStation policeStation;
	
	@ManyToOne()
	private EventCommonArea commonArea;
	
	@ManyToOne()
	private EventArea area;
	
	@ManyToOne()
	private EventCase ecase;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonSerialize(using = ShortDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private DateTime staringDate;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonSerialize(using = TimeSerializer.class)
	@JsonDeserialize(using = TimeDeserializer.class)
	@DateTimeFormat(pattern = "HH:mm")
	private DateTime startingTime;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonSerialize(using = ShortDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private DateTime endingDate;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonSerialize(using = TimeSerializer.class)
	@JsonDeserialize(using = TimeDeserializer.class)
	@DateTimeFormat(pattern = "HH:mm")
	private DateTime endingTime;
	
	@ManyToOne
	private Municipality opstina;
	
	private String location;
	
	@Column(length=10000)
	private String eventDescription;
	
	//treba da bidat double
	private String materialCost;
	private String benefit;
	
	
//	@ManyToMany(cascade = { CascadeType.ALL })  
//	@JoinTable(name = "specified_person_in_event", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = { @JoinColumn(name = "person_id") })  
//	private List<SpecifiedPerson> specifiedPersons = new LinkedList<SpecifiedPerson>();
//	
//	@ManyToMany
//	private List<UnspecifiedPerson> unspecifiedPersons;
//	
//	@ManyToMany
//	private List<Vehicle> vehicles;
//	
//	@ManyToMany
//	private List<Article> articles;
	
	@ManyToOne()
	private EventPointsOfEntry point;
	
	@ManyToOne()
	private EventMethodOfEntering method;
	
	@ManyToOne()
	private EventSuspectAct suspectAct;
	
	@ManyToOne()
	private EventCrimesAgainstProperty propertyCrime;
	
	@ManyToOne()
	private EventObjectOfAttack objectOfAttack;
	
	@ManyToOne()
	private EventWayOfLeaving wayOfLeaving;
	
	@ManyToOne()
	private EventWeaponType weaponType;

	public DateTime getDatum() {
		return datum;
	}

	public void setDatum(DateTime datum) {
		this.datum = datum;
	}

	public SvrRc getSvrRC() {
		return svrRC;
	}

	public void setSvrRC(SvrRc svrRC) {
		this.svrRC = svrRC;
	}

	public EventPoliceStation getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(EventPoliceStation policeStation) {
		this.policeStation = policeStation;
	}

	public EventCommonArea getCommonArea() {
		return commonArea;
	}

	public void setCommonArea(EventCommonArea commonArea) {
		this.commonArea = commonArea;
	}

	public EventArea getArea() {
		return area;
	}

	public void setArea(EventArea area) {
		this.area = area;
	}

	public EventCase getEcase() {
		return ecase;
	}

	public void setEcase(EventCase ecase) {
		this.ecase = ecase;
	}

	public DateTime getStaringDate() {
		return staringDate;
	}

	public void setStaringDate(DateTime staringDate) {
		this.staringDate = staringDate;
	}

	public DateTime getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(DateTime startingTime) {
		this.startingTime = startingTime;
	}

	public DateTime getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(DateTime endingDate) {
		this.endingDate = endingDate;
	}

	public DateTime getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(DateTime endingTime) {
		this.endingTime = endingTime;
	}

	public Municipality getOpstina() {
		return opstina;
	}

	public void setOpstina(Municipality opstina) {
		this.opstina = opstina;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getMaterialCost() {
		return materialCost;
	}

	public void setMaterialCost(String materialCost) {
		this.materialCost = materialCost;
	}

	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	public EventPointsOfEntry getPoint() {
		return point;
	}

	public void setPoint(EventPointsOfEntry point) {
		this.point = point;
	}

	public EventMethodOfEntering getMethod() {
		return method;
	}

	public void setMethod(EventMethodOfEntering method) {
		this.method = method;
	}

	public EventSuspectAct getSuspectAct() {
		return suspectAct;
	}

	public void setSuspectAct(EventSuspectAct suspectAct) {
		this.suspectAct = suspectAct;
	}

	public EventCrimesAgainstProperty getPropertyCrime() {
		return propertyCrime;
	}

	public void setPropertyCrime(EventCrimesAgainstProperty propertyCrime) {
		this.propertyCrime = propertyCrime;
	}

	public EventObjectOfAttack getObjectOfAttack() {
		return objectOfAttack;
	}

	public void setObjectOfAttack(EventObjectOfAttack objectOfAttack) {
		this.objectOfAttack = objectOfAttack;
	}

	public EventWayOfLeaving getWayOfLeaving() {
		return wayOfLeaving;
	}

	public void setWayOfLeaving(EventWayOfLeaving wayOfLeaving) {
		this.wayOfLeaving = wayOfLeaving;
	}

	public EventWeaponType getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(EventWeaponType weaponType) {
		this.weaponType = weaponType;
	}

//	public List<SpecifiedPerson> getSpecifiedPersons() {
//		return specifiedPersons;
//	}
//
//	public void setSpecifiedPersons(List<SpecifiedPerson> specifiedPersons) {
//		this.specifiedPersons = specifiedPersons;
//	}
//
//	public List<UnspecifiedPerson> getUnspecifiedPersons() {
//		return unspecifiedPersons;
//	}
//
//	public void setUnspecifiedPersons(List<UnspecifiedPerson> unspecifiedPersons) {
//		this.unspecifiedPersons = unspecifiedPersons;
//	}
//
//	public List<Vehicle> getVehicles() {
//		return vehicles;
//	}
//
//	public void setVehicles(List<Vehicle> vehicles) {
//		this.vehicles = vehicles;
//	}
//
//	public List<Article> getArticles() {
//		return articles;
//	}
//
//	public void setArticles(List<Article> articles) {
//		this.articles = articles;
//	}
	
}	
