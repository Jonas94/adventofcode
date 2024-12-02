package adventofcode.year2015;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

    @Test
    void isNicePart1() {

        Day5 day = new Day5();
        assertTrue(day.isNicePart1("ugknbfddgicrmopn"));
        assertTrue(day.isNicePart1("aaa"));
        assertFalse(day.isNicePart1("jchzalrnumimnmhp"));
        assertFalse(day.isNicePart1("haegwjzuvuyypxyu"));
        assertFalse(day.isNicePart1("dvszwmarrgswjxmb"));

    }

    @Test
    void isNicePart2() {
        Day5 day = new Day5();

        assertTrue(day.isNicePart2("qjhvhtzxzqqjkmpb"));
        assertTrue(day.isNicePart2("xxyxx"));
        assertFalse(day.isNicePart2("uurcxstgmygtbstg"));
        assertFalse(day.isNicePart2("ieodomkazucvgmuy"));
    }


    @Test
    void containsPairTwice() {
        Day5 day = new Day5();
        assertTrue(day.containsPairTwice("xyxy"));
        assertTrue(day.containsPairTwice("aabcdefgaa"));
        assertFalse(day.containsPairTwice("aaa"));
        assertFalse(day.containsPairTwice("ieodomkazucvgmuy"));


    }

    @Test
    void containsRepeatingCharWithOtherCharBetween() {
        Day5 day = new Day5();
        assertTrue(day.containsRepeatingCharWithOtherCharBetween("xyx"));
        assertTrue(day.containsRepeatingCharWithOtherCharBetween("abcdefeghi"));
        assertTrue(day.containsRepeatingCharWithOtherCharBetween("aaa"));
        assertTrue(day.containsRepeatingCharWithOtherCharBetween("ieodomkazucvgmuy"));

    }


    @Test
    void part1() {

        Day5 day = new Day5();
        //248 too low
        assertEquals(255, day.part1());

    }

    @Test
    void part2() {

        Day5 day = new Day5();
        //77 wrong
        //52 wrong
        assertEquals(0, day.part2());

    }
}