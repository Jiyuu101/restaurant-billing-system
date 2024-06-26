package restaurant_billing_system.models;

public class Order {
	private int id;
	private String status;
	private String date_and_time;
	private int table_id;
	private int payment_id;
	private double total_price;
	
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
	
	
}
