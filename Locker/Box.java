package Locker;

public class Box {
	Size size;
	Locker lock;
	BoxStatus boxstatus;
	int id;

	public Box(Size size, int id) {
		this.size= size;
		this.id= id;
		this.boxstatus= BoxStatus.Shipping;
	}

}
