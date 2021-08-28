package vn.realestate.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vn.realestate.entity.Product;
import vn.realestate.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	ServletContext servletContext;

	@RequestMapping("/show-form")
	public String showForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "product-form";
	}

	@RequestMapping("/save-product")
	public String saveProduct(@ModelAttribute("product") Product product) {
		MultipartFile productImage = product.getProductImage();
		String productImageLink = "C:\\workspace-spring-tool-suite\\realestate\\src\\main\\webapp\\resources\\Images\\"
				+ productImage.getOriginalFilename();
		try {
			productImage.transferTo(new File(productImageLink));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(productImageLink);
		product.setProductImageLink(productImageLink);
		System.out.println(product);
		productService.saveProduct(product);
		return "show-image"; 
	}
}
