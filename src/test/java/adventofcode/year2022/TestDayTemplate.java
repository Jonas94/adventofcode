package adventofcode.year2022;

import adventofcode.year2022.dayTemplate.DayTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDayTemplate {

    @Test
    void part1() {
        DayTemplate day = new DayTemplate();
        assertEquals(0, day.part1("adventofcode/year2021/testinputTemplate.txt"));
        assertEquals(0, day.part1("adventofcode/year2021/inputTemplate.txt"));
    }

    @Test
    void part2() {
        DayTemplate day = new DayTemplate();
        assertEquals(0, day.part2("adventofcode/year2021/testinputTemplate.txt"));
        assertEquals(0, day.part2("adventofcode/year2021/inputTemplate.txt"));
    }
}