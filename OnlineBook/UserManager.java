package OnlineBook;

import java.util.HashMap;

//这个Manager作用 就是会有好多的User 来统一管理他们
public class UserManager {
	// User id和实际的User object来对应
	private HashMap<Integer, User> users;

	// 这块很有意思 加新的User这个操作 并不是在User的class中
	// 是在User的manager中
	// 用到了User的constructor来新建 并且存到库里边
	public User addUser(int id, String details, int accountType) {
		if (users.containsKey(id)) { return null; }
		User user= new User(id, details, accountType);
		users.put(id, user);
		return user;
	}

//	public boolean remove(User u) {
//		return remove(u.getID());
//	}

	// 来移除系统中的User
	public boolean remove(int id) {
		if (!users.containsKey(id)) { return false; }
		users.remove(id);
		return true;
	}

	// 找到特定的一个User 可能为了调取信息之类的
	public User find(int id) {
		return users.get(id);
	}
}
