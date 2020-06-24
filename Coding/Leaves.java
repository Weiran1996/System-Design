package Coding;

import java.util.ArrayList;
import java.util.List;

public class Leaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.left.left= new TreeNode(4);
		root.left.right= new TreeNode(5);
		root.right= new TreeNode(3);
		root.right.right= new TreeNode(7);

		Leaves ans= new Leaves();
		System.out.println(ans.findLeaves(root));

	}

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res= new ArrayList<>();
		while (root != null) {
			List<Integer> cur= new ArrayList<>();
			dfs(root, cur);
			res.add(new ArrayList<>(cur));
		}

		return res;
	}

	public void dfs(TreeNode root, List<Integer> cur) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			cur.add(root.val);
			System.out.println(cur);
			root= null;
			return;
		}

		dfs(root.left, cur);
		dfs(root.right, cur);
	}

}
