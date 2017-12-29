package dag6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Dag6 {
	static List<int[]> bankList = new ArrayList<int[]>();
	static int varv = 0;
	public static void main(String[] args) {

		int i = 0;
		int[] prevBanks = new int[16];
		int[] banks = new int[16];
		List<String> lines = new ArrayList<String>();

		try(BufferedReader br = new BufferedReader(new FileReader("dag6.txt"))) {
			String line = br.readLine();
			lines.add(line);
			while (line != null) {
				line = br.readLine();
				lines.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringTokenizer st = new StringTokenizer(lines.get(0));
		while (st.hasMoreTokens()) {
			int bank = Integer.parseInt(st.nextToken());
			banks[i] = bank;
			i++;
		}
		while(true){
			varv++;
			int highestBankPosition = findHighestBank(banks);
			int memoryBlocksToSpread = banks[highestBankPosition];
			banks[highestBankPosition] = 0;
			for(int y = highestBankPosition+1; memoryBlocksToSpread>0; y++){
				if(y == 16){
					y=0;
				}
				banks[y]++;
				memoryBlocksToSpread--;
			}
			if(compareArrays(banks)){
				System.out.println("Antal varv: " + varv);
				break;
			}
			else{	
				prevBanks = banks.clone();
				bankList.add(prevBanks);
			}
		}
	}
	private static boolean compareArrays(int[] banks){
		for(int i = 0; i<bankList.size();i++){
			int [] prevBanks = bankList.get(i);
			if(Arrays.equals(prevBanks, banks)){
				System.out.println((varv - i)-1);
				printArray(banks);
				printArray(bankList.get(i));
				return true;
			}
		}
		return false;
	}

	private static void printArray(int[] banks){

		for(int i: banks){
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	private static int findHighestBank(int[] banks){
		int highest = Integer.MIN_VALUE;
		int highestPos = 0;
		for(int x = 0; x<16; x++){
			if(banks[x] > highest){
				highest = banks[x];
				highestPos = x;
			}	
		}
		return highestPos;
	}	
}