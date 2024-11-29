package adventofcode.year2021;

import adventofcode.year2021.day4.Day4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay4 {

	@Test
	public void part1() {
		Day4 day4 = new Day4();
		long result = day4.part1("adventofcode/year2021/testinput4.txt");

		assertEquals(4512, result);

		System.out.println(day4.part1("adventofcode/year2021/input4.txt"));
	}

	@Test
	public void part2() {
		Day4 day4 = new Day4();
		long result = day4.part2("adventofcode/year2021/testinput4.txt");

		assertEquals(1924, result);

		System.out.println(day4.part2("adventofcode/year2021/input4.txt"));

	}
}