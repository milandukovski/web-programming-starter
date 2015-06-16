package mk.ukim.finki.wp.model.db;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import mk.ukim.finki.wp.json.CustomDateDeserializer;
import mk.ukim.finki.wp.json.ShortDateSerializer;
import mk.ukim.finki.wp.model.BaseEntity;


@Entity
@Table(name="mvr_specified_persons")
@JsonIgnoreProperties(ignoreUnknown=true)
public class SpecifiedPerson extends BaseEntity{
	
	@ManyToOne
	private PersonRole personRole;
	private String comment;
	
	private String firstName;
	private String lastName;
	private String gender;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonSerialize(using = ShortDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private DateTime birthDate;
	
	private int age;
	
	private String address;
	@ManyToOne
	private Municipality opstina;
	@ManyToOne
	private City city;
	
	private String currentAddress;
	@ManyToOne
	private Municipality currentOpstina;
	@ManyToOne
	private City currentCity;
	
	@ManyToOne
	private Nationality nationality;
	
//	@ManyToMany(mappedBy="specifiedPersons")
//	private List<Event> events = new LinkedList<Event>();
	
	public PersonRole getPersonRole() {
		return personRole;
	}

	public void setPersonRole(PersonRole personRole) {
		this.personRole = personRole;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public DateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Municipality getOpstina() {
		return opstina;
	}

	public void setOpstina(Municipality opstina) {
		this.opstina = opstina;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public Municipality getCurrentOpstina() {
		return currentOpstina;
	}

	public void setCurrentOpstina(Municipality currentOpstina) {
		this.currentOpstina = currentOpstina;
	}

	public City getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(City currentCity) {
		this.currentCity = currentCity;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	
	@JsonProperty(value="fullName")
	public String getFullName(){
		return firstName+" "+lastName;
				
	}

//	public List<Event> getEvents() {
//		return events;
//	}
//
//	public void setEvents(List<Event> events) {
//		this.events = events;
//	}
	
}
