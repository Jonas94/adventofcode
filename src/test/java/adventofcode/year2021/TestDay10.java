package adventofcode.year2021;

import adventofcode.year2021.day10.Day10;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay10 {

    @Test
    public void part1() {
        Day10 day = new Day10();
        long result = day.part1("adventofcode/year2021/testinput10.txt");
        assertEquals(26397, result);
        System.out.println(day.part1("adventofcode/year2021/input10.txt"));
    }

    @Test
    public void part2() {
        Day10 day = new Day10();
        long result = day.part2("adventofcode/year2021/testinput10.txt");
        assertEquals(288957, result);
        System.out.println(day.part2("adventofcode/year2021/input10.txt"));
    }
}