package adventofcode.year2020.day18;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Day18 {
	public long solvePart1(List<String> input) {

		String line = "2 * 3 + (4 * 5)".replaceAll("\\s+","");

		Queue queue = new ArrayBlockingQueue(1);



		for(char c : line.toCharArray()){

			queue.add(c);
		}



		while(!queue.isEmpty()){

			System.out.println(queue.poll());

		}







		return 0;
	}



	public long solvePart2(List<String> input) {
		return 0;
	}
}
