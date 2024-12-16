package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

    @Test
    void part1() {
        Day5 day = new Day5();

        assertEquals(143, day.part1("adventofcode/year2024/testinput5.txt"));
        assertEquals(5391, day.part1("adventofcode/year2024/input5.txt"));
    }

    @Test
    void part2() {
        Day5 day = new Day5();

        assertEquals(123, day.part2("adventofcode/year2024/testinput5.txt"));
        assertEquals(6142, day.part2("adventofcode/year2024/input5.txt"));
    }
}