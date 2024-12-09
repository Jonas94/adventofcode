package adventofcode.year2024;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Test {

    @Test
    void part1() {
        Day6 day = new Day6();

        assertEquals(41, day.part1("adventofcode/year2024/testinput6.txt"));
        assertEquals(4778, day.part1("adventofcode/year2024/input6.txt"));
        //4777 too low

    }

    @Test
    void part2() {
        Day6 day = new Day6();

      //  assertEquals(6, day.part2("adventofcode/year2024/testinput6.txt"));
        assertEquals(0, day.part2("adventofcode/year2024/input6.txt"));

    }

    @Test
    void testEquals() {

        List<Pair<Point, Direction>> visited = new ArrayList<>();

        visited.add(Pair.of(new Point(0, 0), Direction.RIGHT));
        visited.add(Pair.of(new Point(0, 0), Direction.RIGHT));

        assertEquals(visited.get(0), visited.get(1));
    }

}