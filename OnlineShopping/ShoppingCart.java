package OnlineShopping;

import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
	List<Item> items;

	public ShoppingCart() {
		items= new ArrayList<Item>();
	}

	// @Requires("item.quantity > 0")
	// @Ensures("items.size() == old(items.size)+1")
	public void addItem(Item item) {
		items.add(item);
	}

	// @Requires("itemId != 0")
	// s
	public void removeItem(int itemId) {
		for (Item item : items) {
			if (item.get_item_id() == itemId) {
				items.remove(item);
				return;
			}
		}
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

	public int last_item() {
		if (items.size() == 0)
			return 0;
		return items.get(items.size() - 1).get_item_id();
	}
}
