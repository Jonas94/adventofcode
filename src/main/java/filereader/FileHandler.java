package filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {
	private static final Logger LOGGER = Logger.getLogger( FileHandler.class.getName() );

	public List<String> readFile(String file){
		List<String> list = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			System.out.println(line);
			list.add(line);
			while (line != null) {
				line = br.readLine();
				list.add(line);
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE,"Filen kunde inte hittas.");
			e.printStackTrace();
		}
		return list;
	}

}
