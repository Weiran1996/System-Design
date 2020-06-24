package LinuxFind;

import java.util.ArrayList;
import java.util.List;

public class FindCommand {
	File root= new File();

	// 我们是要在很多filter下的结果 可以同时apply size和type
	public List<File> findWithFilters(File directory, List<Filter> filters) {
		List<File> output= new ArrayList<>();
		// 如果根本就不是一个dir 那还找啥了 直接返回
		if (!directory.isDirectory) { return output; }
		// 在当前dir下来用filter 返回所有符合条件的file
		findWithFilters(directory, filters, output);
		return output;
	}

	private File finddirctory(String path) {
		String[] filenames= path.split("/");
		File cur= root;
		for (String name : filenames) {
			if (name.length() == 0)
				continue;
			for (File sub : cur.children) {
				if (sub.name.equals(name)) {
					cur= sub;
					break;
				}
			}
		}
		return cur;
	}

	private void findWithFilters(File directory, List<Filter> filters, List<File> output) {
		// base case, 如果当前文件夹中 没有任何file或者dir了 真的结束了 return
		if (directory.children == null) { return; }
		for (File file : directory.children) {
			// 如果当前这个是dir, 继续往里找 recursion
			if (file.isDirectory) {
				findWithFilters(file, filters, output);
			}
			// 看这个file是不是符合多重filter的标准
			else {
				boolean selectFile= true;
				for (Filter filter : filters) {
					// 有一条标准不符合 直接干灭
					if (!filter.apply(file)) {
						selectFile= false;
					}
				}
				if (selectFile) {
					output.add(file);
				}
			}
		}
	}
}
