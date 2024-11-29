package adventofcode.year2021;

import adventofcode.year2021.day7.Day7;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDay7 {

    @Test
    public void part1() {
        Day7 day = new Day7();
        long result = day.part1("adventofcode/year2021/testinput7.txt");
        assertEquals(37, result);

        System.out.println(day.part1("adventofcode/year2021/input7.txt"));
    }

    @Test
    public void part2() {
        Day7 day = new Day7();
        long result = day.part2("adventofcode/year2021/testinput7.txt");
        assertEquals(168, result);

        System.out.println(day.part2("adventofcode/year2021/input7.txt"));
    }
}