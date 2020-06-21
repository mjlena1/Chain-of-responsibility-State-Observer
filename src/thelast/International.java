package thelast;

public class International extends EmployeeWorker {
	
	public International(String name) {
		super(name);

		this.level = EmployeeWorker.INTERNATIONAL;
	}

	@Override
	protected void writeMessage() {
		System.out.println("Package has gone through international/ employee [" + this.getName() + "]");
	}

}
