package adventofcode.year2024;

import adventofcode.utils.FileHandler;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Day5 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        int emptyLineIndex = findIndexOfEmptyLine(lines);

        List<String> pageOrderingRules = findPageOrderingRules(emptyLineIndex, lines);
        List<String> updates = findUpdates(emptyLineIndex, lines);
        Map<String, List<String>> restrictions = mapRestrictions(pageOrderingRules);


        List<String> middleNumbers = new ArrayList<>();

        for (String update : updates) {
            boolean failed = false;
            List<String> updatedNumbers = new ArrayList<>();

            String[] updateNumbers = update.split(",");

            List<String> temporaryNumbersRun = new ArrayList<>();
            for (String number : updateNumbers) {
                if (isAlrightToExecute(number, restrictions, updatedNumbers, Arrays.stream(updateNumbers).toList(), temporaryNumbersRun)) {
                    updatedNumbers.add(number);

                    temporaryNumbersRun.add(number);
                } else {
                    failed = true;
                    break;
                }
            }
            if (!failed) {
                middleNumbers.add(findMiddleNumber(updateNumbers));
            }
        }

        return middleNumbers.stream().mapToInt(Integer::parseInt).sum();
    }

    private String findMiddleNumber(String[] numbers) {
        return numbers[numbers.length / 2];

    }

    private String findMiddleNumber(List<String> numbers) {
        return numbers.get(numbers.size() / 2);

    }

    private boolean isAlrightToExecute(String update, Map<String, List<String>> restrictions, List<String> updatedNumbers, List<String> updateInFull, List<String> temporaryNumbersRun) {
        if (!restrictions.containsKey(update)) {
            return true;
        }
        List<String> requiredUpdates = restrictions.get(update).stream().filter(updateInFull::contains).filter(number -> !temporaryNumbersRun.contains(number)).toList();

        return updatedNumbers.containsAll(requiredUpdates);
    }

    private Map<String, List<String>> mapRestrictions(List<String> pageOrderingRules) {
        Map<String, List<String>> rulesMap = new HashMap<>();

        for (String rule : pageOrderingRules) {

            String[] rulePair = rule.split("\\|");

            String left = rulePair[0];
            String right = rulePair[1];

            if (rulesMap.containsKey(right)) {
                rulesMap.get(right).add(left);
            } else {
                List<String> list = new ArrayList<>();
                list.add(left);
                rulesMap.put(right, list);
            }
        }


        return rulesMap;

    }

    private int findIndexOfEmptyLine(List<String> lines) {

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    private boolean passesCheck(List<String> update, Map<String, List<String>> restrictions) {
        boolean failed = false;
        List<String> updatedNumbers = new ArrayList<>();


        List<String> temporaryNumbersRun = new ArrayList<>();
        for (String number : update) {
            if (isAlrightToExecute(number, restrictions, updatedNumbers, update, temporaryNumbersRun)) {
                updatedNumbers.add(number);
            } else {
                failed = true;
                break;
            }
        }
        return !failed;
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        int emptyLineIndex = findIndexOfEmptyLine(lines);


        List<String> pageOrderingRules = findPageOrderingRules(emptyLineIndex, lines);
        List<String> updates = findUpdates(emptyLineIndex, lines);
        Map<String, List<String>> restrictions = mapRestrictions(pageOrderingRules);


        List<String> middleNumbers = new ArrayList<>();

        List<String> failedUpdates = new ArrayList<>();
        for (String update : updates) {
            boolean failed = false;
            List<String> updatedNumbers = new ArrayList<>();

            String[] updateNumbers = update.split(",");

            List<String> temporaryNumbersRun = new ArrayList<>();


            for (String number : updateNumbers) {
                if (isAlrightToExecute(number, restrictions, updatedNumbers, Arrays.stream(updateNumbers).toList(), temporaryNumbersRun)) {
                    updatedNumbers.add(number);

                    temporaryNumbersRun.add(number);
                } else {
                    failed = true;
                    break;
                }
            }

            if (failed) {
                failedUpdates.add(update);
            }
        }


        System.out.println("SIZE OF FAILED: " + failedUpdates.size());

        List<List<String>> fixedUpdates = new ArrayList<>();
        for (String update : failedUpdates) {

            fixedUpdates.add(sortFailedUpdate(update, restrictions));
        }

        int counterFailed = 0;
        for (List<String> update : fixedUpdates) {
            boolean passes = passesCheck(update, restrictions);
            if (!passes) {

                System.out.println("FAILED TO PASS: " + update);
                counterFailed++;
            } else {
                middleNumbers.add(findMiddleNumber(update));
            }
        }
        System.out.println("SIZE OF FAILED: " + counterFailed);

        return middleNumbers.stream().mapToInt(Integer::parseInt).sum();
    }

    public List<String> sortFailedUpdate(String update, Map<String, List<String>> pageOrderingRules) {

        List<String> updateNumbers = Arrays.stream(update.split(",")).collect(Collectors.toList());

        Map<String, List<String>> filteredRestrictions = new HashMap<>(pageOrderingRules);
        filteredRestrictions.keySet().retainAll(updateNumbers);

        for (Map.Entry<String, List<String>> entry : filteredRestrictions.entrySet()) {
            entry.setValue(entry.getValue().stream().filter(updateNumbers::contains).toList());
        }

        Comparator<String> customComparator = (s1, s2) -> {
            if (s1.equals(s2)) {
                //Should never happen in this case
                return 0;
            }

            if (pageOrderingRules.containsKey(s1)) {
                if (pageOrderingRules.get(s1).contains(s2)) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return -1;
        };

        updateNumbers.sort(customComparator);


        return updateNumbers;
    }


    private List<String> findUpdates(int emptyLineIndex, List<String> lines) {
        List<String> updates = new ArrayList<>();
        for (int i = emptyLineIndex + 1; i < lines.size(); i++) {
            updates.add(lines.get(i));
        }
        return updates;
    }

    private List<String> findPageOrderingRules(int emptyLineIndex, List<String> lines) {
        List<String> pageOrderingRules = new ArrayList<>();
        for (int i = 0; i < emptyLineIndex; i++) {
            pageOrderingRules.add(lines.get(i));
        }

        return pageOrderingRules;
    }


}
