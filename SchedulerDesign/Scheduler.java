package SchedulerDesign;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Scheduler {
	List<Room> rooms= new LinkedList();
	List<Calendar> calendar;
	Scheduler(List<Room> rooms) {
		this.rooms= rooms;
	}

	public boolean book(Date start, Date end) {
		for (Room room : rooms) {
			if (room.isAvailable(start, end)) { return true; }
		}
		return false;
	}
	
	public List<Calendar> getCalenderbyroom() {
		
	}
	
	public Calendar getCalendarbymeeting(int id) {
		
	}
	
	public void cancel() {
		
	}
	
	public 
}
