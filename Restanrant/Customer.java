package Restanrant;

public class Customer {
//每个Customer都要有id和Order很正常
	private int mCustomerId; // this is same as Table id. Each customer is identified
	private Order mOrder;// by the table they occupied
	private String mCustomerName;

	public Customer() {
		mCustomerId= 0;
		mOrder= new Order(mCustomerId);
	}

	public Customer(int customerId) {
		mCustomerId= customerId;
		mOrder= new Order(customerId);
	}

	public int getCustomerId() {
		return mCustomerId;
	}

	public void setCustomerId(int mCustomerId) {
		this.mCustomerId= mCustomerId;
	}

	public void giveOrder(Item item, int numberOfPlates) {
		ItemOrder newItemOrder= new ItemOrder(item, numberOfPlates);
		mOrder.addOrder(newItemOrder);
	}

	public void iAmDone() {

	}

	public Order getOrder() {
		return mOrder;
	}

	public void setOrder(Order mOrder) {
		this.mOrder= mOrder;
	}

	public String getCustomerName() {
		return mCustomerName;
	}

	public void setCustomerName(String mCustomerName) {
		this.mCustomerName= mCustomerName;
	}
}
