package SchedulerDesign;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

class Room {
	int num;
	// 每个room 不同时间会有一大堆的meeting
	List<Meeting> meetings= new LinkedList();

	Room(int num) {
		this.num= num;

	}

	public void addMeeting(Meeting meet) {
		meetings.add(meet);
	}

	public void deleteMeeting(Meeting meet) {
		meetings.remove(meet);
	}

	public boolean isAvailable(Date start, Date end) {
		return true;
	}
}
