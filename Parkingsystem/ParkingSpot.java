package Parkingsystem;

public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int spotid;

	// Constructor 来声明class中的field怎么初始化
	// 这时候 Vehicle就不能初始化 因为他不是与生俱来 spot的东西
	// 只有与生俱来的 才能放到constructor里边
	public ParkingSpot(int id, VehicleSize size) {
		spotid= id;
		spotSize= size;
	}

	// 看看这个坑 现在能不能停车
	public boolean isAvailable() {
		return vehicle == null;
	}

	// 看看新来了一个车 能不能放到坑里边
	public boolean canFitVehicle(Vehicle vehicle) {
		return isAvailable() && vehicle.canFitInSpot(this);
	}

	public boolean park(Vehicle v) {
		if (!canFitVehicle(v)) { return false; }
		vehicle= v;
		vehicle.parkInSpot(this);
		return true;
	}

	public void removeVehicle() {
		vehicle= null;
	}

	public int getSpotId() {
		return spotid;
	}

	public VehicleSize getSize() {
		return spotSize;
	}
}
