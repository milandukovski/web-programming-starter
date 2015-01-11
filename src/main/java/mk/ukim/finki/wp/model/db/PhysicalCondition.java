package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;


@Entity
@Table(name = "mvr_PhysicalConditions")
public class PhysicalCondition extends BaseEntity {
	private String physicalCondition;

	public String getPhysicalCondition() {
		return physicalCondition;
	}

	public void setPhysicalCondition(String physicalCondition) {
		this.physicalCondition = physicalCondition;
	}
	
	
}
