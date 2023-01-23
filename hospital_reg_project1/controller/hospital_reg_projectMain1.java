package hospital_reg_project1.controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import hospital_reg_project1.dao.AddressDao;
import hospital_reg_project1.dao.BranchDao;
import hospital_reg_project1.dao.EncounterDao;
import hospital_reg_project1.dao.HospitalDao;
import hospital_reg_project1.dao.MedItemsDao;
import hospital_reg_project1.dao.MedOrderDao;
import hospital_reg_project1.dao.PersonDao;
import hospital_reg_project1.dto.Address;
import hospital_reg_project1.dto.Branch;
import hospital_reg_project1.dto.Encounter;
import hospital_reg_project1.dto.Hospital;
import hospital_reg_project1.dto.MedItems;
import hospital_reg_project1.dto.MedOrder;
import hospital_reg_project1.dto.Person;

public class hospital_reg_projectMain1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MedItems items = new MedItems();
		Person person = new Person();
		Hospital hospital = new Hospital();
		Branch branch = new Branch();
		Address address = new Address();
		Encounter encounter = new Encounter();
		MedOrder medOrder = new MedOrder();
		HospitalDao dao = new HospitalDao();
		BranchDao branchDao = new BranchDao();
		AddressDao addressDao = new AddressDao();
		PersonDao personDao = new PersonDao();
		EncounterDao encounterDao = new EncounterDao();
		MedOrderDao medOrderDao = new MedOrderDao();
		MedItemsDao itemsDao = new MedItemsDao();
		boolean mainexit = true;
		do {
			System.out.println("enter the option");
			System.out.println("1.Hospital \n2.Person \n3.to exit");
			int mainChoice = scanner.nextInt();
			switch (mainChoice) {
			case 1: {
				boolean exit = true;
				do {
					System.out.println("enter the option");
					System.out.println("1.to enter hospital \n2.to enter the branch \n3.to enter address \n4.to exit");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1: {
						System.out.println("enter the h_id");
						hospital.setHid(scanner.nextInt());
						System.out.println("enter the h_name");
						hospital.setHname(scanner.next());
						System.out.println("enter the email");
						hospital.setEmail(scanner.next());
						System.out.println("enter rhe website");
						hospital.setWebsite(scanner.next());

						dao.saveHospital(hospital);
						break;
					}
					case 2: {
						dao.getAllHospital();
						System.out.println("enter the hospital id to enter branch for");
						int h_id = scanner.nextInt();
						System.out.println("enter b_id");
						branch.setBid(scanner.nextInt());
						System.out.println("enter the b_name");
						branch.setBname(scanner.next());
						System.out.println("enter the city");
						branch.setCity(scanner.next());
						System.out.println("enter the state");
						branch.setState(scanner.next());
						System.out.println("enter the country");
						branch.setCountry(scanner.next());

						branchDao.saveBranch(h_id, branch);
						System.out.println("Branch added successfully");
						break;
					}
					case 3: {
						branchDao.getAllBranch();
						System.out.println("enter the branch id to enter address for");
						int b_id = scanner.nextInt();
						System.out.println("enter add_id");
						address.setAid(scanner.nextInt());
						System.out.println("Enter street name");
						address.setStreet(scanner.next());
						System.out.println("enter the cross");
						address.setCross(scanner.next());

						addressDao.saveAddress(b_id, address);
						break;
					}
					case 4: {
						exit = false;
						break;
					}
					}
				} while (exit);

				break;
			}
			case 2: {
				boolean exit2 = true;
				do {
					System.out.println("enter the choice");
					System.out.println(
							"1.to enter the person \n2.to enter the encounter details \n3.to enter the Medorder \n4.to enter the MedItems \n5.exit");
					int choise = scanner.nextInt();
					switch (choise) {
					case 1: {
						System.out.println("Enter the person details");

						System.out.println("enter person id");
						person.setPid(scanner.nextInt());
						System.out.println("enter the person name");
						person.setPname(scanner.next());
						System.out.println("enter the person address");
						person.setPaddress(scanner.next());
						System.out.println("enter the person phone");
						person.setPhone(scanner.nextLong());

						personDao.savePerson(person);
						System.out.println("person saved successfully");
						break;
					}

					case 2: {
						System.out.println("enter the details for encounter");

						System.out.println("enter the encounte id");
						encounter.setEid(scanner.nextInt());
						System.out.println("enter the disease");
						encounter.setDisease(scanner.next());
						System.out.println("enter the date");
						encounter.setDate(scanner.next());

						System.out.println("here is our branches details,choose any one");
						branchDao.getAllBranch();
						System.out.println("enter person id");
						int pid = scanner.nextInt();
						System.out.println("enter the branch id");
						int bid = scanner.nextInt();

						encounterDao.saveEncounter(pid, bid, encounter);

						break;
					}
					case 3: {
						System.out.println("enter the encounter id");
						int id = scanner.nextInt();
						System.out.println("enter the MedOrder details");
						System.out.println("enter the medOrder id");
						medOrder.setMid(scanner.nextInt());
						System.out.println("enter the date");
						medOrder.setDate(scanner.next());
						System.out.println("enter the consultant doctor name");
						medOrder.setDoctor(scanner.next());

						medOrderDao.saveMedOrder(id, medOrder);
						break;
					}

					case 4: {

						System.out.println("enter the MedItems details");
						medOrderDao.getAllMedOrder();
						System.out.println("enter your medOrder id");
						int med_id = scanner.nextInt();
						System.out.println("enter the bill id");
						items.setBill_id(scanner.nextInt());
						System.out.println("enter tablet name");
						items.setTab_name(scanner.next());
						System.out.println("enter bill amout");
						items.setBill_amount(scanner.nextLong());

						itemsDao.saveMedItems(med_id, items);

						break;
					}

					case 5: {
						exit2 = false;
						break;
					}
					}

				} while (exit2);
				break;
			}

			case 3: {
				mainexit = false;
				break;
			}
			}
		} while (mainexit);

	}
}
