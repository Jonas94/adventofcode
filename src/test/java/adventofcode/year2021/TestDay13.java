package adventofcode.year2021;

import adventofcode.year2021.day13.Day13;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay13 {

    @Test
    public void part1() {
        Day13 day = new Day13();
        long result = day.part1("adventofcode/year2021/testinput13.txt");
        assertEquals(17, result);
        System.out.println(day.part1("adventofcode/year2021/input13.txt"));
    }

    @Test
    public void part2() {
        Day13 day = new Day13();
        String expectedResult = "..##.###..####..##..#..#..##..#..#.###.\n" +
                "...#.#..#....#.#..#.#..#.#..#.#..#.#..#\n" +
                "...#.#..#...#..#....#..#.#..#.#..#.#..#\n" +
                "...#.###...#...#....#..#.####.#..#.###.\n" +
                "#..#.#....#....#..#.#..#.#..#.#..#.#.#.\n" +
                ".##..#....####..##...##..#..#..##..#..#";

        assertEquals(expectedResult, day.part2("adventofcode/year2021/input13.txt"));

    }
}