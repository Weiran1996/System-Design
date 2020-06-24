package Restanrant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu {

	// 这个Menu里就是为了放一个个item的
	private List<Item> mMenu;

	// Constructor就是给菜单里加项目
	public Menu() {
		mMenu= new ArrayList<Item>();
		mMenu.add(new Item(11, "Tea", 5));
		mMenu.add(new Item(22, "Coffee", 10));
		mMenu.add(new Item(33, "Bread", 15));
	}

	public List<Item> getMenu() {
		return mMenu;
	}

	public void addItem(Item newItem) {
		mMenu.add(newItem);
	}

	public void removeItem(Item oldItem) {
		mMenu.remove(oldItem);
	}

	public void display() {
		int i= 0;
		Iterator<Item> it= mMenu.iterator();
		while (it.hasNext()) {
			Item currentItem= it.next();
			System.out.println(i + ":  " + currentItem.getItemId() + "  " + currentItem.getItemName() + "  " +
				currentItem.getItemPrice());
			i++ ;
		}
	}
}
