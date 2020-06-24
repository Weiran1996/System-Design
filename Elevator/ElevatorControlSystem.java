package Elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ElevatorControlSystem implements ElevatorControlSystemFactory {

	// 每个system 大楼中 需要知道有多少个elevator 多要层楼
	public static final int MAX_ELEVATORS= 16;
	Integer numberOfElevators= 0;
	Integer numberOfFloors= 0;

	// 就是说现在有一堆elevator来服务一个大楼
	ArrayList<Elevator> elevators;
	// 有人需要坐电梯 会有request
	Queue<Integer> pickupLocations;

	public ElevatorControlSystem(Integer numberOfElevators, Integer numberOfFloors) throws InvalidNumber {
		if (numberOfElevators < 0) throw new InvalidNumber("Elevator number must be positive");
		this.numberOfElevators= (numberOfElevators > MAX_ELEVATORS) ? MAX_ELEVATORS : numberOfElevators;
		this.numberOfFloors= numberOfFloors;
		initializeElevators();
		pickupLocations= new LinkedList<Integer>();
	}

	// 需要多少个电梯 就初始化多少个电梯 放到管理的list中去
	private void initializeElevators() {
		elevators= new ArrayList<Elevator>();
		for (int idx= 0; idx < this.numberOfElevators; idx++ ) {
			elevators.add(new Elevator(1));
		}
	}

	// 返回当前所有工作中的elevator
	public ArrayList<Elevator> getElevators() {
		return elevators;
	}

	// 有人按下电梯 有pickup的request
	@Override
	public void pickUp(Integer pickUpFloor) {
		pickupLocations.add(pickUpFloor);
	}

	// 把一个要去几层的任务交给一个指定的elevator
	@Override
	public void destination(Integer elevatorId, Integer destinationFloor) {
		elevators.get(elevatorId).addNewDestinatoin(destinationFloor);
	}

	@Override
	public void step() {
		// Loop though every elevator
		for (Elevator currElevator : elevators) {
			// Check to figure out which ones are unoccupied and update call
			switch (currElevator.status()) {
			// 如果一个elevator没有活 pickup还有request 你就过去把 解决
			case ELEVATOR_EMPTY:
				if (!pickupLocations.isEmpty())
					currElevator.addNewDestinatoin(pickupLocations.poll());
				break;
			// Move occupied Elevators one step closer to next closest destination in direction
			// 如果当前elevator是正在被使用的 就要对他操作了
			case ELEVATOR_OCCUPIED:
				switch (currElevator.direction()) {
				case ELEVATOR_UP:
					currElevator.moveUp();
					break;
				case ELEVATOR_DOWN:
					currElevator.moveDown();
					break;
				case ELEVATOR_HOLD:
					// TODO: Check timer here to alert users that they are holding the door open to long
					// TODO: Emergency situation where elevator can't be used
					// TODO: Maintenance Mode e.g. movers or maintenance people
					currElevator.popDestination();
					break;
				}
				if (currElevator.direction() == ElevatorDirection.ELEVATOR_UP)
					break;
			}
		}
	}
}
