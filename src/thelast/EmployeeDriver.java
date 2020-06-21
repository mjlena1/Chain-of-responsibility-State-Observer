package thelast;

import java.util.ArrayList;


public class EmployeeDriver implements IEmployeeDriver {
	
	private ArrayList<IEmployeeWorker> workers = new ArrayList<IEmployeeWorker>();
	private boolean automaticNotify = true;
	private String name;

	public EmployeeDriver(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAutomaticNotify() {
		return automaticNotify;
	}

	public void setAutomaticNotify(boolean automaticNotify) {
		this.automaticNotify = automaticNotify;
	}

	@Override
	public void subscribe(IEmployeeWorker observer) {
		this.workers.add(observer);
		observer.setDriver(this);
	}

	@Override
	public void unsubscribe(IEmployeeWorker observer) {
		this.workers.remove(observer);
	}

	
	@Override
	public void notifyDriver() {
		for (IEmployeeWorker worker : this.workers) {
			if (worker.getState().getClass().equals(WorkingEState.class)) {
				worker.update();
			}
		}
	}

	@Override
	public String getUpdate() {
		return this.name;
	}

}
