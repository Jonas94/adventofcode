package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day8Test {

    @Test
    void part1() {
        Day8 day = new Day8();
        assertEquals(14, day.part1("adventofcode/year2024/testinput8.txt"));
        assertEquals(320, day.part1("adventofcode/year2024/input8.txt"));
    }

    @Test
    void part2() {
        Day8 day = new Day8();

        assertEquals(34, day.part2("adventofcode/year2024/testinput8.txt"));
        assertEquals(1157, day.part2("adventofcode/year2024/input8.txt"));

    }
}