package adventofcode.year2017.dag1;

import java.util.List;
import adventofcode.year2017.filereader.FileHandler;

public class Dag1 {
	static int value = 0;

	public static void main(String[] args){
		
		FileHandler fh = new FileHandler();
		List<String> list = fh.readFile("adventofcode/year2017/dag1.txt");
		String captcha = list.get(0);
		int antalSiffror = captcha.length();
		int jamforelseTal = antalSiffror /2;
		int x = 0;
		for(int i = 0; i< captcha.length()-1; i++){
			if(i+jamforelseTal >= antalSiffror){
				x = i+jamforelseTal - antalSiffror;
			}
			else{
				x = i+jamforelseTal;
			}
			if(compare(captcha.charAt(i), captcha.charAt(x)))
			{
				value += Character.getNumericValue(captcha.charAt(i));		
			}
		}
		System.out.println("Value: " + value);
	}
	public static boolean compare(char x, char y){
		System.out.println(x +" =   " + y);
		return x == y;	
	}
}