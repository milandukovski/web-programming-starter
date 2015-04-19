package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;

@Entity
@Table(name="mvr_vehicles_of_persons")
public class VehiclesOfPerson extends BaseEntity {
	
	private String status;
	private String comment;
	
	@ManyToOne
	private SpecifiedPerson person;
	
	@ManyToOne
	private Vehicle vehicle;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public SpecifiedPerson getPerson() {
		return person;
	}

	public void setPerson(SpecifiedPerson person) {
		this.person = person;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
