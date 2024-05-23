package com.jspiders.cardekho_case_study_MVC.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekho_case_study_MVC.Pojo.CarAdminPojo;

@Repository
public class CarAdminRepository {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;

	private static void OpenConnection() {
		factory = Persistence.createEntityManagerFactory("carmvc");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void CloseConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive())
				
			{
				transaction.rollback();
			}
		}
	}

	public CarAdminPojo getAdmin() {

		OpenConnection();
		transaction.begin();

		String jpql = "from CarAdminPojo";
		query = manager.createQuery(jpql);

		@SuppressWarnings("unchecked")
		List<CarAdminPojo> admins = query.getResultList();

		if (admins.isEmpty() == false) {
			for (CarAdminPojo pojo : admins) {
				transaction.commit();
				CloseConnection();
				return pojo;
			}
		}

		transaction.commit();
		CloseConnection();
		return null;

	}

	public CarAdminPojo createAccount(String username, String password) {

		OpenConnection();
		transaction.begin();
		CarAdminPojo pojo = new CarAdminPojo();
		pojo.setUsername(username);
		pojo.setPassword(password);

		manager.persist(pojo);
		transaction.commit();
		CloseConnection();

		return pojo;
	}

	public  CarAdminPojo login(String username , String password) {
		
		OpenConnection();
		transaction.begin();
		
		String jpql = "from CarAdminPojo where username = '"+username+"' and password = '"+password+"'";
		
		
		query = manager.createQuery(jpql);
		
		List<CarAdminPojo>admins = query.getResultList();
		if(admins.isEmpty() == false) {
			
			for(CarAdminPojo pojo : admins) {
			transaction.commit();
			CloseConnection();
			System.out.println(pojo);
			return pojo;
			}
		}
		
		transaction.commit();
		CloseConnection();
		return null;
		
	}

}
