package OnlineShopping;

import java.util.List;

public class Customer {
	protected String custId; // email id
	protected String phone;
	protected List<Order> orders;
	protected ShoppingCart shoppingCart;

	public String get_custId() {
		return custId;
	}

	public void add_to_cart(Item item, int quant) {
		if (item.get_quantity() <= 0) {
			System.out.println("Sorry the item selected is currently out of stock");
		} else {
			Item cartItem= new Item(item.get_prod_name(), item.get_unit_price(), quant, item.get_supplier(),
				last_cart_item() + 1);
			shoppingCart.addItem(cartItem);
		}

	}

	public void remove_from_cart(int itemId) {
		shoppingCart.removeItem(itemId);
	}

	private int last_cart_item() {
		return shoppingCart.last_item();
	}

	public List<Item> view_cart() {
		System.out.println("\n\n..........Your Cart.............");
		List<Item> items= shoppingCart.viewItems();
		for (Item item : items) {
			System.out.println("" + item.productName + ":   " + item.unitPrice + "$");
			System.out.println("   		(Supplier: " + (item.supplierId.charAt(0) == 'U' ? "YoLetsShop.com" :
				eCommerceSystem.get_supplier_name(item.supplierId)) + "  Quantity: " + item.quantity);
		}
		System.out.println("                  Total Amount:" + shoppingCart.calculate_total_price());
		System.out.println("......................................");
		return items;
	}

	public List<Order> view_orders() {
		System.out.println("\n\n..........Your Orders.............");

		for (Order order : orders) {
			System.out.println("__________________________________________");
			System.out.println("Order ID:" + order.get_orderId() + "  Total: " + order.calculate_total_price() +
				"  Status: " + order.get_order_status());

			List<Item> items= order.viewItems();
			for (Item item : items) {
				System.out.println("" + item.productName + ":   " + item.unitPrice + "$");
				System.out.println("   		(Supplier: " + (item.supplierId.charAt(0) == 'U' ? "YoLetsShop.com" :
					eCommerceSystem.get_supplier_name(item.supplierId)) + "  Quantity: " + item.quantity);
			}
			System.out.println("________________________________________________");
		}
		System.out.println("......................................");
		return orders;
	}

	public List<Order> get_orders() {
		return orders;
	}

	protected int last_order() {
		if (orders.size() == 0)
			return 0;
		return orders.get(orders.size() - 1).get_orderId();
	}

	// @Requires("shoppingCart.items.size() != 0")
	// @Ensures("orders.size() == old(orders.size)+1")
	protected abstract void place_order(OrderType orderType, String storeId);
}
