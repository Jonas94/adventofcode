package adventofcode.year2020.day5;


import java.util.ArrayList;
import java.util.List;

public class Day5 {


	public int solvePart1(List<String> input) {

		int highestSeatId = 0;
		for(String code : input){
			int seatId = findSeatIdByCode(code);

			if(seatId > highestSeatId){
				highestSeatId = seatId;
			}
		}


	return	highestSeatId;
	}


	public int findSeatIdByCode(String code){
			int row = 0;
			int low = 0;
			int high = 127;

			char[] instructions = code.toCharArray();

			for(int i = 0; i<instructions.length - 3; i++){

				int middle = (high-low)/2;

				if(instructions[i] == 'F'){
					high -= middle+1;
				}
				else if(instructions[i] == 'B'){
					low += middle+1;
				}
			}
			row = low;
			int column = 0;
			int lowColumn = 0;
			int highColumn = 7;
			for(int i = instructions.length - 3; i<instructions.length; i++) {

				int middle = (highColumn - lowColumn) / 2;

				if (instructions[i] == 'L') {
					highColumn -= middle + 1;
				} else if (instructions[i] == 'R') {
					lowColumn += middle + 1;
				}
				column = lowColumn;
			}
		return row * 8 + column;

	}

	public int solvePart2(List<String> input) {

		int mySeatId = 0;
		List<Integer> takenSeatIds = new ArrayList<>();
		for(String code : input){
			takenSeatIds.add(findSeatIdByCode(code));
		}

		for(int i = 1; i<892; i++){
			if(!takenSeatIds.contains(i) && takenSeatIds.contains(i-1) && takenSeatIds.contains(i+1)){
				mySeatId = i;
			}
		}


		return mySeatId;
	}

}