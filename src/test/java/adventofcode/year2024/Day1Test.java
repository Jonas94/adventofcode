package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    @Test
    void part1() {
        Day1 day = new Day1();

        long result = day.part1("adventofcode/year2024/testinput1.txt");

        assertEquals(11, result);

        long result1 = day.part1("adventofcode/year2024/input1.txt");

        assertEquals(2344935, result1);
    }

    @Test
    void part2() {
        Day1 day = new Day1();
        long result = day.part2("adventofcode/year2024/testinput1.txt");
        assertEquals(31, result);
        long result1 = day.part2("adventofcode/year2024/input1.txt");
        assertEquals(27647262, result1);
    }
}