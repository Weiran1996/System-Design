package Locker;

public class Locker {
	LockerStatus status;
	int id;
	Size size;
	Box box;

	public Locker(int lockid, Size s, LockerStatus lockerstatus) {
		id= lockid;
		size= s;
		status= lockerstatus;
	}

	public boolean isavailable() {
		return status == LockerStatus.UNOCCUPIED;
	}

	public boolean canFitbox(Box b) {
		return isavailable() && size == b.size;
	}

}
