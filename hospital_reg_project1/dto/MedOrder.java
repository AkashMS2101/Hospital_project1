package hospital_reg_project1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MedOrder {

	@Id
	private int mid;
	private String date;
	private String doctor;
	@ManyToOne
	private Encounter encounter;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	@Override
	public String toString() {
		return "MedOrder [mid=" + mid + ", date=" + date + ", doctor=" + doctor + ", encounter=" + encounter + "]";
	}

}
