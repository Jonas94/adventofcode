package adventofcode.year2020.day9;

import java.util.*;

public class Day9 {

	public int solvePart1(List<String> input, int numberRangeToConsider) {

		List<Integer> list;

		for(int i = 0; i < input.size(); i++){
			list = new LinkedList<>();

				for(int y = i; y < i+numberRangeToConsider; y++){
					if(y >= input.size()-1){
						break;
					}
					list.add(Integer.parseInt(input.get(y)));
				}

			Set<Integer> currentNumbersInList = new HashSet<>();

			for(int j = 0 ; j< list.size(); j++){
				currentNumbersInList.add(list.get(j));

			}
			Set<Integer> validNumbers = new HashSet<>();

			for(int x = 0 ; x< list.size(); x++){
				for(int y = 0 ; y< list.size(); y++){
					if(x != y) {
						validNumbers.add(list.get(x) + list.get(y));
					}
				}
			}

			if(!validNumbers.contains(Integer.parseInt(input.get(i+numberRangeToConsider)))){
				System.out.println(input.get(i+numberRangeToConsider) + " is not in list");
				return Integer.parseInt(input.get(i+numberRangeToConsider));
			}
		}
		return 0;
	}

	public long solvePart2(List<String> input, int sum) {
		List<Long> inputNumbers = new ArrayList<>();
		for(String s : input) {
			inputNumbers.add(Long.parseLong(s));
		}

		List<Long> usedNumbers = new ArrayList<>();

		boolean found = false;
		for(int i = 0; i<inputNumbers.size(); i++){
			long currentSum = inputNumbers.get(i);

			int counter = i;
			usedNumbers = new ArrayList<>();
			usedNumbers.add(inputNumbers.get(i));
			while(currentSum < sum){
				counter++;
				usedNumbers.add(inputNumbers.get(counter));
				currentSum += inputNumbers.get(counter);

				if(currentSum == sum){
					System.out.println("Found it! using numbers " + usedNumbers);
					found = true;
					break;
				}
			}
			if(found){
				break;
			}
		}
		Collections.sort(usedNumbers);
		System.out.println(usedNumbers);

		return usedNumbers.get(0) + usedNumbers.get(usedNumbers.size()-1);
	}
}