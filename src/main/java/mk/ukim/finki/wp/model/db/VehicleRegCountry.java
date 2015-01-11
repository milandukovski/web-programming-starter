package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;

@Entity
@Table(name="mvr_VehicleRegCountries")
public class VehicleRegCountry extends BaseEntity{
	private String registerCountry;

	public String getRegisterCountry() {
		return registerCountry;
	}

	public void setRegisterCountry(String registerCountry) {
		this.registerCountry = registerCountry;
	}
	
}
