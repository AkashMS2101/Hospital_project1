package hospital_reg_project1.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Branch {

	@Id
	private int bid;
	private String bname;
	private String city;
	private String state;
	private String country;
	@ManyToOne
	private Hospital hospital;
	@ManyToMany
	private List<Encounter> list1;

	public List<Encounter> getList() {
		return list1;
	}

	public void setList(List<Encounter> list) {
		this.list1 = list;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "Branch [bid=" + bid + ", bname=" + bname + ", city=" + city + ", state=" + state + ", country="
				+ country + ", hospital=" + hospital + ", list=" + list1 + "]";
	}

	
}
