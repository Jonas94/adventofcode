package adventofcode.year2020.day10;

import java.util.*;

public class Day10 {

	int value1 = 0;

	public int solvePart1(List<String> input) {

		List<Integer> inputNumbers = new ArrayList<>();
		int numberOf1Diff = 0;
		int numberOf3Diff = 0;

		for(String s : input){
			inputNumbers.add(Integer.parseInt(s));
		}

		Collections.sort(inputNumbers);
		int previousJolt = 0;
		for(int i = 0; i<inputNumbers.size(); i++){
			if(i > 0){
				previousJolt = inputNumbers.get(i-1);
			}

			int currentJolt = inputNumbers.get(i);

			if(currentJolt == previousJolt+3){
				numberOf3Diff++;
			}
			else if(currentJolt == previousJolt+1){
				numberOf1Diff++;
			}
		}

		numberOf3Diff++; //final adapter will always be +3




		return numberOf1Diff * numberOf3Diff;
	}

	public long part2(List<String> input) {

		final int[] list = new int[input.size()];
		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.parseInt(input.get(i));
		}

		Arrays.sort(list);

		final long[] sums = new long[list[list.length - 1] + 1];
		sums[0] = 1;
		for (int i = 0; i < list.length; i++) {
			final long x = list[i] >= 3 ? sums[list[i] - 3] : 0;
			final long y = list[i] >= 2 ? sums[list[i] - 2] : 0;
			final long z = list[i] >= 1 ? sums[list[i] - 1] : 0;
			sums[list[i]] = x + y + z;
		}

		System.out.println(sums[sums.length - 1]);
		return sums[sums.length - 1];
	}


	public long solvePart2(List<String> input) {

		List<Integer> inputNumbers = new ArrayList<>();
		int numberOfArrangements = 0;


		for(String s : input){
			inputNumbers.add(Integer.parseInt(s));
		}

		Collections.sort(inputNumbers);



		int value = 1;
		List<Integer> reachableAdapters = new ArrayList<>();

		for(int i = 0; i<inputNumbers.size(); i++){
			int currentAdapter = inputNumbers.get(i);





		}
		value += getPossibleArrangements(inputNumbers, 0);




		System.out.println(value);

		return value;
	}

		/*   Starting with adapter 0:
                     filter out the "reachable" adapters
                     if reachables return the sum of calling this function with each reachable
                     if no reachables found return 1 since this was the end of one (1) combination

		 */

	public int getPossibleArrangements(List<Integer> adapters, int currentAdapter) {

		Stack<Integer> stack = new Stack<>();

		for (Integer adapter : adapters) {
			if (adapter > currentAdapter && adapter <= currentAdapter + 3) {
				stack.add(adapter);
				System.out.println("Reachable adapter is: " + adapter);
			}
		}

		while(!stack.isEmpty()){
			int selectedAdapter = stack.pop();
			int value = 0;

			for (Integer adapter : adapters) {
				if (adapter > selectedAdapter && adapter <= selectedAdapter + 3) {
					stack.add(adapter);
					System.out.println("Reachable adapter is: " + adapter);
				}
			}
			System.out.println("No more reachables");
			System.out.println();

		}


		return 0;
	}




}