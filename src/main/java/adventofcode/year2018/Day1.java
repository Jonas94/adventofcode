package adventofcode.year2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

	public static void main(String[] args) {
		
		List<Integer> frequencies = readFileIntoList();
		List<Integer> allResultingFrequencies = new ArrayList<Integer>();
		int resultingFrequency = 0;
		boolean duplicateFrequencyFound = false;
		
		while (!duplicateFrequencyFound) {
			//Takes a while... about 145k iterations with the input from day 1.
			for (Integer currentFrequency : frequencies) {
				resultingFrequency += currentFrequency;
				
				if (!allResultingFrequencies.contains(resultingFrequency)) {
					allResultingFrequencies.add(resultingFrequency);
				}
				else {
					duplicateFrequencyFound = true;
					break;
				}
			}
		}
			System.out.println("First duplicated frequency: " + resultingFrequency);
	}

	private static List<Integer> readFileIntoList() {

		int currentFrequency = 0;
		List<Integer> frequencies = new ArrayList<Integer>();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("adventofcode/year2018/inputDay1.txt"));
			String line = reader.readLine();
			while (line != null) {
				currentFrequency = Integer.parseInt(line);
				frequencies.add(currentFrequency);
				line = reader.readLine();
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return frequencies;
	}
}