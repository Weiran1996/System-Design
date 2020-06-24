package Restanrant;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private int mOrderId;// this is the same as customerId imagining

	// 所以现在这个真正的order里边放的是 有数量的Item
	private List<ItemOrder> mItemOrder= new ArrayList<ItemOrder>();

	public Order() {
		mOrderId= 0;
//mItemOrder = null;

	}

	public Order(int orderId) {
		mOrderId= orderId;
	}

	public List<ItemOrder> getItemOrder() {
		return mItemOrder;
	}

	public void setItemOrder(List<ItemOrder> mItemOrder) {
		this.mItemOrder= mItemOrder;
	}

	public int getOrderId() {
		return mOrderId;
	}

	public void setOrderId(int mOrderId) {
		this.mOrderId= mOrderId;
	}

	public void addOrder(ItemOrder itemOrder) {
		mItemOrder.add(itemOrder);
	}

}
