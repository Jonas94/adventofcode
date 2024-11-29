package adventofcode.year2018;

import adventofcode.year2018.lib.FileHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5 {

    public static void main(String[] args) {

        List<String> rows = FileHandler.readFileIntoList("resources/inputDay5.txt");
        String polymerString = rows.get(0);
        Map<Integer, String> polymerPart1Map = reactPolymer(polymerString);
        String part1String = polymerPart1Map.keySet().toString();

        System.out.println("RESULT PART 1: " + part1String.substring(1, part1String.length() - 1));

        ArrayList<String> polymerStrings = createString(polymerString);
        Map<Integer, String> polymerMap = new HashMap<>();
        int lowestKey = Integer.MAX_VALUE;

        for (String s : polymerStrings) {

            polymerMap = reactPolymer(s);

            for (int key : polymerMap.keySet()) {
                if (key < lowestKey) {
                    lowestKey = key;
                }
            }
        }

        System.out.println("RESULT PART 2: " + lowestKey);
    }

    public static Map reactPolymer(String polymerString) {
        int stringLength;
        Map<Integer, String> polymers = new HashMap<>();
        do {
            stringLength = polymerString.length();
            for (int i = 0; i < polymerString.length() - 1; i++) {

                String letter = String.valueOf(polymerString.charAt(i));
                String nextLetter = String.valueOf(polymerString.charAt(i + 1));

                if (letter.equalsIgnoreCase(nextLetter) && !letter.equals(nextLetter)) {
                    polymerString = polymerString.substring(0, i) + polymerString.substring(i + 2);
                }
            }
        } while (polymerString.length() != stringLength);
        polymers.put(polymerString.length(), polymerString);

        return polymers;
    }

    public static ArrayList createString(String polymerString) {

        ArrayList<Character> letters = new ArrayList<Character>();
        ArrayList<String> polymerStrings = new ArrayList<String>();

        for (int i = 0; i < polymerString.length(); i++) {

            char letter = polymerString.charAt(i);
            if (!letters.contains(letter)) {
                letters.add(letter);
            }
        }

        for (char c : letters) {
            String s = polymerString.replaceAll(String.valueOf(c).toLowerCase(), "");
            s = s.replaceAll(String.valueOf(c).toUpperCase(), "");

            polymerStrings.add(s);
        }
        return polymerStrings;
    }
}
