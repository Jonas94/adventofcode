package adventofcode.year2021;

import adventofcode.year2021.day9.Day9;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay9 {

    @Test
    public void part1() {
        Day9 day = new Day9();
        long result = day.part1("adventofcode/year2021/testinput9.txt");
        assertEquals(15, result);
        System.out.println(day.part1("adventofcode/year2021/input9.txt"));
    }

    @Test
    public void part2() {
        Day9 day = new Day9();
        long result = day.part2("adventofcode/year2021/testinput9.txt");
        assertEquals(1134, result);
        System.out.println(day.part2("adventofcode/year2021/input9.txt"));
    }
}