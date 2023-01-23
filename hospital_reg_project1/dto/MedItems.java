package hospital_reg_project1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MedItems {

	@Id
	private int bill_id;
	private String tab_name;
	private long bill_amount;
	@ManyToOne
	private MedOrder medOrder;

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public String getTab_name() {
		return tab_name;
	}

	public void setTab_name(String tab_name) {
		this.tab_name = tab_name;
	}

	public long getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(long bill_amount) {
		this.bill_amount = bill_amount;
	}

	public MedOrder getMedOrder() {
		return medOrder;
	}

	public void setMedOrder(MedOrder medOrder) {
		this.medOrder = medOrder;
	}

	@Override
	public String toString() {
		return "MedItems [bill_id=" + bill_id + ", tab_name=" + tab_name + ", bill_amount=" + bill_amount
				+ ", medOrder=" + medOrder + "]";
	}

}
