package Vending;

import java.util.*;

public class VendingMachine implements VendingInterface {

	// 我们有所有Product的library 和所有Coin的library
	private Inventory<Coin> cashInventory= new Inventory<Coin>();
	private Inventory<Item> itemInventory= new Inventory<Item>();
	private long totalSales;
	// 当前正在购买的item
	private Item currentItem;
	// 客户存进来的钱币
	private long currentBalance;

	public VendingMachine() {
		initialize();
	}

	// 现在机器中每种硬币放五个， 每种不同的Product也放五个
	private void initialize() {
		// initialize machine with 5 coins of each denomination
		// and 5 cans of each Item
		for (Coin c : Coin.values()) {
			cashInventory.put(c, 5);
		}

		for (Item i : Item.values()) {
			itemInventory.put(i, 5);
		}

	}

	@Override
	public long selectItemAndGetPrice(Item item) {
		if (itemInventory.hasItem(item)) {
			currentItem= item;
			return currentItem.getPrice();
		}
		throw new SoldOutException("Sold Out, Please buy another item");
	}

	// 往cash的库存里交钱 然后更新当前balance
	@Override
	public void insertCoin(Coin coin) {
		currentBalance+= coin.getDenomination();
		cashInventory.add(coin);
	}

//把用户要的item和零钱都退回来
	@Override
	public Bucket<Item, List<Coin>> collectItemAndChange() {
		Item item= collectItem();
		totalSales= totalSales + currentItem.getPrice();

		List<Coin> change= collectChange();

		return new Bucket<Item, List<Coin>>(item, change);
	}

	// 这个就是dispense产品其实 就是钱够了
	// return回用户item 然后更新自己item的库存
	private Item collectItem() throws NotSufficientChangeException,
	            NotFullPaidException{
	        if(isFullPaid()){
	            if(hasSufficientChange()){
	                itemInventory.deduct(currentItem);
	                return currentItem;
	            }           
	            throw new NotSufficientChangeException("Not Sufficient change in 
	                                                    Inventory");
	           
	        }
	        
	        //balance的前没有存够就继续要钱
	        long remainingBalance = currentItem.getPrice() - currentBalance;
	        throw new NotFullPaidException("Price not full paid, remaining : ", 
	                                          remainingBalance);
	    }

	// 买完东西要退回零钱的过程
	private List<Coin> collectChange() {
		// 存进去的钱 减去要买东西的钱
		long changeAmount= currentBalance - currentItem.getPrice();

		// 给进去一个数目 返回零钱的组合
		List<Coin> change= getChange(changeAmount);
		// update库存中的钱 因为退给用户了
		updateCashInventory(change);
		currentBalance= 0;
		currentItem= null;
		return change;
	}

	// 什么都没买 就投完币 直接退钱来了
	@Override
	public List<Coin> refund() {
		List<Coin> refund= getChange(currentBalance);
		updateCashInventory(refund);
		currentBalance= 0;
		currentItem= null;
		return refund;
	}

	// 看看balance中的钱够不够买东西的
	private boolean isFullPaid() {
		if (currentBalance >= currentItem.getPrice()) { return true; }
		return false;
	}

	// 找钱的method 给进去一个数目 返回可能的硬币组合
	private List<Coin> getChange(long amount) throws NotSufficientChangeException{
	        List<Coin> changes = Collections.EMPTY_LIST;
	       
	        if(amount > 0){
	            changes = new ArrayList<Coin>();
	            long balance = amount;
	            while(balance > 0){
	                if(balance >= Coin.QUARTER.getDenomination() 
	                            && cashInventory.hasItem(Coin.QUARTER)){
	                    changes.add(Coin.QUARTER);
	                    balance = balance - Coin.QUARTER.getDenomination();
	                    continue;
	                   
	                }else if(balance >= Coin.DIME.getDenomination() 
	                                 && cashInventory.hasItem(Coin.DIME)) {
	                    changes.add(Coin.DIME);
	                    balance = balance - Coin.DIME.getDenomination();
	                    continue;
	                   
	                }else if(balance >= Coin.NICKLE.getDenomination() 
	                                 && cashInventory.hasItem(Coin.NICKLE)) {
	                    changes.add(Coin.NICKLE);
	                    balance = balance - Coin.NICKLE.getDenomination();
	                    continue;
	                   
	                }else if(balance >= Coin.PENNY.getDenomination() 
	                                 && cashInventory.hasItem(Coin.PENNY)) {
	                    changes.add(Coin.PENNY);
	                    balance = balance - Coin.PENNY.getDenomination();
	                    continue;
	                   
	                }else{
	                    throw new NotSufficientChangeException("NotSufficientChange,
	                                       Please try another product");
	                }
	            }
	        }
	       
	        return changes;
	    }

	// 清楚柜子里左右的零钱和item
	@Override
	public void reset() {
		cashInventory.clear();
		itemInventory.clear();
		totalSales= 0;
		currentItem= null;
		currentBalance= 0;
	}

	public void printStats() {
		System.out.println("Total Sales : " + totalSales);
		System.out.println("Current Item Inventory : " + itemInventory);
		System.out.println("Current Cash Inventory : " + cashInventory);
	}

	private boolean hasSufficientChange() {
		return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
	}

	// 看看库存中的钱够不够找零的
	private boolean hasSufficientChangeForAmount(long amount) {
		boolean hasChange= true;
		try {
			getChange(amount);
		} catch (NotSufficientChangeException nsce) {
			return hasChange= false;
		}

		return hasChange;
	}

	private void updateCashInventory(List<Coin> change) {
		for (Coin c : change) {
			cashInventory.deduct(c);
		}
	}

	public long getTotalSales() {
		return totalSales;
	}
}
