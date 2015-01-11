package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;


@Entity
@Table(name="mvr_HumanCharacteristics")
public class HumanCharacteristics extends BaseEntity {
	private String humanCharacteristics;

	public String getHumanCharacteristics() {
		return humanCharacteristics;
	}

	public void setHumanCharacteristics(String humanCharacteristics) {
		this.humanCharacteristics = humanCharacteristics;
	}
	
	
}
