package mk.ukim.finki.wp.model.db.view;


import javax.persistence.Column;
import javax.persistence.Entity;

import mk.ukim.finki.wp.json.CustomDateDeserializer;
import mk.ukim.finki.wp.json.ShortDateSerializer;
import mk.ukim.finki.wp.model.BaseEntity;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Subselect("SELECT * FROM event_view")
@Immutable
public class EventView extends BaseEntity{
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonSerialize(using = ShortDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "datum")
	private DateTime datum;
	
	@Column(name = "svrRc_id")
	private Long svrRC;
	
	@Column(name = "policeStation_id")
	private Long policeStation;
	
	@Column(name = "commonArea_id")
	private Long commonArea;
	
	@Column(name = "area_id")
	private Long area;
	
	@Column(name = "ecase_id")
	private Long ecase;
	
	@Column(name = "opstina_id")
	private Long opstina;
	
	@Column(name = "eventDescription", length=10000)
	private String eventDescription;

	@Column(name = "materialCost")
	private double materialCost;
	
	@Column(name = "benefit")
	private double benefit;

	public DateTime getDatum() {
		return datum;
	}

	public void setDatum(DateTime datum) {
		this.datum = datum;
	}

	public Long getSvrRC() {
		return svrRC;
	}

	public void setSvrRC(Long svrRC) {
		this.svrRC = svrRC;
	}

	public Long getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(Long policeStation) {
		this.policeStation = policeStation;
	}

	public Long getCommonArea() {
		return commonArea;
	}

	public void setCommonArea(Long commonArea) {
		this.commonArea = commonArea;
	}

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
	}

	public Long getEcase() {
		return ecase;
	}

	public void setEcase(Long ecase) {
		this.ecase = ecase;
	}

	public Long getOpstina() {
		return opstina;
	}

	public void setOpstina(Long opstina) {
		this.opstina = opstina;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public double getMaterialCost() {
		return materialCost;
	}

	public void setMaterialCost(double materialCost) {
		this.materialCost = materialCost;
	}

	public double getBenefit() {
		return benefit;
	}

	public void setBenefit(double benefit) {
		this.benefit = benefit;
	}
}	
