package adventofcode.year2020.day6;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Day6 {


	public int solvePart1(String input) {
		String formattedInput = input.replaceAll("(?m)^\\R", ";");
		formattedInput = formattedInput.replace(";;", ";");
		formattedInput = formattedInput.replace("\n", "");
		String[] declarationStrings = formattedInput.split(";");

		int numberDeclaredGoods = 0;

		for (String declaration : declarationStrings) {
			HashSet<Character> declaredGoods = new HashSet<>();

			for(char ch : declaration.toCharArray()){
				declaredGoods.add(ch);
			}
			numberDeclaredGoods += declaredGoods.size();
		}

		return numberDeclaredGoods;
	}


	public int solvePart2(String input) {

			String formattedInput = input.replaceAll("(?m)^\\R", ";");
			formattedInput = formattedInput.replace(";;", ";");
			formattedInput = formattedInput.replace("\n", " ");
			String[] declarationStrings = formattedInput.split(";");

			int numberDeclaredGoods = 0;

			for (String declaration : declarationStrings) {
				HashSet<Character> declaredGoods = new HashSet<>();
				String[] declarationArray = declaration.split(" ");

				Map<Integer, String> valueMap = new HashMap<>();
				for(int i = 0; i<declarationArray.length; i++){
					valueMap.put(i, declarationArray[i]);
					for(char ch : declarationArray[i].toCharArray()) {
						declaredGoods.add(ch);
					}
				}

				for(char ch : declaredGoods){
					HashSet<Character> tempDeclaredGoods = new HashSet<>();
					boolean existsInAllDeclarations = true;
					for (Map.Entry<Integer, String> me : valueMap.entrySet()) {
						if(!me.getValue().contains(String.valueOf(ch))){
							existsInAllDeclarations = false;
							break;
						}
					}
					if(existsInAllDeclarations){
						tempDeclaredGoods.add(ch);
					}
					numberDeclaredGoods += tempDeclaredGoods.size();

				}
			}

			return numberDeclaredGoods;
		}
}