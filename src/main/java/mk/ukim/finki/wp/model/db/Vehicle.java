package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;

@Entity
@Table(name="mvr_Vehicles")
public class Vehicle extends BaseEntity {
	private String registration;
	
	@ManyToOne
	private VehicleType type;
	
	@ManyToOne
	private VehicleBrend brend;
	
	@ManyToOne
	private VehicleModel model;
	
	@ManyToOne
	private VehicleColor color;
	
	@ManyToOne
	private VehicleRegCountry regCountry;

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public VehicleBrend getBrend() {
		return brend;
	}

	public void setBrend(VehicleBrend brend) {
		this.brend = brend;
	}

	public VehicleModel getModel() {
		return model;
	}

	public void setModel(VehicleModel model) {
		this.model = model;
	}

	public VehicleColor getColor() {
		return color;
	}

	public void setColor(VehicleColor color) {
		this.color = color;
	}

	public VehicleRegCountry getRegCountry() {
		return regCountry;
	}

	public void setRegCountry(VehicleRegCountry regCountry) {
		this.regCountry = regCountry;
	}
}
