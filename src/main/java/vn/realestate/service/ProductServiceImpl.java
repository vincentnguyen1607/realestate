package vn.realestate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.realestate.dao.ProductDAO;
import vn.realestate.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public List<Product> getProducts() {
		
		return productDAO.getProduct();
	}

}
