package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;


@Entity
@Table(name="mvr_EventCommonAreas")
public class EventCommonArea extends BaseEntity {
	private String commonAreaName;

	public String getCommonAreaName() {
		return commonAreaName;
	}

	public void setCommonAreaName(String commonAreaName) {
		this.commonAreaName = commonAreaName;
	}
}
