package Elevator;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements ElevatorFactory {
	// 每个elevator都应该有当前的level
	private Integer currentFloor;
	// 和接下来所有要去的destination level
	private Queue<Integer> destinationFloors;

	public Elevator(Integer currentFloor) {
		this.currentFloor= currentFloor;
		this.destinationFloors= new LinkedList<Integer>();
	}

	// 看一眼下一个destination是哪里
	public int nextDestionation() {
		return this.destinationFloors.peek();
	}

	// 返回当前的位置
	public int currentFloor() {
		return this.currentFloor;
	}

	// 到达目的地之后 除去destination
	public void popDestination() {
		this.destinationFloors.remove();
	}

	// 有人新按按键加入新的目的地
	@Override
	public void addNewDestinatoin(Integer destination) {
		this.destinationFloors.add(destination);
	}

	@Override
	public void moveUp() {
		currentFloor++ ;
	}

	@Override
	public void moveDown() {
		currentFloor-- ;
	}

	// 这个就是现在现在elevator要朝着什么方向去了
	// 就是比较cur level和destination
	@Override
	public ElevatorDirection direction() {
		if (destinationFloors.size() > 0) {
			if (currentFloor < destinationFloors.peek()) {
				return ElevatorDirection.ELEVATOR_UP;
			} else if (currentFloor > destinationFloors.peek()) { return ElevatorDirection.ELEVATOR_DOWN; }
		}
		return ElevatorDirection.ELEVATOR_HOLD;
	}

	// 就是看看电梯忙不忙 destination中有没有任务
	@Override
	public ElevatorStatus status() {
		return (destinationFloors.size() > 0) ? ElevatorStatus.ELEVATOR_OCCUPIED : ElevatorStatus.ELEVATOR_EMPTY;
	}
}
