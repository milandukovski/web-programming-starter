package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;

@Entity
@Table(name="mvr_SpecifiedPersonsInEvents")
public class SpecifiedPersonInEvent extends BaseEntity {
	
	@ManyToOne
	private Event event;
	
	@ManyToOne
	private SpecifiedPerson person;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public SpecifiedPerson getPerson() {
		return person;
	}

	public void setPerson(SpecifiedPerson person) {
		this.person = person;
	}
	
}
