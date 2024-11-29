package adventofcode.year2017.dag2;

import adventofcode.utils.FileHandler;

import java.util.List;
import java.util.StringTokenizer;


public class Dag2 {

	public static void main(String[] args) {
		int totalsum = 0;
		FileHandler fh = new FileHandler();
		List<String> list = fh.readFile("adventofcode.year2017.dag2.txt");

		for (int x = 0; x < 16; x++) {
			int lowest = Integer.MAX_VALUE;
			int highest = Integer.MIN_VALUE;
			int sum = 0;
			StringTokenizer st = new StringTokenizer(list.get(x));
			while (st.hasMoreTokens()) {
				int token = Integer.parseInt(st.nextToken());
				if (token < lowest) {
					lowest = token;
				}
				if (token > highest) {
					highest = token;
				}
			}
			sum = highest - lowest;
			System.out.println("sum: " + sum);
			totalsum += sum;
		}
		System.out.println("Total sum: " + totalsum);
	}
}