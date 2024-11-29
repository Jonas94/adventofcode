package adventofcode.year2022;

import adventofcode.year2022.day2.Day2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay2 {

    @Test
    void testPart1() {
        Day2 day = new Day2();
        int result = day.part1("adventofcode/year2022/testinput2.txt");

        assertEquals(15, result);


        result = day.part1("adventofcode/year2022/input2.txt");
        assertEquals(11873, result);

    }

    @Test
    void testPart2() {
        Day2 day = new Day2();
        int result = day.part2("adventofcode/year2022/testinput2.txt");

        assertEquals(12, result);

        result = day.part2("adventofcode/year2022/input2.txt");

        assertEquals(12014, result);
    }
}