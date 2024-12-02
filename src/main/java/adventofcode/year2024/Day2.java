package adventofcode.year2024;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

            if (isReportSafe(report, false)) {
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

            if (isReportSafe(report, true)) {
                countOfValidReports++;
            }
        }
        return countOfValidReports;
    }

    public boolean isReportSafe(List<Integer> report, boolean problemDampener) {
        int countOfProblems = 0;
        if (!problemDampener && Objects.equals(report.get(0), report.get(1))) {
            return false;
        } else if (report.get(0).compareTo(report.get(1)) > 0) {
            for (int i = 0; i < report.size() - 1; i++) {
                if (report.get(i) <= report.get(i + 1) || Math.abs(report.get(i) - report.get(i + 1)) > 3) {
                    if (problemDampener && countOfProblems == 0) {
                        countOfProblems++;
                        if (i == 0) {
                            continue;
                        }

                        if (countOfProblems == 1 && i == report.size() - 2) {
                            continue;
                        }
                        if (report.get(i - 1) <= report.get(i + 1) || Math.abs(report.get(i - 1) - report.get(i + 1)) > 3) {
                            return false;

                        } else {
                            continue;
                        }

                    }
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i < report.size() - 1; i++) {
                if (report.get(i) >= report.get(i + 1) || Math.abs(report.get(i) - report.get(i + 1)) > 3) {
                    if (problemDampener && countOfProblems == 0) {
                        if (i == 0) {
                            countOfProblems++;
                            continue;
                        }
                        countOfProblems++;
                        if (countOfProblems == 1 && i == report.size() - 2) {
                            continue;
                        }
                        if (report.get(i - 1) <= report.get(i + 1) && Math.abs(report.get(i - 1) - report.get(i + 1)) <= 3) {
                            continue;

                        } else {
                            return false;
                        }
                    }
                    return false;
                }

            }
            return true;
        }

    }
}
