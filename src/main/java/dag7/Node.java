package dag7;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String name;
	private int weight;
	private List<String> childs = new ArrayList<String>();
	
	public Node() {
	}

	public Node(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<String> getChilds() {
		return childs;
	}

	public void setChilds(List<String> childs) {
		this.childs = childs;
	}	
}