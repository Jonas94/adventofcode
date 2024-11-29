package adventofcode.year2020;


import adventofcode.utils.FileHandler;
import adventofcode.year2020.day1.Day1;
import adventofcode.year2020.day10.Day10;
import adventofcode.year2020.day11.Day11;
import adventofcode.year2020.day2.Day2;

import adventofcode.year2020.day22.Day22;
import adventofcode.year2020.day3.Day3;
import adventofcode.year2020.day4.Day4;
import adventofcode.year2020.day5.Day5;
import adventofcode.year2020.day6.Day6;
import adventofcode.year2020.day7.Day7;
import adventofcode.year2020.day8.Day8;
import adventofcode.year2020.day9.Day9;

import adventofcode.year2020.day12.Day12;
import adventofcode.year2020.day13.Day13;
import adventofcode.year2020.day14.Day14;
import adventofcode.year2020.day15.Day15;
import adventofcode.year2020.day16.Day16;
import adventofcode.year2020.day17.Day17;
import adventofcode.year2020.day18.Day18;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolutions {

	@Test
	public void testSolveDay1() {
		Day1 day1 = new Day1();
		day1.solveDay1();
	}

	@Test
	public void testSolveDay2Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input2.txt").getFile());

		List<String> testInput = new ArrayList<>();
		testInput.add("1-3 a: abcde");
		testInput.add("1-3 b: cdefg");
		testInput.add("2-9 c: ccccccccc");

		Day2 day2 = new Day2();
		assertEquals(2, day2.solvePart1(testInput));

		System.out.println(day2.solvePart1(input));

	}

	@Test
	public void testSolveDay2Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input2.txt").getFile());

		/*

			1-3 a: abcde is valid: position 1 contains a and position 3 does not.
			1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
			2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
		 */
		List<String> testInput = new ArrayList<>();
		testInput.add("1-3 a: abcde");
		testInput.add("1-3 b: cdefg");
		testInput.add("2-9 c: ccccccccc");

		Day2 day2 = new Day2();
		assertEquals(1, day2.solvePart2(testInput));

		System.out.println(day2.solvePart2(input));

	}

	@Test
	public void testSolveDay3Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input3.txt").getFile());
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput3.txt").getFile());

		Day3 day3 = new Day3();
		assertEquals(7, day3.solvePart1(testInput));

		System.out.println(day3.solvePart1(input));

	}

	@Test
	public void testSolveDay3Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input3.txt").getFile());
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput3.txt").getFile());

		Day3 day3 = new Day3();
		assertEquals(new BigInteger("336"), day3.solvePart2(testInput));

		System.out.println(day3.solvePart2(input));
	}

	@Test
	public void testSolveDay4Part1() {
		FileHandler fileHandler = new FileHandler();
		String input = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("adventofcode/year2020/input4.txt").getFile());
		String testInput = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("adventofcode/year2020/testinput4.txt").getFile());

		Day4 day4 = new Day4();
		assertEquals(2, day4.solvePart1(testInput));

		System.out.println(day4.solvePart1(input));
	}


	@Test
	public void testSolveDay4Part2() {
		FileHandler fileHandler = new FileHandler();
		String input = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("adventofcode/year2020/input4.txt").getFile());
		String testInput = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("adventofcode/year2020/testinput4.txt").getFile());

		Day4 day4 = new Day4();
		//		assertEquals(2, day4.solvePart2(testInput));

		System.out.println(day4.solvePart2(input));
	}

	@Test
	public void testSolveDay4Part2FailingPassports() {
		FileHandler fileHandler = new FileHandler();
		//String input = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("input4.txt").getFile());
		String testInput = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("testinput4AllFailing.txt").getFile());

		Day4 day4 = new Day4();
		assertEquals(0, day4.solvePart2(testInput));

	}


	@Test
	public void testSolveDay4Part2ValidPassports() {
		FileHandler fileHandler = new FileHandler();
		//String input = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("input4.txt").getFile());
		String testInput = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("adventofcode/year2020/testinput4AllValid.txt").getFile());

		Day4 day4 = new Day4();
		assertEquals(4, day4.solvePart2(testInput));

	}

	@Test
	public void testSolveDay5Part1() {
		/*
		BFFFBBFRRR: row 70, column 7, seat ID 567.
	FFFBBBFRRR: row 14, column 7, seat ID 119.
	BBFFBBFRLL: row 102, column 4, seat ID 820.	*/


		FileHandler fileHandler = new FileHandler();
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input5.txt").getFile());


		List<String> testInput = new ArrayList<>();
		testInput.add("BFFFBBFRRR");

		Day5 day5 = new Day5();
		assertEquals(567, day5.solvePart1(testInput));

		System.out.println(day5.solvePart1(input));

	}

	@Test
	public void testSolveDay5Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input5.txt").getFile());

		Day5 day5 = new Day5();

		System.out.println(day5.solvePart2(input));
	}

	@Test
	public void testSolveDay6Part1() {
		FileHandler fileHandler = new FileHandler();
		String testInput = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("adventofcode/year2020/testinput6.txt").getFile());
		String input = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("adventofcode/year2020/input6.txt").getFile());


		Day6 day6 = new Day6();
		assertEquals(11, day6.solvePart1(testInput));
		System.out.println(day6.solvePart1(input));
	}

	@Test
	public void testSolveDay6Part2() {
		FileHandler fileHandler = new FileHandler();
		String testInput = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("adventofcode/year2020/testinput6.txt").getFile());
		String input = fileHandler.readFileIntoString(getClass().getClassLoader().getResource("adventofcode/year2020/input6.txt").getFile());


		Day6 day6 = new Day6();
		assertEquals(6, day6.solvePart2(testInput));
		assertEquals(3122, day6.solvePart2(input));

		System.out.println(day6.solvePart2(input));
	}


	@Test
	public void testSolveDay7Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput7.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input7.txt").getFile());


		Day7 day7 = new Day7();
		assertEquals(4, day7.solvePart1(testInput));
		assertEquals(348, day7.solvePart1(input));

	}


	@Test
	public void testSolveDay7Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput7part2extra.txt").getFile());
		//List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("input7.txt").getFile());


		Day7 day7 = new Day7();
		assertEquals(126, day7.solvePart2(testInput));

	}


	@Test
	public void testSolveDay8Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput8.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input8.txt").getFile());

		Day8 day8 = new Day8();
		assertEquals(5, day8.solvePart1(testInput));
		assertEquals(1262, day8.solvePart1(input));
	}

	@Test
	public void testSolveDay8Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput8.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input8.txt").getFile());


		Day8 day8 = new Day8();
		assertEquals(8, day8.solvePart2(testInput));
		assertEquals(1643, day8.solvePart2(input));
	}

	@Test
	public void testSolveDay9Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput9.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input9.txt").getFile());

		Day9 day9 = new Day9();
		assertEquals(127, day9.solvePart1(testInput, 5));
		assertEquals(0, day9.solvePart1(input, 25));
	}


	@Test
	public void testSolveDay9Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput9.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input9.txt").getFile());

		Day9 day9 = new Day9();
		assertEquals(62, day9.solvePart2(testInput, 127));
		assertEquals(137394018, day9.solvePart2(input, 1038347917));
	}

	@Test
	public void testSolveDay10Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput10.txt").getFile());
		List<String> testInput2 = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput10part1secondtest.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input10.txt").getFile());

		Day10 day10 = new Day10();
		assertEquals(35, day10.solvePart1(testInput));
		assertEquals(220, day10.solvePart1(testInput2));

		assertEquals(0, day10.solvePart1(input));
	}


	@Test
	public void testSolveDay10Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput10.txt").getFile());
		List<String> testInput2 = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput10part1secondtest.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input10.txt").getFile());

		Day10 day10 = new Day10();
