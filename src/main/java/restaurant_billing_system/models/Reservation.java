package restaurant_billing_system.models;

public class Reservation {
	private int id;
	private String customer_name;
	private String phone_number;
	private String date_and_time;
	private int no_of_cus;
	private int table_id;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getDate_and_time() {
		return date_and_time;
	}
	public void setDate_and_time(String date_and_time) {
		this.date_and_time = date_and_time;
	}
	public int getNo_of_cus() {
		return no_of_cus;
	}
	public void setNo_of_cus(int no_of_cus) {
		this.no_of_cus = no_of_cus;
	}
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
