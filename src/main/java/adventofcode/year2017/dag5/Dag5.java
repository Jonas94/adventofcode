package adventofcode.year2017.dag5;

import java.util.LinkedList;
import java.util.List;
import adventofcode.utils.FileHandler;

public class Dag5 {

	public static void main(String[] args) {

		LinkedList<Integer> lista = new LinkedList<Integer>();
		FileHandler fh = new FileHandler();
		List<String> lines = fh.readFile("adventofcode.year2017.dag5.txt");

		for(String line: lines){
			if(line != null){
				lista.add(Integer.parseInt(line));
			}
		}
		lista.add(-9999999);

		int stepValue = 0;
		int position = 0;
		int numberOfJumps = 0;
		while(true){	
			position += stepValue;
			stepValue = lista.get(position);

			if(stepValue ==	 -9999999){
				break;
			}
			else if(lista.get(position) >= 3){
				lista.set(position, lista.get(position)-1);
			}
			else
			{
				lista.set(position, lista.get(position)+1);
			}
			numberOfJumps++;
		}
		System.out.println("Number of jumps: " + numberOfJumps);
	}
}