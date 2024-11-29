package adventofcode.year2020.day7;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day7 {

	static int numberOfGoldRelatives = 0;
	List<Bag> allBags;

	public int solvePart1(List<String> input) {

		allBags = new ArrayList<>();

		for(String s : input){
			s = s.replace(".", "");
			s = s.replace("bags", "bag");
			s = s.replaceAll(" \\d", "");

			String[] formattedInput = s.split("(contain)");
			String[] containsString = formattedInput[1].split(",");

			List<String> containBags = new ArrayList<>();

			for(String containedBag : containsString){
				containBags.add(containedBag.trim());
			}

			Bag bag = new Bag(formattedInput[0].trim(), containBags);
			allBags.add(bag);
		}

		Graph graph = new Graph();
		for(Bag bag : allBags) {
			graph.addVertex(bag.getName());
		}
		for(Bag bag : allBags) {

			for(String child : bag.getContainBags()) {
				if(!child.equalsIgnoreCase("No other bag")) {
					graph.addEdge(bag.getName(), child);
				}
			}
		}
		int size = 0;

		for(Bag bag : allBags) {
			size += depthFirstTraversal(graph, bag.getName()).size();

		}

		System.out.println("Containing gold bag: " + size);

		return size;
	}

		static Set<String> depthFirstTraversal(Graph graph, String root) {
			Set<String> visited = new LinkedHashSet<String>();
			Set<String> goldRelatives = new HashSet<>();
			Stack<String> stack = new Stack<String>();

			stack.push(root);
			while (!stack.isEmpty()) {
				String vertex = stack.pop();
				boolean found= false;
				if (!visited.contains(vertex)) {
					visited.add(vertex);
					for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
						stack.push(v.label);
						if(v.label.equalsIgnoreCase("shiny gold bag")){
							System.out.println(root + "   " + vertex);
							//numberOfGoldRelatives++;
							goldRelatives.add(v.label);
							found = true;
							break;
						}
					}

				}
				if(found){
					break;
				}
			}
			return goldRelatives;
		}

	int depthFirstTraversalPart2(Graph graph, String root) {
		Set<String> visited = new LinkedHashSet<>();
		Stack<String> stack = new Stack<>();

		stack.push(root);

		while (!stack.isEmpty()) {
			String vertex = stack.pop();
			if (!visited.contains(vertex)) {
				visited.add(vertex);


				for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
					stack.push(v.label);
						System.out.println(vertex + "   " + v.label);
						Bag bag = findBagByName(v.label);
						Bag parentBag = findBagByName(vertex);
						for(String child : bag.getContainBags()) {
							Pattern p = Pattern.compile("\\d+");
							Matcher m = p.matcher(child);
							if(m.find()) {
								int numberOfBags = Integer.parseInt(m.group());
								int multiplicator = 1;
								System.out.println(numberOfBags);
								for(String sibling : parentBag.getContainBags()){
									if(sibling.contains(v.label)){
										Pattern pattern = Pattern.compile("\\d+");
										Matcher matcher = p.matcher(sibling);
										if(matcher.find()){
											multiplicator = Integer.parseInt(matcher.group());



										}
									}
								}
								if(multiplicator>1){
									numberOfGoldRelatives += multiplicator;
								}
								int increaseBy = numberOfBags * multiplicator;
								numberOfGoldRelatives += increaseBy;
								System.out.println("Added: " + increaseBy );
								System.out.println("Value: " + numberOfGoldRelatives );

							}
							else
							{
								System.out.println("No bags!");
							}
						}
				}
			}
		}
		numberOfGoldRelatives--;
		return 0;
	}

	private Bag findBagByName(String name){
		for(Bag bag : allBags){
			if(bag.getName().equals(name)){
				return bag;
			}
		}
		return null;
	}


		static Set<String> breadthFirstTraversal(Graph graph, String root) {
			Set<String> visited = new LinkedHashSet<String>();
			Queue<String> queue = new LinkedList<String>();
			queue.add(root);
			visited.add(root);
			while (!queue.isEmpty()) {
				String vertex = queue.poll();
				for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
					if (!visited.contains(v.label)) {
						visited.add(v.label);
						queue.add(v.label);
						if (v.label.equalsIgnoreCase("shiny gold bag")) {
							numberOfGoldRelatives++;

						}
					}
				}
			}
			return visited;

		}


	public int solvePart2(List<String> input) {
		allBags = new ArrayList<>();

		for(String s : input){
			s = s.replace(".", "");
			s = s.replace("bags", "bag");

			String[] formattedInput = s.split("(contain)");
			String[] containsString = formattedInput[1].split(",");

			List<String> containBags = new ArrayList<>();

			for(String containedBag : containsString){
				containBags.add(containedBag.trim());

			}

			Bag bag = new Bag(formattedInput[0].trim(), containBags);
			allBags.add(bag);
		}

		Graph graph = new Graph();
		for(Bag bag : allBags) {
			graph.addVertex(bag.getName());
		}
		for(Bag bag : allBags) {

			for(String child : bag.getContainBags()) {
				String[] childInfo = child.split("\\d");
				if (childInfo.length > 1) {
					String childName = childInfo[1].trim();
					if (!childName.equalsIgnoreCase("No other bag")) {
						graph.addEdge(bag.getName(), childName);
					}
				}
			}
		}

		depthFirstTraversalPart2(graph, "shiny gold bag");


		return numberOfGoldRelatives;
		}
}