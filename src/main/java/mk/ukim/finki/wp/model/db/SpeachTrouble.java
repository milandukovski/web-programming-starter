package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;


@Entity
@Table(name="mvr_SpeachTroubles")
public class SpeachTrouble extends BaseEntity {
	private String speachTrouble;

	public String getSpeachTrouble() {
		return speachTrouble;
	}

	public void setSpeachTrouble(String speachTrouble) {
		this.speachTrouble = speachTrouble;
	}
	
	
}
