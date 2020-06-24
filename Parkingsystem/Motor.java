package Parkingsystem;

public class Motor extends Vehicle {
	public Motor() {
		spotsNeeded= 1;
		size= VehicleSize.Motorcycle;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return true;
	}
}
