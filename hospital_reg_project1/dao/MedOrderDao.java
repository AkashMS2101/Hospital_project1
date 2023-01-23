package hospital_reg_project1.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_reg_project1.dto.Encounter;
import hospital_reg_project1.dto.MedOrder;

public class MedOrderDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveMedOrder(int id, MedOrder medOrder) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Encounter encounter = entityManager.find(Encounter.class, id);
		medOrder.setEncounter(encounter);

		entityTransaction.begin();
		entityManager.persist(medOrder);
		entityTransaction.commit();
	}

	public void updateMedOrder(int id, MedOrder medOrder) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		MedOrder receivedMedOrder = entityManager.find(MedOrder.class, id);
		if (receivedMedOrder != null) {
			medOrder.setMid(id);

			entityTransaction.begin();
			entityManager.merge(medOrder);
			entityTransaction.commit();
		} else {
			System.out.println("MedOrder doesn't exists");
		}
	}

	public void deleteMedOrder(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		MedOrder medOrder = entityManager.find(MedOrder.class, id);

		entityTransaction.begin();
		entityManager.remove(medOrder);
		entityTransaction.commit();
	}

	public void getMedOrderById(int id) {
		EntityManager entityManager = getEntityManager();
		MedOrder medOrder = entityManager.find(MedOrder.class, id);
		System.out.println(medOrder);
	}

	public void getAllMedOrder() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT m FROM MedOrder m");
		List<MedOrder> medOrders = query.getResultList();
		System.out.println(medOrders);
	}

}
