package adventofcode.year2022;

import adventofcode.year2022.day1.Day1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay1 {

    @Test
    void testPart1() {
        Day1 day1 = new Day1();
        int result = day1.part1("adventofcode/year2022/testinput1.txt");

        assertEquals(24000, result);

        System.out.println(day1.part1("adventofcode/year2022/input1.txt"));

        result = day1.part1("adventofcode/year2022/input1.txt");
        assertEquals(66186, result);

    }

    @Test
    void testPart2() {
        Day1 day1 = new Day1();
        int result = day1.part2("adventofcode/year2022/testinput1.txt");

        assertEquals(45000, result);

        result = day1.part2("adventofcode/year2022/input1.txt");
        System.out.println(day1.part2("adventofcode/year2022/input1.txt"));

        assertEquals(196804, result);
    }
}