package adventofcode.year2022;

import adventofcode.year2022.day7.Day7;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay7 {

    @Test
    void part1() {
        Day7 day = new Day7();
        long result = day.part1("adventofcode/year2022/testinput7.txt");
        assertEquals(95437, result);
        assertEquals(1307902, day.part1("adventofcode/year2022/input7.txt"));
    }

    @Test
    void part2() {
        Day7 day = new Day7();
        long result = day.part2("adventofcode/year2022/testinput7.txt");
        assertEquals(24933642, result);
        assertEquals(7068748, day.part2("adventofcode/year2022/input7.txt"));
    }
}