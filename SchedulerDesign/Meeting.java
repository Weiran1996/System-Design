package SchedulerDesign;

import java.util.Date;

public class Meeting {
	// 一个meeting其实不需要什么特殊的
	// 只需要有开始 结束 房间 和id就好了
	// meeting的房间会在后续安排
	int id;
	Room room= null;
	Date start= null;
	Date end= null;

	Meeting(Date start, Date end, Room room, int id) {
		this.id= id;
		this.start= start;
		this.end= end;
		this.room= room;
	}
}
