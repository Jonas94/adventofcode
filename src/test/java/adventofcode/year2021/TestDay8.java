package adventofcode.year2021;

import adventofcode.year2021.day8.Day8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestDay8 {

    @Test
    public void part1() {
        Day8 day = new Day8();
        long result = day.part1("adventofcode/year2021/testinput8.txt");
        assertEquals(26, result);

        System.out.println(day.part1("adventofcode/year2021/input8.txt"));
    }

    @Test
    public void part2() {
        Day8 day = new Day8();
        long result = day.part2("adventofcode/year2021/testinput8.txt");
        assertEquals(61229, result);

        System.out.println(day.part2("adventofcode/year2021/input8.txt"));
    }
}