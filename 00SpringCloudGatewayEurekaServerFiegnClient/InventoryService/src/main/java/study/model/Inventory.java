package study.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity

public class Inventory {
	@Id
	private Long productId;
	private int quantity;
	public Inventory() {
		super();
	}
	public Inventory(Long productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
