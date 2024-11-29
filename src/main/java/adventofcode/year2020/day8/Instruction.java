package adventofcode.year2020.day8;

public class Instruction {
	String action;
	int value;

	public Instruction(String action, int value) {
		this.action = action;
		this.value = value;
	}


	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Instruction{" +
				"action='" + action + '\'' +
				", value=" + value +
				'}';
	}
}
