package adventofcode.year2022;

import adventofcode.year2022.day12.Day12;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay12 {

    @Test
    void part1() {
        Day12 day = new Day12();
        assertEquals(31, day.part1("adventofcode/year2022/testinput12.txt"));
        assertEquals(361, day.part1("adventofcode/year2022/input12.txt"));
    }

    @Test
    void part2() {
        Day12 day = new Day12();
   //     assertEquals(29, day.part2("testinput12.txt"));
        assertEquals(354, day.part2("adventofcode/year2022/input12.txt"));
    }
}