package adventofcode.year2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day9Test {

    @Test
    void part1() {
        Day9 day = new Day9();
        assertEquals(1928, day.part1("adventofcode/year2024/testinput9.txt"));
        assertEquals(6340197768906L, day.part1("adventofcode/year2024/input9.txt"));
    }

    @Test
    void part2() {
        Day9 day = new Day9();

        /**
         * Testcases from reddit to find edge cases
         *
         * 673253833464635054191677274350925861527651788483 = 149706
         * 23222120202525282820202020272722212121 = 7705
         * 22222228282828222222282829212324252627282920 = 9447
         */
        assertEquals(7705, day.part2("adventofcode/year2024/testinput9.1.txt"));
        assertEquals(2858, day.part2("adventofcode/year2024/testinput9.txt"));
        assertEquals(6363913128533L, day.part2("adventofcode/year2024/input9.txt"));

    }
}