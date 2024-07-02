package restaurant_billing_system.models;

public class OrderItem {
	private int id;
	private int menu_item_id;
	private String menu_item_name;
	private double menu_item_price;
	private String menu_item_type_name;

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
	
	public String getMenu_item_name() {
		return menu_item_name;
	}
	public void setMenu_item_name(String menu_item_name) {
		this.menu_item_name = menu_item_name;
	}
	
	public double getMenu_item_price() {
		return menu_item_price;
	}
	public void setMenu_item_price(double menu_item_price) {
		this.menu_item_price = menu_item_price;
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
	public String getMenu_item_type_name() {
		return menu_item_type_name;
	}
	public void setMenu_item_type_name(String menu_item_type_name) {
		this.menu_item_type_name = menu_item_type_name;
	}
	
}
