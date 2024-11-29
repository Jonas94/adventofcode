package adventofcode.year2020.day3;

import java.math.BigInteger;
import java.util.List;

public class Day3 {

	char[][] matrix;

	private static final int GO_RIGHT_1 = 1;
	private static final int GO_RIGHT_3 = 3;
	private static final int GO_RIGHT_5 = 5;
	private static final int GO_RIGHT_7 = 7;
	private static final int GO_DOWN_1 = 1;
	private static final int GO_DOWN_2 = 2;

	private void setupMatrix(List<String> input){
		matrix = new char[input.size()][input.get(0).length()];

		for (int i = 0; i< input.size(); i++){
			char[] chars = input.get(i).toCharArray();


			for(int j = 0; j < input.get(i).length(); j++){
				matrix[i][j] = chars[j];
			}
		}
	}

	public int solvePart1(List<String> input) {

		setupMatrix(input);

		boolean reachedBottom = false;
		int currentX = 0;
		int currentY = 0;
		int numberOfTrees = 0;


		while(!reachedBottom){
			currentX += GO_DOWN_1;
			currentY += GO_RIGHT_3;
			if(currentY >= matrix[currentX].length){
				currentY = currentY - matrix[currentX].length;
			}

			if(matrix[currentX][currentY] == '#'){
				numberOfTrees++;
			}

			if(currentX == matrix.length-1){
				reachedBottom = true;
			}
		}
		return numberOfTrees;
	}

	public BigInteger solvePart2(List<String> input) {

		setupMatrix(input);

		BigInteger value1 = new BigInteger(String.valueOf(calulatePath(GO_RIGHT_1, GO_DOWN_1)));
		BigInteger value2 = new BigInteger(String.valueOf(calulatePath(GO_RIGHT_3, GO_DOWN_1)));
		BigInteger value3 = new BigInteger(String.valueOf(calulatePath(GO_RIGHT_5, GO_DOWN_1)));
		BigInteger value4 = new BigInteger(String.valueOf(calulatePath(GO_RIGHT_7, GO_DOWN_1)));
		BigInteger value5 = new BigInteger(String.valueOf(calulatePath(GO_RIGHT_1, GO_DOWN_2)));

		BigInteger sum = value1.multiply(value2);
		sum = sum.multiply(value3);
		sum = sum.multiply(value4);
		sum = sum.multiply(value5);

		return sum;
	}

	private int calulatePath(int goRight, int goDown){

		boolean reachedBottom = false;
		int currentX = 0;
		int currentY = 0;
		int numberOfTrees = 0;

		while(!reachedBottom){
			currentX += goDown;
			currentY += goRight;
			if(currentY >= matrix[currentX].length){
				currentY = currentY - matrix[currentX].length;
			}

			if(matrix[currentX][currentY] == '#'){
				numberOfTrees++;
			}

			if(currentX == matrix.length-1){
				reachedBottom = true;
			}
		}
		return numberOfTrees;
	}

}
