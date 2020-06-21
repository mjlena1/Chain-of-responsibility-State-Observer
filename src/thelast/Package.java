package thelast;

public class Package implements IPackage {
	
	private String name;
	private IEmployeeWorker assignedWorker;
	private int level;

	public Package(String name, IEmployeeWorker worker, int level) {
		this.name = name;
		this.assignedWorker = worker;
		this.level = level;
	}

	public void process() {
		if (this.assignedWorker.sendPackage(level, this)) {
			this.assignedWorker.preparePackage(this);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IEmployeeWorker getAssignedWorker() {
		return assignedWorker;
	}

	public void setAssignedWorker(IEmployeeWorker assignedWorker) {
		this.assignedWorker = assignedWorker;
	}

}
