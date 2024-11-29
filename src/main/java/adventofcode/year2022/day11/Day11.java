package adventofcode.year2022.day11;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day11 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        List<Monkey> monkeys = new ArrayList<>();
        for (int i = 0; i < lines.size(); i += 7) {


            String[] monkeyName = lines.get(i).split("[ :]");
            String[] itemStrings = lines.get(i + 1).split("[Starting items : ,]");
            String[] operationStrings = lines.get(i + 2).split("(Operation.* = old )")[1].split(" ");
            List<Item> items = Arrays.stream(itemStrings).filter(item -> !item.isEmpty()).map(item -> new Item(Integer.parseInt(item))).collect(Collectors.toList());


            Monkey monkey = new Monkey(Integer.parseInt(monkeyName[1]));
            monkey.getItems().addAll(items);

            if (operationStrings[0].equals("*")) {
                if (operationStrings[1].equals("old")) {
                    monkey.setFunction(integer -> integer * integer);

                } else {
                    monkey.setFunction(integer -> integer * Integer.parseInt(operationStrings[1]));
                }
            } else if (operationStrings[0].equals("+")) {
                if (operationStrings[1].equals("old")) {
                    monkey.setFunction(integer -> integer * integer);

                } else {
                    monkey.setFunction(integer -> integer + Integer.parseInt(operationStrings[1]));
                }
            }

            int dividedByRequirement = Integer.parseInt(lines.get(i + 3).split("(.*by )")[1]);

            monkey.setDividerByFunction(integer -> integer % dividedByRequirement == 0);

            int monkeyIfTrue = Integer.parseInt(lines.get(i + 4).split("(.*monkey )")[1]);
            int monkeyIfFail = Integer.parseInt(lines.get(i + 5).split("(.*monkey )")[1]);
            monkey.setThrowToMonkeyIdIfTrue(monkeyIfTrue);
            monkey.setThrowToMonkeyIdIfFail(monkeyIfFail);
            monkeys.add(monkey);
        }


        for (int i = 0; i < 20; i++) {
            for (Monkey monkey : monkeys) {

                List<Item> removedItems = new ArrayList<>();

                for (Item item : monkey.getItems()) {

                    monkey.increaseNumberOfInspections();
                    item.setWorryLevel(monkey.getFunction().apply(item.getWorryLevel()));
                    item.setWorryLevel(item.getWorryLevel() / 3);

                    if (monkey.getDividerByFunction().test(item.getWorryLevel())) {
                        monkeys.get(monkey.getThrowToMonkeyIdIfTrue()).getItems().add(item);
                    } else {
                        monkeys.get(monkey.getThrowToMonkeyIdIfFail()).getItems().add(item);
                    }
                    removedItems.add(item);

                }
                monkey.getItems().removeAll(removedItems);


            }
            for (Monkey monkey : monkeys) {

                System.out.print(monkey.getId() + " " + monkey.getNumberOfInspectedItems());
                //    monkey.getItems().stream().forEach(item -> System.out.print(item.getWorryLevel() + ", "));
                System.out.println();

            }
            System.out.println();

        }


        return monkeys.stream().sorted((Comparator.comparing(Monkey::getNumberOfInspectedItems)).reversed()).limit(2)
                .map(Monkey::getNumberOfInspectedItems).reduce(1, (a, b) -> a * b);
        
    }


    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        List<Monkey> monkeys = new ArrayList<>();
        for (int i = 0; i < lines.size(); i += 7) {


            String[] monkeyName = lines.get(i).split("[ :]");
            String[] itemStrings = lines.get(i + 1).split("[Starting items : ,]");
            String[] operationStrings = lines.get(i + 2).split("(Operation.* = old )")[1].split(" ");
            List<Item> items = Arrays.stream(itemStrings).filter(item -> !item.isEmpty()).map(item -> new Item(Integer.parseInt(item))).collect(Collectors.toList());


            Monkey monkey = new Monkey(Integer.parseInt(monkeyName[1]));
            monkey.getItems().addAll(items);

            if (operationStrings[0].equals("*")) {
                if (operationStrings[1].equals("old")) {
                    monkey.setFunction(integer -> integer * integer);

                } else {
                    monkey.setFunction(integer -> integer * Integer.parseInt(operationStrings[1]));
                }
            } else if (operationStrings[0].equals("+")) {
                if (operationStrings[1].equals("old")) {
                    monkey.setFunction(integer -> integer * integer);

                } else {
                    monkey.setFunction(integer -> integer + Integer.parseInt(operationStrings[1]));
                }
            }

            int dividedByRequirement = Integer.parseInt(lines.get(i + 3).split("(.*by )")[1]);

            monkey.setDividerByFunction(integer -> integer % dividedByRequirement == 0);

            int monkeyIfTrue = Integer.parseInt(lines.get(i + 4).split("(.*monkey )")[1]);
            int monkeyIfFail = Integer.parseInt(lines.get(i + 5).split("(.*monkey )")[1]);
            monkey.setThrowToMonkeyIdIfTrue(monkeyIfTrue);
            monkey.setThrowToMonkeyIdIfFail(monkeyIfFail);
            monkeys.add(monkey);
        }


        for (int i = 0; i < 2000; i++) {
            for (Monkey monkey : monkeys) {

                List<Item> removedItems = new ArrayList<>();

                for (Item item : monkey.getItems()) {

                    monkey.increaseNumberOfInspections();
                    item.setWorryLevel(monkey.getFunction().apply(item.getWorryLevel()));

                    if (monkey.getDividerByFunction().test(item.getWorryLevel())) {
                        monkeys.get(monkey.getThrowToMonkeyIdIfTrue()).getItems().add(item);
                    } else {
                        monkeys.get(monkey.getThrowToMonkeyIdIfFail()).getItems().add(item);
                    }
                    removedItems.add(item);

                }
                monkey.getItems().removeAll(removedItems);


            }
            for (Monkey monkey : monkeys) {

                System.out.print(monkey.getId() + " " + monkey.getNumberOfInspectedItems());
                //    monkey.getItems().stream().forEach(item -> System.out.print(item.getWorryLevel() + ", "));
                System.out.println();

            }
            System.out.println();

        }


        return monkeys.stream().sorted((Comparator.comparing(Monkey::getNumberOfInspectedItems)).reversed()).limit(2)
                .map(Monkey::getNumberOfInspectedItems).reduce(1, (a, b) -> a * b);

    }

}
