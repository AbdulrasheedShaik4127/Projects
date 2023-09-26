package Com.tax.calculation;

public class VehicleClass {
	int registration_number;
	String brand;
	int max_velocity;
	int no_of_seats;
	String type_of_vehicle;
	double purchase_cost;
	double vehicle_tax;
	public int getRegistration_number() {
		return registration_number;
	}
	public void setRegistration_number(int registration_number) {
		this.registration_number = registration_number;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getMax_velocity() {
		return max_velocity;
	}
	public void setMax_velocity(int max_velocity) {
		this.max_velocity = max_velocity;
	}
	public int getNo_of_seats() {
		return no_of_seats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}
	public String getType_of_vehicle() {
		return type_of_vehicle;
	}
	public void setType_of_vehicle(String type_of_vehicle) {
		this.type_of_vehicle = type_of_vehicle;
	}
	public double getPurchase_cost() {
		return purchase_cost;
	}
	public void setPurchase_cost(double purchase_cost) {
		this.purchase_cost = purchase_cost;
	}
	public double getVehicle_tax() {
		return vehicle_tax;
	}
	public void setVehicle_tax(double vehicle_tax) {
		this.vehicle_tax = vehicle_tax;
	}
	public VehicleClass(int registration_number, String brand, int max_velocity, int no_of_seats,
			String type_of_vehicle, double purchase_cost, double vehicle_tax) {
		super();
		this.registration_number = registration_number;
		this.brand = brand;
		this.max_velocity = max_velocity;
		this.no_of_seats = no_of_seats;
		this.type_of_vehicle = type_of_vehicle;
		this.purchase_cost = purchase_cost;
		this.vehicle_tax = vehicle_tax;
	}
	public VehicleClass() {
		super();
	}
	

}
