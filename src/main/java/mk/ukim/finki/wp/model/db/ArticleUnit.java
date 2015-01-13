package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.NamedEntity;


@Entity
@Table(name="mvr_ArticleUnits")
public class ArticleUnit extends NamedEntity{
	
	@ManyToOne
	private ArticleType type;


	public ArticleType getType() {
		return type;
	}

	public void setType(ArticleType type) {
		this.type = type;
	}

	
}
