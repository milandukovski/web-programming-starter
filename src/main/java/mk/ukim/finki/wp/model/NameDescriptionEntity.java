package mk.ukim.finki.wp.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NameDescriptionEntity extends NamedEntity {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
