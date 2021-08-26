package vn.realestate.dao;

import java.util.List;

import vn.realestate.entity.Product;

public interface ProductDAO {

	List<Product> getProduct();

	public void saveProduct(Product product);

}
