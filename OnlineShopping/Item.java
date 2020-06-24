package OnlineShopping;

//就是每一个产品中应该有的东西
public class Item {
	int itemId;
	String productName;
	double unitPrice;
	int quantity;
	String supplierId;

	public double calculateSubTotal() {
		return unitPrice * quantity;
	}

	public Item(String _productName, double _unitPrice, int _quantity, String _supplierId, int _productId) {
		itemId= _productId;
		productName= _productName;
		unitPrice= _unitPrice;
		quantity= _quantity;
		supplierId= _supplierId;
	}

	public int get_quantity() {
		return quantity;
	}

	public void set_quantity(int q) {
		quantity= q;
	}

	public void set_item_id(int id) {
		itemId= id;
	}

	// getters
	public String get_prod_name() {
		return productName;
	}

	public double get_unit_price() {
		return unitPrice;
	}

	public String get_supplier() {
		return supplierId;
	}

	public int get_item_id() {
		return itemId;
	}
}
