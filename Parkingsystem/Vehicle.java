package Parkingsystem;
import java.util.ArrayList;

//就是甭管什么类型的车 都会有的一些东西
//目的是 为了具体的车来extend这个class
public abstract class Vehicle {
	// 这个车占用了那些具体的spot 放到List中去
	protected ArrayList<ParkingSpot> parkingSpots= new ArrayList<>();
	protected String licensePlate;
	// 一个车需要占用spot的个数
	// motor car bus是那种类型的车 用enum来表示的
	// 而且这两个东西 每个subclass都是不一样的 所以 要在各自class中去intitialize
	protected int spotsNeeded;
	protected VehicleSize size;

	// 就是getter 直接得到需要的spot个数
	public int getSpotsNeeded() {
		return spotsNeeded;
	}

	// 另一个getter 直接获得车的size
	public VehicleSize getSize() {
		return size;
	}

	// 这是一个一个 把需要的spot加进来的
	public void parkInSpot(ParkingSpot s) {
		parkingSpots.add(s);
	}

	public void clearSpots() {
		for (int i= 0; i < parkingSpots.size(); i++ ) {
			parkingSpots.get(i).removeVehicle();
		}
		parkingSpots.clear();
	}

	// 是不是big enough 这是只用来比较spot的size的 并不用来比较个数
	// 而且这是个abstract method现在不用implement 在subclass中去implement
	public abstract boolean canFitInSpot(ParkingSpot spot);
}
