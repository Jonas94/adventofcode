package adventofcode.year2020.day14;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day14 {
	Set<Integer> floatingBitsIds = new HashSet<>();

	public long solvePart1(List<String> input) {
		String mask = "";

		Map<Integer, String> values = new HashMap<>();
		for (String s : input) {

			String[] row = s.split(" = ");
			String instruction = row[0];
			String value = row[1];

			if (instruction.equals("mask")) {
				mask = value;
			} else {
				Pattern p = Pattern.compile("\\d+");
				Matcher m = p.matcher(instruction);
				m.find();
				int key = Integer.parseInt(m.group());
				String binaryValue = String.format("%36s", Integer.toBinaryString(Integer.parseInt(value))).replace(' ', '0');
				binaryValue = applyMask(mask, binaryValue);

				values.put(key, binaryValue);
			}
		}

		long sum = 0;

		for (Map.Entry<Integer, String> entry : values.entrySet()) {
			long decValue = Long.parseLong(entry.getValue(), 2);
			sum += decValue;
		}

		return sum;
	}

	public String applyMask(String mask, String value) {
		StringBuilder sb = new StringBuilder(value);
		for (int i = 0; i < mask.length(); i++) {
			if (mask.charAt(i) != 'X') {
				sb.setCharAt(i, mask.charAt(i));
			}
		}
		return sb.toString();
	}


	public List<String> applyMaskPart2(String mask, String value) {
		StringBuilder sb = new StringBuilder(value);
		List<String> values = new ArrayList<>();
		floatingBitsIds = new HashSet<>();
		for (int i = 0; i < mask.length(); i++) {
			if (mask.charAt(i) == '1') {
				sb.setCharAt(i, mask.charAt(i));
			}
			else if (mask.charAt(i) == 'X'){
				floatingBitsIds.add(i);
				sb.setCharAt(i, '0');
			}
		}


		return values;
	}


	public long solvePart2(List<String> input) {
		String mask = "";
		BitSet bitSet = new BitSet();

		Map<Integer, String> values = new HashMap<>();
		for (String s : input) {

			String[] row = s.split(" = ");
			String instruction = row[0];
			String value = row[1];

			if (instruction.equals("mask")) {
				mask = value;
			} else {
				Pattern p = Pattern.compile("\\d+");
				Matcher m = p.matcher(instruction);
				m.find();
				int key = Integer.parseInt(m.group());
				String binaryValue = String.format("%36s", Integer.toBinaryString(Integer.parseInt(value))).replace(' ', '0');
				List<String> binaryValues = applyMaskPart2(mask, binaryValue);

				values.put(key, binaryValue);

				List<String> permutations =findPermutationsFromFloatingBits(3);
				System.out.println(permutations);

				for(int i = 0; i<permutations.size(); i++){

				}

				//bitSet.set(Integer.parseInt(permutations.get(i)));


			}
		}

		long sum = 0;


		for (int i = bitSet.nextSetBit(0); i != -1; i = bitSet.nextSetBit(i + 1)) {
			System.out.println(i);
		}
		return sum;

	}

	List<String> findPermutationsFromFloatingBits(int numberOfBits){

		List<String> permutations = new ArrayList<>();

		for(int i = 0; i<Math.pow(2,numberOfBits); i++){
			String format = "%"+numberOfBits+"s";
			permutations.add(String.format(format,Integer.toBinaryString(i)).replace(' ', '0'));

		}

		return permutations;
	}
}




