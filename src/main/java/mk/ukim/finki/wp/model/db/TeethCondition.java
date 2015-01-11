package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;


@Entity
@Table(name="mvr_TeethConditions")
public class TeethCondition extends BaseEntity {
	
	private String teethCondition;

	public String getTeethCondition() {
		return teethCondition;
	}

	public void setTeethCondition(String teethCondition) {
		this.teethCondition = teethCondition;
	}
	
	
}
