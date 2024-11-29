package adventofcode.year2022;

import adventofcode.year2022.day4.Day4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay4 {

    @Test
    void part1() {
        Day4 day = new Day4();
        long result = day.part1("adventofcode/year2022/testinput4.txt");
        assertEquals(2, result);
        result = day.part1("adventofcode/year2022/input4.txt");
        assertEquals(464, result);
    }

    @Test
    void part2() {
        Day4 day = new Day4();
        long result = day.part2("adventofcode/year2022/testinput4.txt");
        assertEquals(4, result);
        result = day.part2("adventofcode/year2022/input4.txt");
        assertEquals(770, result);
    }
}