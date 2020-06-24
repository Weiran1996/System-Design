package OnlineShopping;

import java.util.Date;
import java.util.List;

public class Order {
	protected int orderId;
	protected String custId;	// email
	protected Date orderDate;
	protected OrderStatus orderStatus;
	protected List<Item> items;

	public void update_order_status(OrderStatus status) {
		orderStatus= status;
	}

	public OrderStatus get_order_status() {
		return orderStatus;
	}

	public String get_custId() {
		return custId;
	}

	public int get_orderId() {
		return orderId;
	}

	public List<Item> viewItems() {
		return items;
	}

	public double calculate_total_price() {
		double total= 0;
		for (Item item : items) {
			total+= item.calculateSubTotal();
		}
		total= (double) Math.round(total * 100) / 100;
		return total;
	}
}
