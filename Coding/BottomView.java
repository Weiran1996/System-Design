package Coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BottomView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.left.left= new TreeNode(4);
		root.left.right= new TreeNode(5);
		root.right= new TreeNode(3);
		root.right.right= new TreeNode(7);

		BottomView ans= new BottomView();
		System.out.println(ans.seebottom(root));
	}

	public List<Integer> seebottom(TreeNode root) {
		List<Integer> res= new ArrayList<>();
		Map<Integer, Integer> map= new HashMap<>();

		Queue<TreeNode> q= new LinkedList<>();
		Queue<Integer> idx= new LinkedList<>();

		q.add(root);
		idx.add(0);
		while (!q.isEmpty()) {
			TreeNode cur= q.poll();
			int index= idx.poll();

			map.put(index, cur.val);
			if (cur.left != null) {
				q.add(cur.left);
				idx.add(index - 1);
			}
			if (cur.right != null) {
				q.add(cur.right);
				idx.add(index + 1);
			}
		}

		int minkey= Integer.MAX_VALUE;
		int maxkey= Integer.MIN_VALUE;

		for (int key : map.keySet()) {
			minkey= Math.min(minkey, key);
			maxkey= Math.max(maxkey, key);
		}

		for (int key= minkey; key <= maxkey; key++ ) {

			res.add(map.get(key));
		}
		return res;
	}

}
