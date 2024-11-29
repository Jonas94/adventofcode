package adventofcode.year2020.day17;

import java.util.List;

public class Day17 {
	public long solvePart1(List<String> input) {

		char[][][] cube = new char[50][100][100];

		for(int x = 0; x<input.size(); x++){
			String line = input.get(x);
			for(int y = 0; y<line.length(); y++){
				cube[10][x][y] = line.charAt(y);

			}
		}

		for(int x = 0; x<input.size(); x++){
			String line = input.get(x);
			for(int y = 0; y<line.length(); y++) {

				System.out.print(cube[10][x][y]);
			}
			System.out.println();
			}



		for(int i = 0; i<=6; i++){







		}


		return 0;
	}



	public long solvePart2(List<String> input) {
		return 0;
	}
}
