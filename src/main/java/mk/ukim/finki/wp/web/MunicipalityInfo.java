package mk.ukim.finki.wp.web;

public class MunicipalityInfo {
	public Long id;
	public String name;
	public String description;
	public String total;
	public Long caseId;

	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getTotal() {
		return total;
	}
}
