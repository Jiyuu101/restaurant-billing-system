package restaurant_billing_system.models;

public class OrderItem {
	private int id;
	private int menu_item_id;
	private int order_id;
	private int quantity;
	private double price;
	private double total_price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMenu_item_id() {
		return menu_item_id;
	}
	public void setMenu_item_id(int menu_item_id) {
		this.menu_item_id = menu_item_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
	
}
