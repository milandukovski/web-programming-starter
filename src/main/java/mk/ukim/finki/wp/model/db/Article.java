package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;


@Entity
@Table(name="mvr_articles")
public class Article extends BaseEntity{
	
	@ManyToOne
	private ArticleType type;
	
	private Long num;
	
	@ManyToOne
	private ArticleUnit unit;

	public ArticleType getType() {
		return type;
	}

	public void setType(ArticleType type) {
		this.type = type;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public ArticleUnit getUnit() {
		return unit;
	}

	public void setUnit(ArticleUnit unit) {
		this.unit = unit;
	}
	
}
