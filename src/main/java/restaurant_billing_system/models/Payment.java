package restaurant_billing_system.models;

public class Payment {
	private int id;
	private double total_amount;
	private String payment_method;
	private String payment_date_time;
	private int user_id;
	private int order_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getPayment_date_time() {
		return payment_date_time;
	}
	public void setPayment_date_time(String payment_date_time) {
		this.payment_date_time = payment_date_time;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	
}
