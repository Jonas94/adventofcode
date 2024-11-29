package adventofcode.year2020.day1;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class Day1 {
	private static final int SUM = 2020;

	public int solveDay1(){
		FileHandler fileHandler = new FileHandler();
		List<String> numberStrings = fileHandler.readFile(getClass().getClassLoader().getResource("input1.txt").getFile());
		List<Integer> numbers = new ArrayList<>();


		for(String number : numberStrings){
			try {
				numbers.add(Integer.parseInt(number));
			}
			catch (NumberFormatException e)
			{
				System.out.println("Something went wrong parsing number");
			}
		}

		for (int i = 0; i<numbers.size(); i++){
			int number1 = numbers.get(i);
			for (int j = 1; j<numbers.size(); j++){
				int number2 = numbers.get(j);

				if(number1 + number2 < SUM){
					int temporarySum = number1 + number2;
					int remaining = SUM - temporarySum;

					if(numbers.contains(remaining)){
						return number1 * number2 * remaining;

					}
				}
			}
		}
		return 0;
	}
}
