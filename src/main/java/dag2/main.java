package dag2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args){
		int i = 0;
		int totalsum = 0;
		String lines[] = new String[20];
		try(BufferedReader br = new BufferedReader(new FileReader("dag2.txt"))) {
			String line = br.readLine();
			System.out.println(line);
			lines[i] = line;
			while (line != null) {
				i++;
				line = br.readLine();
				lines[i] = line;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for(int x = 0; x<16; x++){
			int lowest = Integer.MAX_VALUE;
			int highest = Integer.MIN_VALUE;
			int sum = 0;
			StringTokenizer st = new StringTokenizer(lines[x]);
			while (st.hasMoreTokens()) {
				int token = Integer.parseInt(st.nextToken());
				if(token < lowest){
					lowest = token;
				}
				if(token > highest){
					highest = token;
				}

			}
			sum = highest-lowest;
			System.out.println("sum: " + sum);
			totalsum += sum;
		}
		System.out.println("Total sum: " + totalsum);
	}
}