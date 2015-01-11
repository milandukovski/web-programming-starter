package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;

@Entity
@Table(name="mvr_EventWayOfLeaving")
public class EventWayOfLeaving extends BaseEntity {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
