package hospital_reg_project1.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_reg_project1.dto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updatePerson(int id, Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person receivedPerson = entityManager.find(Person.class, id);
		if (receivedPerson != null) {
			person.setPid(id);

			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
		} else {
			System.out.println("Person doesn't exist");
		}
	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = entityManager.find(Person.class, id);

		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
	}

	public void getPersonById(int id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		System.out.println(person);
	}

	public void getAllPerson() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT p FROM Person p");
		List<Person> list = query.getResultList();
		System.out.println(list);
	}

}
