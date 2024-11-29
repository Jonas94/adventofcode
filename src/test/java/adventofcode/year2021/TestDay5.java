package adventofcode.year2021;

import adventofcode.year2021.day5.Day5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay5 {

    @Test
    public void part1() {
        Day5 day = new Day5();
        long result = day.part1("adventofcode/year2021/testinput5.txt");

        assertEquals(5, result);

        System.out.println(day.part1("adventofcode/year2021/input5.txt"));
    }

    @Test
    public void part2() {
        Day5 day = new Day5();
        long result = day.part2("adventofcode/year2021/testinput5.txt");

        	assertEquals(12, result);

        System.out.println(day.part2("adventofcode/year2021/input5.txt"));

    }
}