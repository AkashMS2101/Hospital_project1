package hospital_reg_project1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospital {

	@Id
	private int hid;
	private String hname;
	private String email;
	private String website;

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Hospital [hid=" + hid + ", hname=" + hname + ", email=" + email + ", website=" + website + "]";
	}

}
