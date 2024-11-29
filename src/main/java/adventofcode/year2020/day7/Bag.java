package adventofcode.year2020.day7;

import java.util.List;

public class Bag {
	String name;
	List<String> containBags;

	public Bag(String name, List<String> containBags) {
		this.name = name;
		this.containBags = containBags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getContainBags() {
		return containBags;
	}

	public void setContainBags(List<String> containBags) {
		this.containBags = containBags;
	}

	@Override
	public String toString() {
		return "Bag{" +
				"name='" + name + '\'' +
				", containBags=" + containBags +
				'}';
	}
}
