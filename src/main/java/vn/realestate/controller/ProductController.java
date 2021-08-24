package vn.realestate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.realestate.entity.Product;

@Controller
public class ProductController {
	@RequestMapping("/show-form")
	public String showForm(Model model) {
		Product product = new Product();
		model.addAttribute(product);
		return "product-form";
	}
}
