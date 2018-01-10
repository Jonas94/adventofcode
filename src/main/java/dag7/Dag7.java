package dag7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import filereader.FileHandler;

public class Dag7 {
	//Denna dag är ej klar ännu.
	public static List<String> nodesWithChilds = new ArrayList<String>();
	public static List<String> nodesWithoutChilds = new ArrayList<String>();
	public static List<Node> allNodes = new ArrayList<Node>();
	public static HashMap<String, Node> map = new HashMap();
	static int totalWeight = 0;
	public static void main(String[] args) {
		FileHandler fh = new FileHandler();
		List<String> lines = fh.readFile("dag7.txt");

		for(String line : lines){
			if(line != null){
			Node n = createNode(line);
			map.put(n.getName(), n);
		}}

		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			Node n = (Node) mentry.getValue();
			//		System.out.println(n.getName());
		}
		System.out.println(map.size());
		System.out.println(map.get("ejekn"));

		Node n = map.get("eqgvf");
		calculateWeight(n);
	}

	private static int calculateWeight(Node n){
		List<String> childNodes = new ArrayList<String>();
		int nodeWeight = n.getWeight();
		childNodes = n.getChilds();
		totalWeight += nodeWeight;
		System.out.println("NODVIKT: " + nodeWeight);
		System.out.println("TOTALVIKT: " + totalWeight);
		for(String s : childNodes){
			calculateWeight(map.get(s));
		}

		return totalWeight;
	}

	private static boolean gotChilds(String s){
		if(s.contains("->")){
			nodesWithChilds.add(s);
			return true;
		}
		nodesWithoutChilds.add(s);
		return false;
	}

	private static List<String> parseChilds(String s){
		List<String> childs = new ArrayList<String>();

		String childString = s.substring(s.lastIndexOf(">")+2);
		StringTokenizer st = new StringTokenizer(childString, ", ");
		while (st.hasMoreElements()) {
			String child = (String) st.nextElement();
			childs.add(child);

		}
		return childs;
	}

	private static boolean isChild(String s){
		for(String node: nodesWithChilds){
			int nodeSubstringStart = node.lastIndexOf(">");
			String nodeSubstring = node.substring(nodeSubstringStart, node.length());
			if(nodeSubstring.contains(s)){
				return true;
			}
		}
		return false;
	}

	private static Node createNode(String line){
		Node n = new Node();
		n.setName(getNameOfNode(line));
		n.setWeight(getWeightOfNode(line));
		if(gotChilds(line)){
			n.setChilds(parseChilds(line));
		}	
		return n;

	}

	private static void setChilds(){
	}

	private static String getNameOfNode(String s){

		int nodeSubstringStart = 0;
		int nodeSubstringStop = s.indexOf(" ");
		String name = s.substring(nodeSubstringStart, nodeSubstringStop);
		return name;
	}

	private static int getWeightOfNode(String s){

		int nodeSubstringStart = s.lastIndexOf("(");
		int nodeSubstringStop = s.lastIndexOf(")");
		String nodeSubstring = s.substring(nodeSubstringStart+1, nodeSubstringStop);
		int weight = Integer.parseInt(nodeSubstring);
		return weight;
	}
}