package vn.realestate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.realestate.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProduct() {
			Session session = sessionFactory.getCurrentSession();	
			List<Product> products = session.createQuery("from Product").getResultList();
			System.out.println(products);
		return products;
	}

}
