package vn.realestate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	@GetMapping("/logout")
	 public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/login?logout";  
     }  
}
