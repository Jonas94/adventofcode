package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day4Test {

    @Test
    void part1() {
        Day4 day = new Day4();


        assertEquals(18, day.part1("adventofcode/year2024/testinput4.txt"));
        assertEquals(2549, day.part1("adventofcode/year2024/input4.txt"));
    }

    @Test
    void part2() {
        Day4 day = new Day4();
//        assertEquals(48, day.part2("adventofcode/year2024/testinput3.1.txt"));
        //      assertEquals(67269798, day.part2("adventofcode/year2024/input3.txt"));
    }

    @Test
    void tryRight() {
        Day4 day = new Day4();

        char[][] grid = new char[1][4];
        grid[0][0] = 'X';
        grid[0][1] = 'M';
        grid[0][2] = 'A';
        grid[0][3] = 'S';

        assertTrue(day.tryRight(grid, new Point(0, 0)));
    }

    @Test
    void tryLeft() {
        Day4 day = new Day4();

        char[][] grid = new char[1][4];
        grid[0][0] = 'S';
        grid[0][1] = 'A';
        grid[0][2] = 'M';
        grid[0][3] = 'X';

        assertTrue(day.tryLeft(grid, new Point(0, 3)));
    }

    @Test
    void tryUp() {
        Day4 day = new Day4();

        char[][] grid = new char[4][4];
        grid[0][0] = 'S';
        grid[1][0] = 'A';
        grid[2][0] = 'M';
        grid[3][0] = 'X';

        assertTrue(day.tryUp(grid, new Point(3, 0)));
    }

    @Test
    void tryDown() {
        Day4 day = new Day4();

        char[][] grid = new char[4][4];
        grid[0][0] = 'X';
        grid[1][0] = 'M';
        grid[2][0] = 'A';
        grid[3][0] = 'S';

        assertTrue(day.tryDown(grid, new Point(0, 0)));
    }
}