package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {

    @Test
    void part1() {
        Day10 day = new Day10();
        assertEquals(36, day.part1("adventofcode/year2024/testinput10.txt"));
        assertEquals(510, day.part1("adventofcode/year2024/input10.txt"));
    }

    @Test
    void part2() {
        Day10 day = new Day10();

        assertEquals(81, day.part2("adventofcode/year2024/testinput10.txt"));
        assertEquals(1058, day.part2("adventofcode/year2024/input10.txt"));

    }
}