package thelast;

public class Country extends EmployeeWorker{
	
	public Country(String name) {
		super(name);

		this.level = EmployeeWorker.COUNTRY;
	}

	@Override
	protected void writeMessage() {
		System.out.println("Package has gone through country/ employee [" + this.getName() + "]");
	}

}
