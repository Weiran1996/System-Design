
package Filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
	// 一个dir里边 可能有dirs和files 都放到一起
	protected List<Entry> contents;

	// 还是利用superclass的Constructor来偷懒
	// 然后initialize自己 contents list
	public Directory(String n, Directory p) {
		super(n, p);
		contents= new ArrayList<Entry>();
	}

	@Override
	public int size() {
		int size= 0;
		for (Entry e : contents)
			size+= e.size();
		return size;
	}

	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}

	public void addEntry(Entry entry) {
		contents.add(entry);
	}

	protected List<Entry> getContents() {
		return contents;
	}

	public int numberOfFiles() {
		return contents.size();
	}

}
