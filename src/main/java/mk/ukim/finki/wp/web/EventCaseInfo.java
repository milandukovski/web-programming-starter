package mk.ukim.finki.wp.web;

public class EventCaseInfo {
	public Long id;
	public String name;
	public String total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTotal() {
		return total;
	}
}