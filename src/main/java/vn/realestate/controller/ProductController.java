package vn.realestate.controller;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.realestate.entity.Product;
import vn.realestate.service.ProductService;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/show-form")
    public String showForm(Model model) {
	Product product = new Product();
	model.addAttribute("product", product);
	return "product-form";
    }
    
    @RequestMapping(value="/save-product", method = RequestMethod.POST,
    		produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public void saveProduct(@ModelAttribute("product") Product product, HttpServletRequest request) throws UnsupportedEncodingException {
	request.setCharacterEncoding("utf-8");
	product.setProductAddress("Nguyễn");
    System.out.println(product);
    productService.saveProduct(product);
    }
}
