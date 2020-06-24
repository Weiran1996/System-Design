package Coding;

import java.util.ArrayList;
import java.util.List;

public class Nodepath {
	List<Integer> myans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.left.left= new TreeNode(4);
		root.left.right= new TreeNode(5);
		root.right= new TreeNode(3);
		root.right.right= new TreeNode(7);
		Nodepath ans= new Nodepath();
		ans.dfs(root, 5, new ArrayList<>());
		System.out.println(ans.myans);
	}

	public List<Integer> findpath(TreeNode root, int target) {
		List<Integer> res= new ArrayList<>();
		hasnode(root, target, res);
		return res;
	}

	public boolean hasnode(TreeNode root, int target, List<Integer> res) {
		if (root == null)
			return false;
		res.add(root.val);
		if (root.val == target) { return true; }

		if (hasnode(root.left, target, res) || hasnode(root.right, target, res))
			return true;
		res.remove(res.size() - 1);

		return false;
	}

	public void dfs(TreeNode root, int target, List<Integer> res) {
		if (root == null)
			return;

		res.add(root.val);
		if (root.val == target)
			myans= new ArrayList<>(res);

		dfs(root.left, target, res);
		dfs(root.right, target, res);
		res.remove(res.size() - 1);

	}

}
