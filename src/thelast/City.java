package thelast;

public class City extends EmployeeWorker {
	
	public City(String name) {
		super(name);

		this.level = EmployeeWorker.CITY;
	}

	@Override
	protected void writeMessage() {
		System.out.println("Package has gone through city/ employee [" + this.getName() + "]");
	}

}
