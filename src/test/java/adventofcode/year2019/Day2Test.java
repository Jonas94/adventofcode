package adventofcode.year2019;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Day2Test {

    @Spy
    Day2 day2;

    @Test
    public void solveDay2Part1() {
        int[] operations = {1,0,0,0,99};
        when(day2.readFileIntoStringArray()).thenReturn(operations);
        assertEquals(2, day2.solveDay2Part1());

    }

    @Test
    public void solveDay2Part1Example2() {
        int[] operations = {1,1,1,4,99,5,6,0,99};
        when(day2.readFileIntoStringArray()).thenReturn(operations);
        assertEquals(30, day2.solveDay2Part1());

    }





}