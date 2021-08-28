package vn.realestate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductID")
	private int productID;
	
	@Transient
	private MultipartFile productImage;
	
	@Column(name="ProductImageLink")
	private String productImageLink;
	
	@Column(name="ProductName")
	private String productName;
	
	@Column(name="ProductAddress")
	private String productAddress;
	
	@Column(name="ProductPrice")
	private int productPrice;
	
	public Product() {
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public String getProductImageLink() {
		return productImageLink;
	}

	public void setProductImageLink(String productImageLink) {
		this.productImageLink = productImageLink;
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
		return "Product [productID=" + productID + ", productImage=" + productImage + ", productImageLink="
				+ productImageLink + ", productName=" + productName + ", productAddress=" + productAddress
				+ ", productPrice=" + productPrice + "]";
	}
}
