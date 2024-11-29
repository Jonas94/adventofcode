package adventofcode.year2021;

import adventofcode.year2021.day11.Day11;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay11 {

    @Test
    public void part1() {
        Day11 day = new Day11();
        long result = day.part1("adventofcode/year2021/testinput11.txt");
        assertEquals(1656, result);
        System.out.println(day.part1("adventofcode/year2021/input11.txt"));
    }

    @Test
    public void part2() {
        Day11 day = new Day11();
        long result = day.part2("adventofcode/year2021/testinput11.txt");
        assertEquals(195, result);
        System.out.println(day.part2("adventofcode/year2021/input11.txt"));
    }
}