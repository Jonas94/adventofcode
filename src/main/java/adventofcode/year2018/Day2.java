package adventofcode.year2018;

import adventofcode.year2018.lib.LevenshteinCalculator;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day2 {

	public static void main(String[] args) {

		System.out.println("Checksum :" + findDuplicatedLettersAndCalculateChecksum());
		System.out.println("Common letters of correct box ID's: " + createResultString());
	}

	private static List<String> readFileIntoList() {

		List<String> boxIDs = new ArrayList<String>();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("adventofcode/year2018/inputDay2.txt"));
			String line = reader.readLine();
			while (line != null && line.length() > 1) {
				boxIDs.add(line);
				line = reader.readLine();
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return boxIDs;
	}
	
	private static int findDuplicatedLettersAndCalculateChecksum() {
		List<String> boxIDs = readFileIntoList();

		Set<String> twoDuplicateLetters = new LinkedHashSet<>();
		Set<String> threeDuplicateLetters = new LinkedHashSet<>();

		for (String s : boxIDs) {
			Map<String, Integer> charMap = new HashMap<String, Integer>();

			for (char c : s.toCharArray()) {
				String letter = Character.toString(c);
				charMap.merge(letter, 1, Integer::sum);
			}

			for (String key : charMap.keySet()) {
				if (charMap.get(key) == 2) {
					twoDuplicateLetters.add(s);
				} else if (charMap.get(key) == 3) {
					threeDuplicateLetters.add(s);
				}
			}
		}

		System.out.println("number of two duplicates " + twoDuplicateLetters.size());
		System.out.println("number of three duplicates " + threeDuplicateLetters.size());

		return twoDuplicateLetters.size() * threeDuplicateLetters.size();
	}

	private static List<String> findCorrectBoxIDs() {
		LevenshteinCalculator lc = new LevenshteinCalculator();
		List<String> boxIDs = readFileIntoList();
		List<String> correctIDs = new ArrayList<String>();

		int lowestCost = Integer.MAX_VALUE;
		for (int i = 0; i < boxIDs.size(); i++) {
			for (int j = 1; j < boxIDs.size(); j++) {
				if (i != j) {
					int currentCost = lc.calculate(boxIDs.get(i), boxIDs.get(j));
					if (currentCost < lowestCost) {
						lowestCost = currentCost;
						System.out.println(
								"Strings with lowest cost (" + lowestCost + ") " + boxIDs.get(i) + " " + boxIDs.get(j));
						correctIDs.clear();
						correctIDs.add(boxIDs.get(i));
						correctIDs.add(boxIDs.get(j));
					} else {
						// self compare
					}
				}
			}
		}
		return correctIDs;
	}

	private static String createResultString() {
		List<String> correctIDs = findCorrectBoxIDs();

		StringBuilder sb = new StringBuilder(correctIDs.get(0));
		sb.deleteCharAt(StringUtils.indexOfDifference(correctIDs.get(0), correctIDs.get(1)));

		return sb.toString();
	}
}
