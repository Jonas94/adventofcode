package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Test {

    @Test
    void part1() {
        Day12 day = new Day12();
        assertEquals(1930, day.part1("adventofcode/year2024/testinput12.txt"));
        assertEquals(1377008, day.part1("adventofcode/year2024/input12.txt"));
    }

    @Test
    void part2() {
        Day12 day = new Day12();
        assertEquals(223767210249237L, day.part2("adventofcode/year2024/input12.txt"));

    }
}