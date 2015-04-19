package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;
import mk.ukim.finki.wp.model.NameDescriptionEntity;


@Entity
@Table(name="mvr_municipalities")
public class Municipality extends NameDescriptionEntity {

}
