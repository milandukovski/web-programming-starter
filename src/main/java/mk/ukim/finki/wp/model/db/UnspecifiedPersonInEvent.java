package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;

@Entity
@Table(name="mvr_UnspecifiedPersonsInEvents")
public class UnspecifiedPersonInEvent extends BaseEntity {
	
	@ManyToOne
	private Event event;
	
	@ManyToOne
	private UnspecifiedPerson person;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public UnspecifiedPerson getPerson() {
		return person;
	}

	public void setPerson(UnspecifiedPerson person) {
		this.person = person;
	}
	
}
