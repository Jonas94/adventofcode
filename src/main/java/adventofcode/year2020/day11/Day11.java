package adventofcode.year2020.day11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day11 {


	public int solvePart1(List<String> input) {

		char[][] matrix = new char[input.size()][input.get(0).length()];


		for (int x = 0; x < matrix.length; x++) {
			String row = input.get(x);
			for (int y = 0; y < matrix[x].length; y++) {
				matrix[x][y] = row.charAt(y);
			}
		}


		char[][] prevMatrix = new char[0][0];

		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				System.out.print(matrix[x][y]);
			}
			System.out.println();
		}
		System.out.println();


		do {
			prevMatrix = Arrays.stream(matrix).map(char[]::clone).toArray(char[][]::new);
			matrix = changeStateOfSeats(matrix);
			System.out.println();

		} while (!compareMatrix(prevMatrix, matrix));


		return countTakenSeats(matrix);
	}

	private char[][] changeStateOfSeats(char[][] matrix) {

		char[][] tempMatrix = Arrays.stream(matrix).map(char[]::clone).toArray(char[][]::new);

		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				Set<Position> neigbours = findNeighbours(matrix, x, y);
				boolean noOccupiedSeats = true;
				int takenSeatsAround = 0;
				for (Position neigbour : neigbours) {
					if (matrix[x][y] == '.') {
						continue;
					}

					if (matrix[x][y] == 'L') {
						if (matrix[neigbour.getX()][neigbour.getY()] == '#') {
							noOccupiedSeats = false;
							//break;
						}
					} else if (matrix[x][y] == '#') {

						if (matrix[neigbour.getX()][neigbour.getY()] == '#') {
							takenSeatsAround++;
						}
						if (takenSeatsAround >= 4) {
							tempMatrix[x][y] = 'L';
						}
					}
				}

				if (noOccupiedSeats && matrix[x][y] == 'L') {
					tempMatrix[x][y] = '#';
				}


				System.out.print(tempMatrix[x][y]);
			}
			System.out.println();
		}

		matrix = Arrays.stream(tempMatrix).map(char[]::clone).toArray(char[][]::new);
		return matrix;

	}

	private Set<Position> findNeighbours(char[][] matrix, int xPos, int yPos) {
		Set<Position> neigbours = new HashSet<>();

		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {

				if (xPos + x >= 0 && xPos + x < matrix.length && yPos + y >= 0 && yPos + y < matrix[xPos].length) {
					if (x == 0 && y == 0) {
						continue;
					}
					neigbours.add(new Position(xPos + x, yPos + y));

				}

			}

		}

		return neigbours;
	}

	private int countTakenSeats(char[][] matrix) {

		int takenSeats = 0;
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				if (matrix[x][y] == '#') {
					takenSeats++;
				}
			}
		}
		return takenSeats;
	}

	private boolean compareMatrix(char[][] matrix1, char[][] matrix2) {
		for (int x = 0; x < matrix1.length; x++) {
			for (int y = 0; y < matrix1[x].length; y++) {
				if (matrix1[x][y] != matrix2[x][y]) {
					return false;
				}
			}
		}
		return true;
	}

	public long solvePart2(List<String> input) {


		char[][] matrix = new char[input.size()][input.get(0).length()];


		for (int x = 0; x < matrix.length; x++) {
			String row = input.get(x);
			for (int y = 0; y < matrix[x].length; y++) {
				matrix[x][y] = row.charAt(y);
			}
		}


		char[][] prevMatrix = new char[0][0];

		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				System.out.print(matrix[x][y]);
			}
			System.out.println();
		}
		System.out.println();


		do {
			prevMatrix = Arrays.stream(matrix).map(char[]::clone).toArray(char[][]::new);
			matrix = changeStateOfSeatsPart2(matrix);
			System.out.println();

		} while (!compareMatrix(prevMatrix, matrix));


		return countTakenSeats(matrix);

	}

	private Set<Position> findNeighboursPart2(char[][] matrix, int xPos, int yPos) {
		Set<Position> neigbours = new HashSet<>();

		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {

				int finalPosX = xPos + x;
				int finalPosY = yPos + y;


				boolean found = false;
				while (!found) {

					if (finalPosX >= 0 && finalPosX < matrix.length && finalPosY >= 0 && finalPosY < matrix[xPos].length) {
						if (x == 0 && y == 0) {
							break;
						}

						if (matrix[finalPosX][finalPosY] != '.') {
							found = true;
							break;
						}

						finalPosX = finalPosX + x;
						finalPosY = finalPosY + y;
					} else {
						break;
					}
				}
				if (found) {
					neigbours.add(new Position(finalPosX, finalPosY));
				}

			}

		}

		return neigbours;
	}


	private char[][] changeStateOfSeatsPart2(char[][] matrix) {

		char[][] tempMatrix = Arrays.stream(matrix).map(char[]::clone).toArray(char[][]::new);

		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				Set<Position> neigbours = findNeighboursPart2(matrix, x, y);
				boolean noOccupiedSeats = true;
				int takenSeatsAround = 0;
				for (Position neigbour : neigbours) {
					if (matrix[x][y] == '.') {
						continue;
					}

					if (matrix[x][y] == 'L') {
						if (matrix[neigbour.getX()][neigbour.getY()] == '#') {
							noOccupiedSeats = false;
							//break;
						}
					} else if (matrix[x][y] == '#') {

						if (matrix[neigbour.getX()][neigbour.getY()] == '#') {
							takenSeatsAround++;
						}
						if (takenSeatsAround >= 5) {
							tempMatrix[x][y] = 'L';
						}
					}
				}

				if (noOccupiedSeats && matrix[x][y] == 'L') {
					tempMatrix[x][y] = '#';
				}


				System.out.print(tempMatrix[x][y]);
			}
			System.out.println();
		}

		return tempMatrix;
	}

}