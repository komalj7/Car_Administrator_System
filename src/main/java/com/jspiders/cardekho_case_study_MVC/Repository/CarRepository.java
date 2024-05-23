package com.jspiders.cardekho_case_study_MVC.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekho_case_study_MVC.Pojo.CarPojo;

@Repository
public class CarRepository {


	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Query query;

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("carmvc");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

	
	public CarPojo addCar(String carName, String carBrand, String carFuel, double carPrice) {
		openConnection();
		entityTransaction.begin();
		
		CarPojo pojo = new CarPojo();
		pojo.setCarName(carName);
		pojo.setCarBrand(carBrand);
		pojo.setCarFual(carFuel);
		pojo.setCarPrice(carPrice);
		
		entityManager.persist(pojo);
		
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}

	public List<CarPojo> findAllCar() {
		openConnection();
		entityTransaction.begin();
		String jpql = "from CarPojo";
		query =entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<CarPojo>cars = query.getResultList();
		entityTransaction.commit();
		closeConnection();
		return cars;
	}

	public CarPojo searchCar(int id) {
		openConnection();
		entityTransaction.begin();
		
		CarPojo pojo = entityManager.find(CarPojo.class,id);
		
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}

	public CarPojo updateCar(int id, String carName, String carBrand, String carFuel, double carPrice) {
		openConnection();
		entityTransaction.begin();
		
		CarPojo pojo = entityManager.find(CarPojo.class, id);
		pojo.setCarName(carName);
		pojo.setCarBrand(carBrand);
		pojo.setCarFual(carFuel);
		pojo.setCarPrice(carPrice);
		
		entityManager.persist(pojo);
		
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}

	public CarPojo removeCar(int id) {
		openConnection();
		entityTransaction.begin();
		
		CarPojo pojo = entityManager.find(CarPojo.class,id);
		if(pojo != null) {
			entityManager.remove(pojo);
		}
		
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}

	

}
