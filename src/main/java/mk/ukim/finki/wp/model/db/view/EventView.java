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
@Subselect("select * from event_view")
@Immutable
public class EventView extends BaseEntity{
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonSerialize(using = ShortDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date")
	private DateTime date;
	
	@Column(name = "svr_rc_id")
	private Long svrRcId;
	
	@Column(name = "svr_rc_name")
	private String svrRcName;
	
	@Column(name = "police_station_id")
	private Long policeStationId;
	
	@Column(name = "police_station_name")
	private String policeStationName;
	
	@Column(name = "common_area_id")
	private Long commonAreaId;
	
	@Column(name = "common_area_name")
	private String commonAreaName;
	
	@Column(name = "area_id")
	private Long areaId;
	
	@Column(name = "area_name")
	private String areaName;
	
	@Column(name = "ecase_id")
	private Long ecaseId;
	
	@Column(name = "ecase_name")
	private String ecaseName;
	
	@Column(name = "municipality_id")
	private Long municipalityId;
	
	@Column(name = "municipality_name")
	private String municipalityName;
	
	@Column(name = "municipality_residents")
	private int municipalityResidents;
	
	@Column(name = "material_cost")
	private double materialCost;
	
	@Column(name = "benefit")
	private double benefit;

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public Long getSvrRcId() {
		return svrRcId;
	}

	public void setSvrRcId(Long svrRcId) {
		this.svrRcId = svrRcId;
	}

	public String getSvrRcName() {
		return svrRcName;
	}

	public void setSvrRcName(String svrRcName) {
		this.svrRcName = svrRcName;
	}

	public Long getPoliceStationId() {
		return policeStationId;
	}

	public void setPoliceStationId(Long policeStationId) {
		this.policeStationId = policeStationId;
	}

	public String getPoliceStationName() {
		return policeStationName;
	}

	public void setPoliceStationName(String policeStationName) {
		this.policeStationName = policeStationName;
	}

	public Long getCommonAreaId() {
		return commonAreaId;
	}

	public void setCommonAreaId(Long commonAreaId) {
		this.commonAreaId = commonAreaId;
	}

	public String getCommonAreaName() {
		return commonAreaName;
	}

	public void setCommonAreaName(String commonAreaName) {
		this.commonAreaName = commonAreaName;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Long getEcaseId() {
		return ecaseId;
	}

	public void setEcaseId(Long ecaseId) {
		this.ecaseId = ecaseId;
	}

	public String getEcaseName() {
		return ecaseName;
	}

	public void setEcaseName(String ecaseName) {
		this.ecaseName = ecaseName;
	}

	public Long getMunicipalityId() {
		return municipalityId;
	}

	public void setMunicipalityId(Long municipalityId) {
		this.municipalityId = municipalityId;
	}

	public String getMunicipalityName() {
		return municipalityName;
	}

	public void setMunicipalityName(String municipalityName) {
		this.municipalityName = municipalityName;
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

	public int getMunicipalityResidents() {
		return municipalityResidents;
	}

	public void setMunicipalityResidents(int municipalityResidents) {
		this.municipalityResidents = municipalityResidents;
	}
}