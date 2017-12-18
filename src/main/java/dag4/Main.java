package dag4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args){
		int i = 0;
		List<String> lines = new ArrayList<String>();
		List<String> validPhrases = new ArrayList<String>();

		try(BufferedReader br = new BufferedReader(new FileReader("dag4.txt"))) {
			String line = br.readLine();
			//lines[i] = line;
			lines.add(line);
			while (line != null) {
				i++;
				line = br.readLine();
				//lines[i] = line;
				lines.add(line);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for(int x = 0; x<lines.size()-1; x++){
			List<String> passphrase = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(lines.get(x));
			boolean valid = true;
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				if(passphrase.contains(word)){
					valid = false;
				}	
				passphrase.add(word);
			}
			if(valid == true){
				validPhrases.add(lines.get(x));
			}
			System.out.println("Valid phrases : " + validPhrases.size());
		}
	}
}