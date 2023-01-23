package hospital_reg_project1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	private int aid;
	private String street;
	private String crosses;
	@OneToOne
	private Branch branch;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCross() {
		return crosses;
	}

	public void setCross(String crosses) {
		this.crosses = crosses;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", street=" + street + ", cross=" + crosses + ", branch=" + branch + "]";
	}

}
