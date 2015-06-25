package mk.ukim.finki.wp.web;

public class MunicipalityInfo {
	public Long id;
	public String name;
	public Long residents;
	public Long total;
	public Long caseId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public Long getTotal() {
		return total;
	}

	public Long getResidents() {
		return residents;
	}

	public void setResidents(Long residents) {
		this.residents = residents;
	}

	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
	
}
