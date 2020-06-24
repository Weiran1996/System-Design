package SchedulerDesign;

import java.util.Date;

public class Calendar {
	Meeting meet;
	Room room;
	Date start;
	Date end;

	public Calendar(Meeting meet, Room room, Date start, Date end) {
		this.meet= meet;
		this.room= room;
		this.start= start;
		this.end= end;
	}

}
