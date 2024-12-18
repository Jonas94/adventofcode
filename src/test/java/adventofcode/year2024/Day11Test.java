package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {

    @Test
    void part1() {
        Day11 day = new Day11();
        assertEquals(55312, day.part1("adventofcode/year2024/testinput11.txt"));
        assertEquals(187738, day.part1("adventofcode/year2024/input11.txt"));
    }

    @Test
    void part2() {
        Day11 day = new Day11();
        assertEquals(223767210249237L, day.part2("adventofcode/year2024/input11.txt"));

    }
}