package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.NamedEntity;


@Entity
@Table(name="mvr_svr_rc")
public class SvrRc extends NamedEntity{
	public String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
