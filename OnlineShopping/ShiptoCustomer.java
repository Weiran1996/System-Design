package OnlineShopping;

import java.util.List;

class ShipToCustomer extends Order {
	ShippingInfo shippingDetails;

	public ShipToCustomer(String _custId, int _orderId, OrderStatus _orderStatus, List<Item> _items,
		ShippingInfo _shippingDetails) {
		custId= _custId;
		orderId= _orderId;
		orderStatus= _orderStatus;
		items= _items;
		set_shipping_info(_shippingDetails);
	}

	public void set_shipping_info(ShippingInfo _shippingDetails) {
		shippingDetails= _shippingDetails;
	}
}
