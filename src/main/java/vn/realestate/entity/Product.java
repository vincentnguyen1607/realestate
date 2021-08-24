package vn.realestate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductID")
	int productID;
	
	@Column(name="ProductImage")
	String productImage;
	
	@Column(name="ProductName")
	String productName;
	
	@Column(name="ProductAddress")
	String productAddress;
	
	@Column(name="ProductPrice")
	int productPrice;
	
	public Product() {
	}

	public Product(String productImage, String productName, String productAddress, int productPrice) {
		this.productImage = productImage;
		this.productName = productName;
		this.productAddress = productAddress;
		this.productPrice = productPrice;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductAddress() {
		return productAddress;
	}

	public void setProductAddress(String productAddress) {
		this.productAddress = productAddress;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productImage=" + productImage + ", productName=" + productName
				+ ", productAddress=" + productAddress + ", productPrice=" + productPrice + "]";
	}
	
}
