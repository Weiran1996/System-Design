package Coding;

import java.util.ArrayList;
import java.util.List;

public class allpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.left.left= new TreeNode(4);
		root.left.right= new TreeNode(5);
		root.right= new TreeNode(3);
		root.right.right= new TreeNode(7);
		allpath ans= new allpath();
		System.out.println(ans.allpath(root));

	}

	public List<List<Integer>> allpath(TreeNode root) {
		List<List<Integer>> res= new ArrayList<>();
		dfs(root, res, new ArrayList<>());
		return res;
	}

	public void dfs(TreeNode root, List<List<Integer>> res, List<Integer> cur) {
		if (root == null)
			return;
		cur.add(root.val);

		if (root.left == null && root.right == null) {
			res.add(new ArrayList<>(cur));
		}

		dfs(root.left, res, cur);
		dfs(root.right, res, cur);
		cur.remove(cur.size() - 1);
	}

}
