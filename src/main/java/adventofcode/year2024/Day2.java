package adventofcode.year2024;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        List<List<Integer>> reports = new ArrayList<>();
        for (String line : lines) {
            List<Integer> report = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
            reports.add(report);
        }

        int countOfValidReports = 0;
        for (List<Integer> report : reports) {

            if (isReportSafe(report)) {
                countOfValidReports++;
            }
        }

        return countOfValidReports;
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        List<List<Integer>> reports = new ArrayList<>();

        for (String line : lines) {
            List<Integer> report = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
            reports.add(report);
        }

        int countOfValidReports = 0;
        for (List<Integer> report : reports) {

            if (isReportSafe(report)) {
                countOfValidReports++;
                continue;
            }
            for (int i = 0; i < report.size(); i++) {
                List<Integer> trimmedReport = new ArrayList<>(report);
                trimmedReport.remove(i);

                if (isReportSafe(trimmedReport)) {
                    countOfValidReports++;
                    break;
                }
            }

        }
        return countOfValidReports;
    }

    public boolean isReportSafe(List<Integer> report) {
        if (isIncreasing(report)) {
            for (int i = 0; i < report.size() - 1; i++) {
                if (currentEqualOrLargerThanNext(report.get(i), report.get(i + 1)) || diffLargerThan3(report.get(i), report.get(i + 1))) {
                    return false;
                }
            }

        } else {
            for (int i = 0; i < report.size() - 1; i++) {
                if (currentEqualOrLessThanNext(report.get(i), report.get(i + 1)) || diffLargerThan3(report.get(i), report.get(i + 1))) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean currentEqualOrLargerThanNext(int current, int next) {
        return current >= next;
    }

    private boolean currentEqualOrLessThanNext(int current, int next) {
        return current <= next;
    }

    private boolean diffLargerThan3(int current, int next) {
        return Math.abs(current - next) > 3;
    }

    private boolean isIncreasing(List<Integer> report) {
        int countIncreased = 0;

        for (int i = 0; i < report.size() - 1; i++) {
            if (report.get(i + 1) > report.get(i)) {
                countIncreased++;
            }
        }
        return countIncreased > report.size() / 2;
    }
}
