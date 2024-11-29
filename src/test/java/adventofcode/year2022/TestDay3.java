package adventofcode.year2022;

import adventofcode.year2022.day3.Day3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay3 {

    @Test
    void part1() {
        Day3 day = new Day3();
        long result = day.part1("adventofcode/year2022/testinput3.txt");
        assertEquals(157, result);
        result = day.part1("adventofcode/year2022/input3.txt");
        assertEquals(7878, result);
    }

    @Test
    void part2() {
        Day3 day = new Day3();
        long result = day.part2("adventofcode/year2022/testinput3.txt");
        assertEquals(70, result);
        result = day.part2("adventofcode/year2022/input3.txt");
        assertEquals(2760, result);
    }
}