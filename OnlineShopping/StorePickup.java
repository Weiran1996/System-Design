package OnlineShopping;

import java.util.List;

class StorePickup extends Order {
	String storeUnit;

	public StorePickup(String _custId, int _orderId, OrderStatus _orderStatus, List<Item> _items, String storeId) {
		custId= _custId;
		orderId= _orderId;
		orderStatus= _orderStatus;
		items= _items;
		select_store(storeId);
	}

	public void select_store(String storeId) {
		storeUnit= storeId;
	}

	public String get_storeUnit() {
		return storeUnit;
	}
}
