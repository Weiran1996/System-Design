package OnlineShopping;

import java.util.ArrayList;

class GuestCustomer extends Customer {

	public GuestCustomer(String _custId, String _phone) {
		orders= new ArrayList<Order>();
		shoppingCart= new ShoppingCart();
		custId= _custId;
		phone= _phone;
	}

	public void place_order(OrderType orderType, String storeId) {
		// get the shipping details from user
		ShippingInfo shippingInfo= new ShippingInfo("street 1", "682314", "1234567892", "deliverto@gmail.com");

		if (orderType == OrderType.ShipToCustomer) {
			ShipToCustomer order= new ShipToCustomer(custId, last_order() + 1, OrderStatus.ShippingOrderPlaced,
				shoppingCart.viewItems(), shippingInfo);
			orders.add(order);
		} else if (orderType == OrderType.StorePickup) {
			StorePickup order= new StorePickup(custId, last_order() + 1, OrderStatus.PickupOrderPlaced,
				shoppingCart.viewItems(), storeId);
			orders.add(order);
		}
		eCommerceSystem.add_Guest(this);
		shoppingCart= new ShoppingCart();
	}
}
