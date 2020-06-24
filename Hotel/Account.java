package Hotel;

public class Account {
	private String id;
	private String password;
	private AccountStatus status;

	public boolean resetPassword();
}

//是为了要被各种人extend的
//是每个person 应该有account
public abstract class Person {
	private String name;
	private Address address;
	private String email;
	private String phone;

	private Account account;
}

//各种不同的Person 加上自己的functionality
public class Guest extends Person {
	private int totalRoomsCheckedIn;

	public List<RoomBooking> getBookings();
}

public class Receptionist extends Person {
	public List<Member> searchMember(String name);

	public boolean createBooking();
}

public class Server extends Person {
	public boolean addRoomCharge(Room room, RoomCharge roomCharge);
}
