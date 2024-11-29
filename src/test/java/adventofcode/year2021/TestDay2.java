package adventofcode.year2021;

import adventofcode.year2021.day2.Day2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDay2 {

	@Test
	public void testSolveDay2Part1() {
		Day2 day2 = new Day2();
		int result = day2.solveDay2Part1("adventofcode/year2021/testinput2.txt");

		assertEquals(150, result);

		System.out.println(day2.solveDay2Part1("adventofcode/year2021/input2.txt"));
	}

	@Test
	public void testSolveDay2Part2() {
		Day2 day2 = new Day2();
		int result = day2.solveDay2Part2("adventofcode/year2021/testinput2.txt");

		assertEquals(900, result);

		System.out.println(day2.solveDay2Part2("adventofcode/year2021/input2.txt"));

	}
}