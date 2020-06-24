package Coding;

import java.util.Arrays;

public class CoinChange {
	int res= Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins= new int[] { 1, 2, 5, 10 };
		CoinChange ans= new CoinChange();
		System.out.println(ans.coinChange(coins, 30));
	}

	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		dfs(coins, 0, 0, amount);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public void dfs(int[] coins, long sum, int len, int amount) {
		// base case
		if (sum == amount) {
			res= Math.min(res, len);
			return;
		} else if (sum > amount)
			return;
		for (int i= 0; i < coins.length; i++ ) {
			sum+= coins[i];
			len++ ;
			dfs(coins, sum, len, amount);
			len-- ;
			sum-= coins[i];
		}
	}

}
