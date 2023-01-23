package hospital_reg_project1.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_reg_project1.dto.Hospital;

public class HospitalDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveHospital(Hospital hospital) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
	}

	private void updateHospital(int id, Hospital hospital) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital receivedHospital = entityManager.find(Hospital.class, id);
		if (receivedHospital != null) {
			hospital.setHid(id);

			entityTransaction.begin();
			entityManager.merge(hospital);
			entityTransaction.commit();
		} else {
			System.out.println("Hospital doesn't exists");
		}
	}

	public void deleteHospital(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital = entityManager.find(Hospital.class, id);

		entityTransaction.begin();
		entityManager.remove(hospital);
		entityTransaction.commit();
	}

	public void getHospitalById(int id) {
		EntityManager entityManager = getEntityManager();
		Hospital hospital = entityManager.find(Hospital.class, id);
		System.out.println(hospital);
	}

	public void getAllHospital() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT h FROM Hospital h");
		List<Hospital> hospitals = query.getResultList();
		System.out.println(hospitals);
	}

}
