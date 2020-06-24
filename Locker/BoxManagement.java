package Locker;

import java.util.ArrayList;
import java.util.List;

public class BoxManagement {

	List<Box> boxes= new ArrayList<>();
	List<Locker> lockers= new ArrayList<>();

	public BoxManagement(List<Box> boxes, List<Locker> lockers) {
		this.boxes= boxes;
		this.lockers= lockers;
	}

	public List<Locker> getEmptyLocker() {
		List<Locker> res= new ArrayList<>();
		for (Locker locker : lockers) {
			if (locker.status == LockerStatus.UNOCCUPIED)
				res.add(locker);
		}
		return res;
	}

	public void assignboxtoLocker(Box box) {
		List<Locker> emptyLocker= getEmptyLocker();
		for (Locker locker : emptyLocker) {
			if (locker.size == box.size) {
				locker.status= LockerStatus.OCCUPIED;
				box.boxstatus= BoxStatus.Delivered;
				break;
			}
		}
	}

	public void deliverbox() {

	}

	public int getboxLockernum(Box box) {
		return 1;
	}
}
