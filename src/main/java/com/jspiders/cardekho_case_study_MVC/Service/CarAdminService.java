package com.jspiders.cardekho_case_study_MVC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspiders.cardekho_case_study_MVC.Pojo.CarAdminPojo;
import com.jspiders.cardekho_case_study_MVC.Repository.CarAdminRepository;

@Service
public class CarAdminService {
	
	@Autowired 
	private CarAdminRepository repository;

	public CarAdminPojo getAdmin() {
		CarAdminPojo pojo =  repository.getAdmin();
		return pojo;
	}
	
	public CarAdminPojo createAccount(String username , String password) {
		
		CarAdminPojo pojo = repository.createAccount(username,password);
		return pojo;
	}
	
	public CarAdminPojo login(String username , String password) {
		CarAdminPojo pojo = repository.login(username,password);
		return pojo;
	}


}
