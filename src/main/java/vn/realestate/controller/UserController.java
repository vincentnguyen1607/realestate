package vn.realestate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/product-form")
	public String showLeaders() {
		return "product-form";
	}
	
	
	
	@GetMapping("/admin")
	public String showSystems() {
		return "admin";
	}
	
	@GetMapping("/login")
	public String showMyLoginPage() {
		return "login";	
	}
}
