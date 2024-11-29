package adventofcode.year2022;

import adventofcode.year2022.day5.Day5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay5 {

    @Test
    void part1() {
        Day5 day = new Day5();
        String result = day.part1("adventofcode/year2022/testinput5.txt");
        assertEquals("CMZ", result);
        result = day.part1("adventofcode/year2022/input5.txt");
        assertEquals("FJSRQCFTN", result);
    }

    @Test
    void part2() {
        Day5 day = new Day5();
        String result = day.part2("adventofcode/year2022/testinput5.txt");
        assertEquals("MCD", result);
        assertEquals("CJVLJQPHS", day.part2("adventofcode/year2022/input5.txt"));
    }
}