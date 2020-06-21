package thelast;

public abstract class EmployeeWorker implements IEmployeeWorker{
	
	// Observer
		private String name;
		private IEmployeeDriver assignedDriver;

		// Chain of Responsibility
		public static int CITY = 1;
		public static int COUNTRY = 2;
		public static int INTERNATIONAL = 3;

		protected int level;
		protected EmployeeWorker nextWorker;

		// State
		public Context emplpyeeStateContext = new Context();

		public Package currentPackage;

		public EmployeeWorker(String name) {
			this.name = name;

			this.emplpyeeStateContext.setState(new IdleState());
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getLevel() {
			return this.level;
		}

		public IState getState() {
			return this.emplpyeeStateContext.getState();
		}

		public void applyState(IState state, boolean notifyDriver) {
			this.emplpyeeStateContext.setState(state);

			System.out.println(this.getName() + " is currently in " + state.getStateName());

			if (this.emplpyeeStateContext.getState().getClass().equals(WorkingEState.class)) {
				System.out.println(
						this.getName() + " is currently preparing package [" + this.currentPackage.getName() + "]");
			}

			if (notifyDriver) {
				this.assignedDriver.notifyDriver();
			}
		}

		public void setNextWorker(IEmployeeWorker nextWorker) {
			this.nextWorker = (EmployeeWorker) nextWorker;
		}

		public boolean sendPackage(int level, IPackage package1) {
			if (level < 1 || level > 3) {
				System.out.println("Level of package must be between 1 - 3");
				return false;
			}

			if (this.level <= level) {
				this.writeMessage();
			}

			if (this.nextWorker != null) {
				this.nextWorker.sendPackage(level, package1);
			}

			if (this.level == level) {
				package1.setAssignedWorker(this);
			}

			return true;
		}

		@Override
		public void update() {
			if (assignedDriver == null) {
				System.out.println("No driver assigned, preparation cancelled");
				return;
			}

			if (currentPackage == null) {
				System.out.println("Emplpyee [" + getName() + "] has no package, preparation cancelled");
				return;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Assigned driver " + "[" + this.assignedDriver.getUpdate() + "]" + " has taken package "
					+ "[" + currentPackage.getName() + "]" + " from worker " + "[" + this.getName() + "]");

			cleanUpPackageResponsibility();
		}

		@Override
		public void setDriver(IEmployeeDriver driver) {
			this.assignedDriver = driver;
		}

		@Override
		public void preparePackage(Package package1) {
			this.currentPackage = package1;
			this.applyState(new WorkingEState(), this.assignedDriver.isAutomaticNotify());
		}

		private void cleanUpPackageResponsibility() {
			this.applyState(new IdleState(), this.assignedDriver.isAutomaticNotify());

			this.currentPackage = null;
		}

		abstract protected void writeMessage();

}
