package thelast;

public interface IPackage {
	
	public void process();

	public void setName(String name);

	public void setAssignedWorker(IEmployeeWorker assignedWorker);

	public String getName();

	public IEmployeeWorker getAssignedWorker();

}
