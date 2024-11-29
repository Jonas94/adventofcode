package adventofcode.year2022;

import adventofcode.year2022.day6.Day6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay6 {

    @Test
    void part1() {
        Day6 day = new Day6();
        long result = day.part1("adventofcode/year2022/testinput6.txt");
        assertEquals(5, result);
        assertEquals(1566, day.part1("adventofcode/year2022/input6.txt"));
    }

    @Test
    void part2() {
        Day6 day = new Day6();
        long result = day.part2("adventofcode/year2022/testinput6.2.txt");
        assertEquals(19, result);
        assertEquals(2265, day.part2("adventofcode/year2022/input6.txt"));
    }
}