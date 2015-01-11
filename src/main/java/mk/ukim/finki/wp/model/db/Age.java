package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;


@Entity
@Table(name="mvr_Ages")
public class Age extends BaseEntity {
	
	private String age;

	public String getName() {
		return age;
	}

	public void setName(String name) {
		this.age = name;
	}
	
}
