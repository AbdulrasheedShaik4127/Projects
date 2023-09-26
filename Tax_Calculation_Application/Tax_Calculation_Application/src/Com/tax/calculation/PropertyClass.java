package Com.tax.calculation;

public class PropertyClass {
	double value;
	int built_up_area;
	int age_of_land;
	String located;
	double tax;
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public PropertyClass(double value, int built_up_area, int age_of_land, String located) {
		super();
		this.value = value;
		this.built_up_area = built_up_area;
		this.age_of_land = age_of_land;
		this.located = located;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getBuilt_up_area() {
		return built_up_area;
	}
	public void setBuilt_up_area(int built_up_area) {
		this.built_up_area = built_up_area;
	}
	public int getAge_of_land() {
		return age_of_land;
	}
	public void setAge_of_land(int age_of_land) {
		this.age_of_land = age_of_land;
	}
	public String getLocated() {
		return located;
	}
	public void setLocated(String located) {
		this.located = located;
	}
	public PropertyClass() {
		super();
	}
}
