package restaurant_billing_system.models;

public class MenuItem {
	private int id;
	private String name;
	private String description;
	private double price;
	private int menu_item_type_id;
	private String menu_item_type_name;
	
	public String getMenu_item_type_name() {
		return menu_item_type_name;
	}
	public void setMenu_item_type_name(String menu_item_type_name) {
		this.menu_item_type_name = menu_item_type_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getMenu_item_type_id() {
		return menu_item_type_id;
	}
	public void setMenu_item_type_id(int menu_item_type_id) {
		this.menu_item_type_id = menu_item_type_id;
	}	
}
