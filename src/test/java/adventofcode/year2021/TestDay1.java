package adventofcode.year2021;

import adventofcode.year2021.day1.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay1 {

	@Test
	public void testSolveDay1Part1() {
		Day1 day1 = new Day1();
		int result = day1.solveDay1("adventofcode/year2021/testinput1.txt");

		assertEquals(7, result);

		System.out.println(day1.solveDay1("adventofcode/year2021/input1.txt"));
	}

	@Test
	public void testSolveDay1Part2() {
		Day1 day1 = new Day1();
		int result = day1.solveDay2("adventofcode/year2021/testinput1.txt");

		assertEquals(5, result);

		System.out.println(day1.solveDay2("adventofcode/year2021/input1.txt"));

	}
}