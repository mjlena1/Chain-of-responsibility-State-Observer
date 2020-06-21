package thelast;

public abstract class EmployeeState implements IState {

	protected String stateName;

	@Override
	public void applyState(Context context) {
		context.setState(this);
	}

	@Override
	public String getStateName() {
		return this.stateName;
}
}
