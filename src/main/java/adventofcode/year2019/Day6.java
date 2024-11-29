package adventofcode.year2019;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day6 {
    Map<String, String> orbitMap = new HashMap<>();
    int totalSteps = 0;

    public int solveDay6() {
        List<String> orbits = readFileIntoList();
        orbits = orbits.stream().filter(s -> s != null).collect(Collectors.toList());

        for (String orbitRelationship : orbits) {
            String[] orbit = orbitRelationship.split("\\)");
            orbitMap.put(orbit[1], orbit[0]);
        }

        for (String orbit1 : orbitMap.keySet()) {
            System.out.println(orbit1 + "->" + orbitMap.get(orbit1));
            System.out.println(orbit1 + ": " + findDistanceToCOM(orbit1));
        }

        System.out.println(totalSteps);
        totalSteps = 0;

        String santasPlanet = getSantasOrbitalPlanet();
        String myPlanet = getMyOrbitalPlanet();

        List<String> santasParentPlanets = getParentsListOfPlanet("SAN");
        List<String> myParentPlanets = getParentsListOfPlanet("YOU");
        List<String> commonParents = santasParentPlanets.stream().filter(myParentPlanets::contains).collect(Collectors.toList());

        System.out.println(santasParentPlanets);
        System.out.println(myParentPlanets);
        System.out.println(commonParents);
        int distanceFromMeToCommonParent = findDistanceToAnyPlanet(myPlanet, commonParents.get(0));
        totalSteps = 0;
        int distanceFromSantaToCommonParent = findDistanceToAnyPlanet(santasPlanet, commonParents.get(0));
        int distanceFromMeToSanta = distanceFromMeToCommonParent + distanceFromSantaToCommonParent;
        System.out.println("TOTAL DISTANCE: " + distanceFromMeToSanta);
        return 0;
    }

    private int findDistanceToCOM(String planet) {
        String nextPlanet = orbitMap.get(planet);
        if (!nextPlanet.equals("COM")) {
            findDistanceToCOM(nextPlanet);
        }
        return ++totalSteps;
    }

    private List<String> getParentsListOfPlanet(String planet) {
        List<String> parents = new ArrayList<>();
        String nextPlanet = "";

        while (!nextPlanet.equals("COM")) {
            nextPlanet = orbitMap.get(planet);
            parents.add(nextPlanet);
            planet = nextPlanet;
        }

        return parents;
    }

    private String getSantasOrbitalPlanet() {
        System.out.println(orbitMap.get("SAN"));
        return orbitMap.get("SAN");
    }

    private String getMyOrbitalPlanet() {
        System.out.println(orbitMap.get("YOU"));
        return orbitMap.get("YOU");
    }

    private int findDistanceToAnyPlanet(String currentPlanet, String wantedPlanet) {
        String nextPlanet = orbitMap.get(currentPlanet);
        if (!nextPlanet.equals(wantedPlanet)) {
            findDistanceToAnyPlanet(nextPlanet, wantedPlanet);
        }
        return ++totalSteps;
    }

    public List<String> readFileIntoList() {
        FileHandler fileHandler = new FileHandler();
        return fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2019/day6.txt").getFile());
    }
}
