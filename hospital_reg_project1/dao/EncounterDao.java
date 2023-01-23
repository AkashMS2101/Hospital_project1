package hospital_reg_project1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_reg_project1.dto.Branch;
import hospital_reg_project1.dto.Encounter;
import hospital_reg_project1.dto.Person;

public class EncounterDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveEncounter(int pid, int bid, Encounter encounter) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = entityManager.find(Person.class, pid);
		encounter.setPerson(person);
		Branch branch = entityManager.find(Branch.class, bid);
		List<Branch> branchs = new ArrayList<Branch>();
		branchs.add(branch);
		encounter.setBranchs(branchs);

		entityTransaction.begin();
		entityManager.persist(encounter);
		entityTransaction.commit();
	}

	public void updateEncounter(int id, Encounter encounter,int branchId) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, branchId);
		Encounter receivedEncounter = entityManager.find(Encounter.class, id);
		if (receivedEncounter != null) {
			encounter.setEid(id);

			entityTransaction.begin();
			entityManager.merge(receivedEncounter);
			entityManager.merge(encounter);
			entityTransaction.commit();
		} else {
			System.out.println("Encounter doesn't exists");
		}
	}

	public void deleteEncounter(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Encounter encounter = entityManager.find(Encounter.class, id);

		entityTransaction.begin();
		entityManager.remove(encounter);
		entityTransaction.commit();
	}

	public void getEncounterById(int id) {
		EntityManager entityManager = getEntityManager();
		Encounter encounter = entityManager.find(Encounter.class, id);
		System.out.println(encounter);
	}

	public void getAllEncounter() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT e FROM Encounter e");
		List<Encounter> encounters = query.getResultList();
		System.out.println(encounters);
	}

}
