package com.jspiders.cardekho_case_study_MVC.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jspiders.cardekho_case_study_MVC.Pojo.CarAdminPojo;
import com.jspiders.cardekho_case_study_MVC.Service.CarAdminService;

@Controller
public class CarAdminController {

	@Autowired
	private CarAdminService service;

	// Create Account Page Controller
		@GetMapping("/createAccount")

		public String createAccountPage(ModelMap map) {
			CarAdminPojo pojo = service.getAdmin();

			if (pojo != null) {
				map.addAttribute("msg", "Account Already Exist");
				return "Login";
			}
			return "CreateAccount";
		}

		// create Account Controller

		@PostMapping("/createAccount")

		public String createAccount(@RequestParam String username, @RequestParam String password, ModelMap map) {

			CarAdminPojo pojo = service.createAccount(username, password);

			// Success

			if (pojo != null) {
				map.addAttribute("msg", "Account Created Successfully");
				return "Login";
			}
			// Failure
			map.addAttribute("msg", "Account Not Created");
			return "Login";
		}

		

		// Login Controller
		

		@PostMapping("/login")
		public String login(@RequestParam String username , @RequestParam String password , ModelMap map ) {
			CarAdminPojo pojo = service.login(username, password);
			
			// Success
			
			if(pojo != null) {
				map.addAttribute("login", pojo);
				
				return "Home";
			}
			map.addAttribute("msg","Invalid Username/Password");
			return "Login";
		}
		
		//LogOut Controller
		@GetMapping("/logout")
		public String logout(ModelMap map) {
			
			map.addAttribute("msg", "LogOut Successfully");
			return "Login";
		}
}
