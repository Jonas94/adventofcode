package adventofcode.year2022;

import adventofcode.year2022.day9.Day9;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay9 {

    @Test
    void part1() {
        Day9 day = new Day9();
        assertEquals(13, day.part1("adventofcode/year2022/testinput9.txt"));
        assertEquals(6339, day.part1("adventofcode/year2022/input9.txt"));
    }

    @Test
    void part2() {
        Day9 day = new Day9();
        assertEquals(0, day.part2("adventofcode/year2022/testinput9.txt"));
        assertEquals(0, day.part2("adventofcode/year2022/input9.txt"));
    }
}