package adventofcode.year2022.day7;

import adventofcode.utils.FileHandler;

import java.util.*;
import java.util.stream.Collectors;

public class Day7 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        Node currentDirectory;

        List<Node> directories = new ArrayList<>();
        Node node = new Node("/");
        currentDirectory = node;
        directories.add(node);
        for (String line : lines) {

            if (line.contains("cd /") || line.equals("$ ls")) {
                continue;
            }

            if (line.contains("cd ..")) {
                currentDirectory = findNode(directories, currentDirectory.parent.name);
            } else if (line.startsWith("$ cd ") && !line.contains("..")) {
                node = new Node(currentDirectory.name + "/" + line.substring(5));
                currentDirectory.addChild(node);
                currentDirectory = node;
                directories.add(node);
            } else if (Character.isDigit(line.charAt(0))) {

                String[] fileProperties = line.split(" ");
                Node fileNode = new Node(fileProperties[1]);
                fileNode.size = Integer.parseInt(fileProperties[0]);
                currentDirectory.addChild(fileNode);

            }
        }

        Map<Node, Integer> directorySizes = new HashMap<>();

        for (Node n : directories) {
            directorySizes.put(n, findSizeOfDirectory(n));
        }

        return directorySizes.entrySet()
                .stream()
                .filter(e -> e.getValue() <= 100000)
                .mapToInt(Map.Entry::getValue)
                .reduce(0, Integer::sum);
    }


    private int findSizeOfDirectory(Node directory) {
        int sum = 0;
        for (Node node : directory.children) {
            if (!node.children.isEmpty()) {
                sum += findSizeOfDirectory(node);
            } else {
                sum += node.size;
            }
        }
        return sum;
    }

    private Node findNode(List<Node> nodes, String nodeName) {
        return nodes.stream().filter(node -> node.name.equals(nodeName)).findFirst().orElse(null);
    }

    private class Node {
        public String name;
        public int size;
        public List<Node> children;
        public Node parent;

        public Node(String name) {
            children = new ArrayList<>();
            this.name = name;
        }

        public Node addChild(Node node) {
            children.add(node);
            node.parent = this;
            return this;
        }
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        Node currentDirectory;

        List<Node> directories = new ArrayList<>();
        Node node = new Node("/");
        currentDirectory = node;
        directories.add(node);
        for (String line : lines) {

            if (line.contains("cd /") || line.equals("$ ls")) {
                continue;
            }

            if (line.contains("cd ..")) {
                currentDirectory = findNode(directories, currentDirectory.parent.name);
            } else if (line.startsWith("$ cd ") && !line.contains("..")) {
                node = new Node(currentDirectory.name + "/" + line.substring(5));
                currentDirectory.addChild(node);
                currentDirectory = node;
                directories.add(node);
            } else if (Character.isDigit(line.charAt(0))) {

                String[] fileProperties = line.split(" ");
                Node fileNode = new Node(fileProperties[1]);
                fileNode.size = Integer.parseInt(fileProperties[0]);
                currentDirectory.addChild(fileNode);

            }
        }

        Map<Node, Integer> directorySizes = new HashMap<>();

        for (Node n : directories) {
            directorySizes.put(n, findSizeOfDirectory(n));
        }

        final int REQUIRED_SPACE = 30000000;

        final int TOTAL_SPACE = 70000000;


        int freeSpace = TOTAL_SPACE - directorySizes.get(directories.stream().filter(n -> n.name.equals("/")).findFirst().orElseThrow());

        int dataNeededToBeDeleted = REQUIRED_SPACE - freeSpace;

        List<Integer> directoriesLargeEnough = directorySizes.values().stream().filter(size -> size > dataNeededToBeDeleted).collect(Collectors.toList());

        Collections.sort(directoriesLargeEnough);
        return directoriesLargeEnough.get(0);
    }


}
