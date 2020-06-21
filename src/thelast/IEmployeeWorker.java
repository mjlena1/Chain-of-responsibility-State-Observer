package thelast;

public interface IEmployeeWorker {
	// State
		public IState getState();

		public void applyState(IState state, boolean notifyDriver);

		// Observer
		public void update();

		public void setDriver(IEmployeeDriver topic);

		public void preparePackage(Package package1);

		// Chain of Responsibility
		public void setNextWorker(IEmployeeWorker nextWorker);

		public boolean sendPackage(int level, IPackage package1);

		public int getLevel();

}
