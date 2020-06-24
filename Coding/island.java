package Coding;

import java.util.ArrayDeque;
import java.util.Deque;

public class island {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		island ans= new island();
		System.out.println(ans.maxSlidingWindow(nums, 3));
	}

	public int[] maxSlidingWindow(int[] a, int k) {
		if (a == null || k <= 0) { return new int[0]; }
		int n= a.length;
		int[] res= new int[n - k + 1];
		int index= 0;
		// 前后都可以拿出元素的
		// 而且这里存放的是index
		Deque<Integer> q= new ArrayDeque<>();
		for (int i= 0; i < a.length; i++ ) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				res[index]= a[q.peek()];
				index++ ;
			}
			System.out.println(q);
		}
		return res;
	}

}
