package adventofcode.year2019;

import adventofcode.utils.FileHandler;

import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    public int solveDay1Part1() {

        List<String> modules = readFileIntoStringArray();
        modules = modules.stream().filter(m -> m != null).collect(Collectors.toList());

        int totalFuelNeeded = 0;
        for(String moduleWeight : modules){
          totalFuelNeeded += calculateFuelNeeded(Integer.parseInt(moduleWeight));
        }

        return totalFuelNeeded;
    }

    public int solveDay1Part2() {
        List<String> modules = readFileIntoStringArray();
        modules = modules.stream().filter(m -> m != null).collect(Collectors.toList());

        int totalFuelNeeded = 0;
       for(String moduleWeight : modules){
           totalFuelNeeded += calculateFuelNeededIncludingFuel(Integer.parseInt(moduleWeight));
        }

        return totalFuelNeeded;
    }

    public int calculateFuelNeededIncludingFuel(int moduleWeight){

        int initialFuelNeeded = calculateFuelNeeded(moduleWeight);
        int fuelNeededForModuleAndfuel = initialFuelNeeded;
        int currentFuelNeeded = initialFuelNeeded;
        do {
            currentFuelNeeded = calculateFuelNeeded(currentFuelNeeded);
            if (currentFuelNeeded > 0) {
                fuelNeededForModuleAndfuel += currentFuelNeeded;
            }
        }
        while(currentFuelNeeded > 0);

        return fuelNeededForModuleAndfuel;

    }

    public int calculateFuelNeeded(int mass){
        double massDividedBy3 = mass / 3;
        int flooredMass = (int) Math.floor(massDividedBy3);
        return flooredMass -2;
    }


    public List<String> readFileIntoStringArray(){

        FileHandler fileHandler = new FileHandler();
        return fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2019/day1.txt").getFile());
    }
}
