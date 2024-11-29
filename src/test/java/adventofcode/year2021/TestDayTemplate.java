package adventofcode.year2021;

import adventofcode.year2021.dayTemplate.DayTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDayTemplate {

    @Test
    public void part1() {
        DayTemplate day = new DayTemplate();
        long result = day.part1("adventofcode/year2021/testinputTemplate.txt");
        assertEquals(0, result);
        System.out.println(day.part1("adventofcode/year2021/inputTemplate.txt"));
    }

    @Test
    public void part2() {
        DayTemplate day = new DayTemplate();
        long result = day.part2("adventofcode/year2021/testinputTemplate.txt");
        assertEquals(0, result);
        System.out.println(day.part2("adventofcode/year2021/inputTemplate.txt"));
    }
}