package adventofcode.year2020.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day15 {
	public long solvePart1(List<String> input) {
		String[] numberArray = input.get(0).split(",");
		return calculate(numberArray, 2020);
	}

	public long solvePart2(List<String> input) {
		String[] numberArray = input.get(0).split(",");
		return calculate(numberArray, 30000000);
	}

	public int calculate(String[] numberArray, int numberOfNumbers){
		List<Integer> numbers = new ArrayList<>();
		Map<Integer, List<Integer>> valuePositions = new HashMap<>();

		for(int i = 0; i<numberArray.length; i++) {
			int value = Integer.parseInt(numberArray[i]);
			numbers.add(value);
			List<Integer> positions = new ArrayList<>();
			positions.add(i);
			valuePositions.put(value, positions);
		}

		int counter = numbers.size();
		while(counter < numberOfNumbers){
			int lastIndex = counter -1;
			int lastNumber = numbers.get(lastIndex);
			int newValue = 0;

			if(valuePositions.get(lastNumber) != null){

				List<Integer> positions = valuePositions.get(lastNumber);
				if(positions.size() > 1) {
					newValue = lastIndex - positions.get(positions.size() - 2);
				}
				else{
					newValue = lastIndex - positions.get(positions.size() - 1);

				}
				List<Integer> newValuePositions;
				if(valuePositions.get(newValue) == null){
					newValuePositions = new ArrayList<>();
					valuePositions.put(newValue, newValuePositions);
				}
				else {
					newValuePositions = valuePositions.get(newValue);
				}
				newValuePositions.add(counter);

			}
			else{
				List<Integer> positions = new ArrayList<>();
				positions.add(counter);
				valuePositions.put(newValue, positions);
			}

			numbers.add(newValue);
			counter++;
		}

		return numbers.get(numberOfNumbers-1);
	}
}
