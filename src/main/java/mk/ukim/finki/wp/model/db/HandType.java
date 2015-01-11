package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;


@Entity
@Table(name="mvr_HandTypes")
public class HandType extends BaseEntity{
	
	private String handType;

	public String getHandType() {
		return handType;
	}

	public void setHandType(String handType) {
		this.handType = handType;
	}
	
}