//		assertEquals(8, day10.solvePart2(testInput));

		assertEquals(8, day10.solvePart2(testInput));



		//assertEquals(220, day10.solvePart1(testInput2));

	//	assertEquals(0, day10.solvePart1(input));
	}


	@Test
	public void testSolveDay11Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput11.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input11.txt").getFile());

		Day11 day11 = new Day11();
		assertEquals(37, day11.solvePart1(testInput));
		assertEquals(2368, day11.solvePart1(input));
	}

	@Test
	public void testSolveDay11Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput11.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input11.txt").getFile());

		Day11 day11 = new Day11();
		assertEquals(26, day11.solvePart2(testInput));
		assertEquals(2124, day11.solvePart2(input));

	}


	@Test
	public void testSolveDay12Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput12.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input12.txt").getFile());

		Day12 day12 = new Day12();
		assertEquals(25, day12.solvePart1(testInput));
		assertEquals(1186, day12.solvePart1(input));
	}


	@Test
	public void testSolveDay12Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput12.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input12.txt").getFile());

		Day12 day12 = new Day12();
		assertEquals(286, day12.solvePart2(testInput));
	//	assertEquals(1186, day12.solvePart1(input));
	}

	@Test
	public void testSolveDay13Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput13.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input13.txt").getFile());

		Day13 day13 = new Day13();
		assertEquals(295, day13.solvePart1(testInput));
		assertEquals(6568, day13.solvePart1(input));
	}

	@Test
	@Disabled("Long running test")
	public void testSolveDay13Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput13.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input13.txt").getFile());

		Day13 day13 = new Day13();
		//assertEquals(1202161486, day13.solvePart2(testInput));
		assertEquals(0, day13.solvePart2(input));
	}

	@Test
	public void testSolveDay14Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput14.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input14.txt").getFile());

		Day14 day14 = new Day14();
		assertEquals(165, day14.solvePart1(testInput));
		assertEquals(14954914379452L, day14.solvePart1(input));
	}


	@Test
	public void testSolveDay14Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput14part2.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input14.txt").getFile());

		Day14 day14 = new Day14();
		assertEquals(208, day14.solvePart2(testInput));
		//assertEquals(14954914379452L, day14.solvePart1(input));
	}


	@Test
	public void testSolveDay15Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput15.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input15.txt").getFile());

		Day15 day15 = new Day15();
		assertEquals(436, day15.solvePart1(testInput));
		assertEquals(410, day15.solvePart1(input));
	}

	@Test
	public void testSolveDay15Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput15.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input15.txt").getFile());

		Day15 day15 = new Day15();
		assertEquals(175594, day15.solvePart2(testInput));
		assertEquals(238, day15.solvePart2(input));
	}


	@Test
	public void testSolveDay16Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput16.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input16.txt").getFile());

		Day16 day16 = new Day16();
		assertEquals(71, day16.solvePart1(testInput));
		assertEquals(0, day16.solvePart1(input));
	}


	@Test
	public void testSolveDay16Part2() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput16part2.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input16.txt").getFile());

		Day16 day16 = new Day16();
//		assertEquals(71, day16.solvePart2(testInput));
		assertEquals(3173135507987L, day16.solvePart2(input));
	}

	@Test
	public void testSolveDay17Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput17.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input17.txt").getFile());

		Day17 day17 = new Day17();
		assertEquals(71, day17.solvePart1(testInput));
		//assertEquals(0, day17.solvePart1(input));
	}



	@Test
	public void testSolveDay18Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput17.txt").getFile());
	//	List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("input17.txt").getFile());

		Day18 day18 = new Day18();
		assertEquals(0, day18.solvePart1(testInput));
		//assertEquals(0, day17.solvePart1(input));
	}


	@Test
	public void testSolveDay22Part1() {
		FileHandler fileHandler = new FileHandler();
		List<String> testInput = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/testinput22.txt").getFile());
		List<String> input = fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2020/input22.txt").getFile());

		Day22 day22 = new Day22();
		assertEquals(306, day22.solvePart1(testInput));
		assertEquals(0, day22.solvePart1(input));
	}


}