package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;

@Entity
@Table(name="mvr_ArticlesInEvents")
public class ArticleInEvent extends BaseEntity{
	
	@ManyToOne
	private Event event;
	
	@ManyToOne
	private Article article;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
}
