package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;

@Entity
@Table(name="mvr_FacialHairTypes")
public class FacialHairType extends BaseEntity {
	private String facialHairType;

	public String getFacialHairType() {
		return facialHairType;
	}

	public void setFacialHairType(String facialHairType) {
		this.facialHairType = facialHairType;
	}
	
	
}
