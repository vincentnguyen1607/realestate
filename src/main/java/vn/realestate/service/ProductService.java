package vn.realestate.service;

import java.util.List;

import vn.realestate.entity.Product;

public interface ProductService {

	public List<Product> getProducts();

	public void saveProduct(Product product);
	
}
