package adventofcode.year2021;

import adventofcode.year2021.day12.Day12;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay12 {

    @Test
    public void part1() {
        Day12 day = new Day12();
        long result = day.part1("adventofcode/year2021/testinput12.txt");
        assertEquals(10, result);
          System.out.println(day.part1("adventofcode/year2021/input12.txt"));
    }

    @Test
    public void part2() {
        Day12 day = new Day12();
        long result = day.part2("adventofcode/year2021/testinput12.txt");
        assertEquals(36, result);
        System.out.println(day.part2("adventofcode/year2021/input12.txt"));
    }
}