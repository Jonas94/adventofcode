package adventofcode.year2021;

import adventofcode.year2021.day3.Day3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay3 {

	@Test
	public void part1() {
		Day3 day3 = new Day3();
		long result = day3.solveDay3Part1("adventofcode/year2021/testinput3.txt");

		assertEquals(198, result);

		System.out.println(day3.solveDay3Part1("adventofcode/year2021/input3.txt"));
	}

	@Test
	public void part2() {
		Day3 day3 = new Day3();
		int result = day3.solveDay3Part2("adventofcode/year2021/testinput3.txt");

		assertEquals(230, result);

		System.out.println(day3.solveDay3Part2("adventofcode/year2021/input3.txt"));

	}
}