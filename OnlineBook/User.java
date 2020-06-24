package OnlineBook;

public class User {
	// 其实就是写出来 能想到的 User会有的特性
	private int userId;
	// detail可能是姓名啊 address这些东西
	private String details;
	// 看有没有membership optional的东西
	private int accountType;

	public void renewMembership() {}

	// 每次要新来一个User 就要说清楚这些值
	public User(int id, String details, int accountType) {
		userId= id;
		this.details= details;
		this.accountType= accountType;
	}

	/* getters and setters */
	public int getID() {
		return userId;
	}

	public void setID(int id) {
		userId= id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details= details;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType= accountType;
	}
}
