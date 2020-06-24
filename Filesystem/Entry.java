package Filesystem;

//这个Entry是为了给File和Directory extend用的
public abstract class Entry {
	protected Directory parent;
	protected long created;
	protected long lastUpdated;
	protected long lastAccessed;
	protected String name;

	// Constructor来声明所在的文件夹和 当前file/dir的名字
	// 从系统中获取创建时间 修改时间
	public Entry(String n, Directory p) {
		name= n;
		parent= p;
		created= System.currentTimeMillis();
		lastUpdated= System.currentTimeMillis();
		lastAccessed= System.currentTimeMillis();
	}

	public boolean delete() {
		if (parent == null)
			return false;
		// 从parent dir把当前的dir/file删除掉
		return parent.deleteEntry(this);
	}

	// 一个abstract method, 要让File和Dir分别来implement
	public abstract int size();

	// 这个是共有的 好理解 Path就是母路径 + 当前name
	public String getFullPath() {
		if (parent == null)
			return name;
		else
			return parent.getFullPath() + "/" + name;
	}
//	//把当前的Dir/file的名字修改
//	public void changeName(String n) {
//		name = n;
//	}

	public long getCreated() {
		return created;
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

	public long getLastAccessed() {
		return lastAccessed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name= name;
	}

}
