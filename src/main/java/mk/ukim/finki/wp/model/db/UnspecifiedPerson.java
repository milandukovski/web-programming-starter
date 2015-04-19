package mk.ukim.finki.wp.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mk.ukim.finki.wp.model.BaseEntity;


@Entity
@Table(name="mvr_unspecified_persons")
public class UnspecifiedPerson extends BaseEntity {
	
	private String comment;
	
	private String gender;
	
	private String hairLength;
	
	@ManyToOne
	private PersonRole role;
	
	@ManyToOne
	private Age age;
	
	@ManyToOne
	private Height height;
	
	@ManyToOne
	private Weight weight;
	
	@ManyToOne
	private EyeColor eyeColor;
	
	@ManyToOne
	private Ethnicity ethicity;
	
	@ManyToOne
	private BodyType bodyType;
	
	@ManyToOne
	private TeethCondition teethCondition;
	
	@ManyToOne
	private HandType handType;
	
	@ManyToOne
	private HumanCharacteristics humanCharacteristics;
	
	@ManyToOne
	private HairColor hairColor;
	
	@ManyToOne
	private PhysicalCondition physicalCondition;
	
	@ManyToOne
	private FacialHairType facialHair;
	
	@ManyToOne
	private SkinType skinType;
	
	@ManyToOne
	private SpeachTrouble speachTrouble;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHairLength() {
		return hairLength;
	}

	public void setHairLength(String hairLength) {
		this.hairLength = hairLength;
	}

	public PersonRole getRole() {
		return role;
	}

	public void setRole(PersonRole role) {
		this.role = role;
	}

	public Age getAge() {
		return age;
	}

	public void setAge(Age age) {
		this.age = age;
	}

	public Height getHeight() {
		return height;
	}

	public void setHeight(Height height) {
		this.height = height;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public EyeColor getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(EyeColor eyeColor) {
		this.eyeColor = eyeColor;
	}

	public Ethnicity getEthicity() {
		return ethicity;
	}

	public void setEthicity(Ethnicity ethicity) {
		this.ethicity = ethicity;
	}

	public BodyType getBodyType() {
		return bodyType;
	}

	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}

	public TeethCondition getTeethCondition() {
		return teethCondition;
	}

	public void setTeethCondition(TeethCondition teethCondition) {
		this.teethCondition = teethCondition;
	}

	public HandType getHandType() {
		return handType;
	}

	public void setHandType(HandType handType) {
		this.handType = handType;
	}

	public HumanCharacteristics getHumanCharacteristics() {
		return humanCharacteristics;
	}

	public void setHumanCharacteristics(HumanCharacteristics humanCharacteristics) {
		this.humanCharacteristics = humanCharacteristics;
	}

	public HairColor getHairColor() {
		return hairColor;
	}

	public void setHairColor(HairColor hairColor) {
		this.hairColor = hairColor;
	}

	public PhysicalCondition getPhysicalCondition() {
		return physicalCondition;
	}

	public void setPhysicalCondition(PhysicalCondition physicalCondition) {
		this.physicalCondition = physicalCondition;
	}

	public FacialHairType getFacialHair() {
		return facialHair;
	}

	public void setFacialHair(FacialHairType facialHair) {
		this.facialHair = facialHair;
	}

	public SkinType getSkinType() {
		return skinType;
	}

	public void setSkinType(SkinType skinType) {
		this.skinType = skinType;
	}

	public SpeachTrouble getSpeachTrouble() {
		return speachTrouble;
	}

	public void setSpeachTrouble(SpeachTrouble speachTrouble) {
		this.speachTrouble = speachTrouble;
	}
	
}
