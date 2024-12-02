package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void part1() {
        Day2 day = new Day2();

        long result = day.part1("adventofcode/year2024/testinput2.txt");
        assertEquals(2, result);
        long result1 = day.part1("adventofcode/year2024/input2.txt");
        assertEquals(479, result1);
    }

    @Test
    void part2() {
        Day2 day = new Day2();

        long result = day.part2("adventofcode/year2024/testinput2.txt");
        assertEquals(4, result);
        long result1 = day.part2("adventofcode/year2024/input2.txt");
        assertEquals(479, result1);
        //505 too low
        //516 too low

    }


    @Test
    void reportSafeWithoutDampener() {
        Day2 day = new Day2();

        List<List<Integer>> reports = new ArrayList<>();

        reports.add(List.of(7, 6, 4, 2, 1));
        reports.add(List.of(1, 2, 7, 8, 9));
        reports.add(List.of(9, 7, 6, 2, 1));
        reports.add(List.of(1, 3, 2, 4, 5));
        reports.add(List.of(8, 6, 4, 4, 1));
        reports.add(List.of(1, 3, 6, 7, 9));

        assertTrue(day.isReportSafe(reports.get(0), false));
        assertFalse(day.isReportSafe(reports.get(1), false));
        assertFalse(day.isReportSafe(reports.get(2), false));
        assertFalse(day.isReportSafe(reports.get(3), false));
        assertFalse(day.isReportSafe(reports.get(4), false));
        assertTrue(day.isReportSafe(reports.get(5), false));

        /**
         * 7 6 4 2 1: Safe because the levels are all decreasing by 1 or 2.
         * 1 2 7 8 9: Unsafe because 2 7 is an increase of 5.
         * 9 7 6 2 1: Unsafe because 6 2 is a decrease of 4.
         * 1 3 2 4 5: Unsafe because 1 3 is increasing but 3 2 is decreasing.
         * 8 6 4 4 1: Unsafe because 4 4 is neither an increase or a decrease.
         * 1 3 6 7 9: Safe because the levels are all increasing by 1, 2, or 3.
         */


    }

    @Test
    void reportSafeWithDampener() {
        Day2 day = new Day2();

        List<List<Integer>> reports = new ArrayList<>();

        reports.add(List.of(7, 6, 4, 2, 1));
        reports.add(List.of(1, 2, 7, 8, 9));
        reports.add(List.of(9, 7, 6, 2, 1));
        reports.add(List.of(1, 3, 2, 4, 5));
        reports.add(List.of(8, 6, 4, 4, 1));
        reports.add(List.of(1, 3, 6, 7, 9));

     /*   assertTrue(day.isReportSafe(reports.get(0), true));
        assertFalse(day.isReportSafe(reports.get(1), true));
        assertFalse(day.isReportSafe(reports.get(2), true));
        assertTrue(day.isReportSafe(reports.get(3), true));
        assertTrue(day.isReportSafe(reports.get(4), true));
        assertTrue(day.isReportSafe(reports.get(5), true));
*/
        reports.add(List.of(1, 3, 6, 6, 9));

  //      assertTrue(day.isReportSafe(reports.get(6), true));


        reports.add(List.of(51, 50, 47, 45, 42, 41, 34));

        assertTrue(day.isReportSafe(reports.get(7), true));



        reports.add(List.of(1, 50, 47, 45, 42, 41));

        assertTrue(day.isReportSafe(reports.get(8), true));

        /**
         * 7 6 4 2 1: Safe without removing any level.
         * 1 2 7 8 9: Unsafe regardless of which level is removed.
         * 9 7 6 2 1: Unsafe regardless of which level is removed.
         * 1 3 2 4 5: Safe by removing the second level, 3.
         * 8 6 4 4 1: Safe by removing the third level, 4.
         * 1 3 6 7 9: Safe without removing any level.
         */
    }
}