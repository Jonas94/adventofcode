package adventofcode.year2022;

import adventofcode.year2022.day10.Day10;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay10 {

    @Test
    void part1() {
        Day10 day = new Day10();
        assertEquals(13140, day.part1("adventofcode/year2022/testinput10.txt"));
        assertEquals(15220, day.part1("adventofcode/year2022/input10.txt"));
    }

    @Test
    void part2() {
        Day10 day = new Day10();
        assertEquals(getTestOutput(), day.part2("adventofcode/year2022/testinput10.txt"));
        assertEquals(getExpectedOutput(), day.part2("adventofcode/year2022/input10.txt"));
    }



    private String getTestOutput(){
        return """
                ##..##..##..##..##..##..##..##..##..##..
                ###...###...###...###...###...###...###.
                ####....####....####....####....####....
                #####.....#####.....#####.....#####.....
                ######......######......######......####
                #######.......#######.......#######.....""";
    }
    
    
    private String getExpectedOutput(){
        return """
                ###..####.####.####.#..#.###..####..##..
                #..#.#.......#.#....#.#..#..#.#....#..#.
                #..#.###....#..###..##...###..###..#..#.
                ###..#.....#...#....#.#..#..#.#....####.
                #.#..#....#....#....#.#..#..#.#....#..#.
                #..#.#....####.####.#..#.###..#....#..#.""";
    }
}