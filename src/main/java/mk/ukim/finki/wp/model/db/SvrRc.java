package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;


@Entity
@Table(name="mvr_SVRRC")
public class SvrRc extends BaseEntity{
	private String svrNamel;

	public String getSvrNamel() {
		return svrNamel;
	}

	public void setSvrNamel(String svrNamel) {
		this.svrNamel = svrNamel;
	}
	
	
}
