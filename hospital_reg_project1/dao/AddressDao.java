package hospital_reg_project1.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_reg_project1.dto.Address;
import hospital_reg_project1.dto.Branch;

public class AddressDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveAddress(int id,Address address) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch = entityManager.find(Branch.class, id);
		address.setBranch(branch);

		entityTransaction.begin();
		entityManager.persist(address);
		entityManager.merge(branch);
		entityTransaction.commit();
	}

	public void updateAddress(int id, Address address) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Address receivedAddress = entityManager.find(Address.class, id);
		if (receivedAddress != null) {
			address.setAid(id);
			;

			entityTransaction.begin();
			entityManager.merge(address);
			entityTransaction.commit();
		} else {
			System.out.println("Address doesn't exists");
		}
	}

	public void deleteAddress(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Address address = entityManager.find(Address.class, id);

		entityTransaction.begin();
		entityManager.remove(address);
		entityTransaction.commit();
	}

	public void getAddressById(int id) {
		EntityManager entityManager = getEntityManager();
		Address address = entityManager.find(Address.class, id);
		System.out.println(address);
	}

	public void getAllAddress() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT a FROM Address a");
		List<Address> addresses = query.getResultList();
		System.out.println(addresses);
	}

}
