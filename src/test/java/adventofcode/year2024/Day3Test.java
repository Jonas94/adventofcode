package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    @Test
    void part1() {
        Day3 day = new Day3();
        assertEquals(161, day.part1("adventofcode/year2024/testinput3.txt"));
        assertEquals(188741603, day.part1("adventofcode/year2024/input3.txt"));
    }

    @Test
    void part2() {
        Day3 day = new Day3();
        assertEquals(48, day.part2("adventofcode/year2024/testinput3.1.txt"));
        assertEquals(67269798, day.part2("adventofcode/year2024/input3.txt"));
    }

}