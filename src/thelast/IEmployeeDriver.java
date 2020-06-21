package thelast;

public interface IEmployeeDriver {
	
	public String getName();

	public void setName(String name);

	public boolean isAutomaticNotify();

	public void setAutomaticNotify(boolean automaticNotify);

	public void subscribe(IEmployeeWorker observer);

	public void unsubscribe(IEmployeeWorker observer);

	public void notifyDriver();

	public String getUpdate();

}
