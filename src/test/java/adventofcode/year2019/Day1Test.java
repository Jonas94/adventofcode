package adventofcode.year2019;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Day1Test {

    @Spy
    Day1 day1;

    @Test
    public void calculateFuelNeededForMass12() {
        int fuelNeeded = day1.calculateFuelNeeded(12);
        assertEquals(2, fuelNeeded);
    }


    @Test
    public void calculateFuelNeededForMass14() {
        int fuelNeeded = day1.calculateFuelNeeded(14);
        assertEquals(2, fuelNeeded);
    }

    @Test
    public void calculateFuelNeededForMass1969() {
        int fuelNeeded = day1.calculateFuelNeeded(1969);
        assertEquals(654, fuelNeeded);
    }


    @Test
    public void calculateFuelNeededForMass100756() {
        int fuelNeeded = day1.calculateFuelNeeded(100756);
        assertEquals(33583, fuelNeeded);
    }


    @Test
    public void calculateFuelNeededPart2() {
        //33583 + 11192 + 3728 + 1240 + 411 + 135 + 43 + 12 + 2 = 50346

        int fuelNeeded = day1.calculateFuelNeededIncludingFuel(100756);
        assertEquals(50346, fuelNeeded);
    }

    @Test
    public void calculateFuelNeededPart2With2Inputs() {
        List<String> modules = new ArrayList();
        modules.add("100756");
        when(day1.readFileIntoStringArray()).thenReturn(modules);

        int fuelNeeded = day1.solveDay1Part2();

        assertEquals(50346, fuelNeeded);
    }


}