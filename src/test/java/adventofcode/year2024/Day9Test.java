package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day9Test {

    @Test
    void part1() {
        Day9 day = new Day9();
        assertEquals(1928, day.part1("adventofcode/year2024/testinput9.txt"));
        assertEquals(6340197768906L, day.part1("adventofcode/year2024/input9.txt"));
    }

    @Test
    void part2() {
        Day9 day = new Day9();

        assertEquals(34, day.part2("adventofcode/year2024/testinput9.txt"));
        assertEquals(1157, day.part2("adventofcode/year2024/input9.txt"));

    }
}