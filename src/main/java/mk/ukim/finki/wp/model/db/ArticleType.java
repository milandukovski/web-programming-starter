package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.NamedEntity;

@Entity
@Table(name="mvr_article_types")
public class ArticleType extends NamedEntity{

}
