package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

    @Test
    void part1() {
        Day5 day = new Day5();

       // assertEquals(143, day.part1("adventofcode/year2024/testinput5.txt"));
    //    assertEquals(5391, day.part1("adventofcode/year2024/input5.txt"));

       // assertEquals(143, day.part1("adventofcode/year2024/testinput5.1.txt"));


    }

    @Test
    void part2() {
        Day5 day = new Day5();

    //    assertEquals(123, day.part2("adventofcode/year2024/testinput5.txt"));
       assertEquals(5391, day.part2("adventofcode/year2024/input5.txt"));
//5983 too low
    }

 /*   @Test
    void sortCorrectly() {
        Day5 day = new Day5();


        assertEquals("97,75,47,61,53", day.sortFailedToCorrect("75,97,47,61,53"));
        assertEquals("61,29,13", day.sortFailedToCorrect("61,13,29"));
        assertEquals("97,75,47,29,13", day.sortFailedToCorrect("97,13,75,29,47"));

    }*/
}