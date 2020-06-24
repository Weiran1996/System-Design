package Coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Concatenate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Concatenate ans= new Concatenate();
		String[] str= new String[] { "iron", "man", "spider", "ironman",
				"spiderman", "best", "the", "thebest", "theironmanthe", "bestiron" };
		System.out.println(ans.findWords(str, "bestironman"));
	}

	public List<List<String>> findWords(String[] words, String target) {
		List<List<String>> res= new ArrayList<>();
		Set<String> set= new HashSet<>();
		for (String word : words)
			set.add(word);

//		for (String word : words) {
//			set.remove(word);
//			helper(word, set, new ArrayList<>(), res);
//			set.add(word);
//		}
		helper(target, set, new ArrayList<>(), res, 0);

		return res;
	}

	public void helper(String target, Set<String> set, List<String> cur, List<List<String>> res, int index) {
		// 还是用index作为结束最稳当 不要有什么add的操作
		if (index == target.length()) {
			res.add(new ArrayList<>(cur));
			return;
		}

		for (int i= index + 1; i <= target.length(); i++ ) {
			String prefix= target.substring(index, i);
			if (set.contains(prefix)) {
				cur.add(prefix);
				helper(target, set, cur, res, i);
				cur.remove(cur.size() - 1);
			}
		}

	}

}
