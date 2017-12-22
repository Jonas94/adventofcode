package dag5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Dag5 {

	public static void main(String[] args) {

		LinkedList<Integer> lista = new LinkedList<Integer>();
		try(BufferedReader br = new BufferedReader(new FileReader("dag5.txt"))) {
			String line = br.readLine();
			lista.add(Integer.parseInt(line));
			while (line != null) {
				line = br.readLine();
				if(line != null){
					lista.add(Integer.parseInt(line));
				}
			}
			lista.add(-9999999);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int stepValue = 0;
		int position = 0;
		int nextPosition = 0;
		int numberOfJumps = 0;
		while(true){	
			position += stepValue;

			stepValue = lista.get(position);
		
			nextPosition = stepValue+position;

			if(stepValue == -9999999){
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
