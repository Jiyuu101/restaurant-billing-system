package restaurant_billing_system.models;

public class Order {
	private int id;
	private String status;
	private String date_and_time;
	private int table_id;
	private int payment_id;
	private double total_price;
	private int order_item_id;
	private String order_item_name;
	private double order_item_total_price;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate_and_time() {
		return date_and_time;
	}
	public void setDate_and_time(String date_and_time) {
		this.date_and_time = date_and_time;
	}
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
	public int getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}
	public String getOrder_item_name() {
		return order_item_name;
	}
	public void setOrder_item_name(String order_item_name) {
		this.order_item_name = order_item_name;
	}
	public double getOrder_item_total_price() {
		return order_item_total_price;
	}
	public void setOrder_item_total_price(double order_item_total_price) {
		this.order_item_total_price = order_item_total_price;
	}
	
}
