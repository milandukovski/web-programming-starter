package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;

@Entity
@Table(name="mvr_EventSuspectActs")
public class EventSuspectAct extends BaseEntity{
	private String act;

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}
	
}
