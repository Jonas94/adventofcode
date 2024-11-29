package adventofcode.year2022;

import adventofcode.year2022.day14.Day14;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay14 {

    @Test
    void part1() {
        Day14 day = new Day14();
        assertEquals(24, day.part1("adventofcode/year2022/testinput14.txt"));
        assertEquals(1003, day.part1("adventofcode/year2022/input14.txt"));
    }

    @Test
    void part2() {
        Day14 day = new Day14();
        assertEquals(93, day.part2("adventofcode/year2022/testinput14.txt"));
        assertEquals(25771, day.part2("adventofcode/year2022/input14.txt"));
    }
}