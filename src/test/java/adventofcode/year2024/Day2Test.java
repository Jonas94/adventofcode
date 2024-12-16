package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void part1() {
        Day2 day = new Day2();

        long result = day.part1("adventofcode/year2024/testinput2.txt");
        assertEquals(2, result);
        long result1 = day.part1("adventofcode/year2024/input2.txt");
        assertEquals(479, result1);
    }

    @Test
    void part2() {
        Day2 day = new Day2();

        long result = day.part2("adventofcode/year2024/testinput2.txt");
        assertEquals(4, result);
        long result1 = day.part2("adventofcode/year2024/input2.txt");
        assertEquals(531, result1);

        //505 too low
        //516 too low
        //523 not correct
        //524 not correct
        //525 not correct
        // 526 not correct
        //531 CORRECT!!!!!!
        //535 not correct
        // 623 not correct

    }

}