package hospital_reg_project1.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_reg_project1.dto.MedItems;
import hospital_reg_project1.dto.MedOrder;

public class MedItemsDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveMedItems(int id, MedItems medItems) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		MedOrder medOrder = entityManager.find(MedOrder.class, id);
		medItems.setMedOrder(medOrder);

		entityTransaction.begin();
		entityManager.persist(medItems);
		entityTransaction.commit();
	}

	public void updateMedItems(int id, MedItems medItems) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		MedItems receivedMedItems = entityManager.find(MedItems.class, id);
		if (receivedMedItems != null) {
			medItems.setBill_id(id);

			entityTransaction.begin();
			entityManager.merge(medItems);
			entityTransaction.commit();
		} else {
			System.out.println("MedItems doesn't exists");
		}
	}

	public void deleteMedItems(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		MedItems medItems = entityManager.find(MedItems.class, id);

		entityTransaction.begin();
		entityManager.remove(medItems);
		entityTransaction.commit();
	}

	public void getMedItemsById(int id) {
		EntityManager entityManager = getEntityManager();
		MedItems medItems = entityManager.find(MedItems.class, id);
		System.out.println(medItems);
	}

	public void getAllMedItems() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT m FROM MedItems m");
		List<MedItems> medItems = query.getResultList();
		System.out.println(medItems);
	}

}
