package adventofcode.year2017.dag4;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import adventofcode.utils.FileHandler;

public class Dag4 {

	public static void main(String[] args){
		List<String> validPhrases = new ArrayList<>();

		FileHandler fh = new FileHandler();
		List<String> lines = fh.readFile("adventofcode.year2017.dag4.txt");

		for(int x = 0; x<lines.size()-1; x++){
			List<String> passphrase = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(lines.get(x));
			boolean valid = true;
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				if(passphrase.contains(word)){
					valid = false;
				}	
				passphrase.add(word);
			}
			if(valid){
				validPhrases.add(lines.get(x));
			}
			System.out.println("Valid phrases : " + validPhrases.size());
		}
	}
}