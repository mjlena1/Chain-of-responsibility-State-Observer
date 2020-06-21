package thelast;

public class Main {
	
	public static void main(String[] args) {
		
		OneByOne();

	}

	private static void OneByOne() {
		EmployeeDriver driver = new EmployeeDriver ("Kiro");
		IEmployeeWorker worker = (City) getChain(driver);

		IPackage package1 = new Package("Everything is ok, nothing suspicious", worker, 3);
		IPackage package2 = new Package("shipment number and other info", worker, 2);

		package1.process();
		package2.process();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void StateFirst() {
		EmployeeDriver driver = new EmployeeDriver("Todor");
		driver.setAutomaticNotify(false);

		IEmployeeWorker worker = (City) getChain(driver);

		IPackage package1 = new Package("Everything is ok, nothing suspicious", worker, 3);
		IPackage package2 = new Package("shipment number and other info", worker, 2);

		package1.process();
		package2.process();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.notifyDriver();
	}

	private static IEmployeeWorker getChain(EmployeeDriver driver) {

		IEmployeeWorker cityWorker = new City("Ivan");
		IEmployeeWorker countryWorker = new Country("Dimitar");
		IEmployeeWorker internationalWorker = new International("Emil");

		driver.subscribe(cityWorker);
		driver.subscribe(countryWorker);
		driver.subscribe(internationalWorker);

		cityWorker.setNextWorker(countryWorker);
		countryWorker.setNextWorker(internationalWorker);

		return cityWorker;
	}

}
