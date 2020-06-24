package Filesystem;

public class File extends Entry {
	// 这两项属于File自己独特的field
	private String content;
	private int size;

	// File的Constructor
	public File(String n, Directory p, int sz) {
		// 用了superclass Entry的constructor 避免重复
		super(n, p);
		size= sz;
	}

	// 想一想 File其实也就只有 size，content这两个重要的东西
	// parent那些乱码七遭的都在Entry共有的地方
	@Override
	public int size() {
		return size;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String c) {
		content= c;
	}

}
