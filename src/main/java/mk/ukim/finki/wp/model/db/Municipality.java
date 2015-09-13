package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.NameDescriptionEntity;


@Entity
@Table(name="mvr_municipalities")
public class Municipality extends NameDescriptionEntity {
	@ManyToOne
	private SvrRc svrRc;
	
	private int residents;

	public SvrRc getSvrRc() {
		return svrRc;
	}

	public void setSvrRc(SvrRc svrRc) {
		this.svrRc = svrRc;
	}

	public int getResidents() {
		return residents;
	}

	public void setResidents(int residents) {
		this.residents = residents;
	}	
}
