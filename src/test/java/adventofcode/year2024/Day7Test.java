package adventofcode.year2024;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7Test {

    @Test
    void part1() {
        Day7 day = new Day7();

        //    assertEquals(3749, day.part1("adventofcode/year2024/testinput7.txt"));
        assertEquals(1708857123053L, day.part1("adventofcode/year2024/input7.txt"));

//        1708857638406  too high
        //1708857123053
        //129334116871 too low
    }

    @Test
    void part2() {
        Day7 day = new Day7();

        assertEquals(11387, day.part2("adventofcode/year2024/testinput7.txt"));
        assertEquals(189207836795655L, day.part2("adventofcode/year2024/input7.txt"));

    }
}