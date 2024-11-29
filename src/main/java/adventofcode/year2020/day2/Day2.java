package adventofcode.year2020.day2;

import java.util.List;

public class Day2 {

	public int solvePart1(List<String> input) {

		//1-3 a: abcde
		//1-3 b: cdefg
		//2-9 c: ccccccccc

		int numberOfValidPasswords = 0;

		for (String passwordAndPolicy : input) {
			String[] passwordInfo = passwordAndPolicy.split(" ");

			int policyAmountLower = Integer.parseInt(passwordInfo[0].substring(0, passwordInfo[0].indexOf("-")));
			int policyAmountHigher = Integer.parseInt(passwordInfo[0].substring(passwordInfo[0].indexOf("-") + 1));
			char policyChar = passwordInfo[1].substring(0, 1).charAt(0);
			char[] password = passwordInfo[2].toCharArray();

			int occurrences = 0;
			for (char letter : password) {
				if (letter == policyChar) {
					occurrences++;
				}

			}
			if (occurrences >= policyAmountLower && occurrences <= policyAmountHigher) {
				numberOfValidPasswords++;
			}
		}

		return numberOfValidPasswords;
	}


	public int solvePart2(List<String> input) {

		//1-3 a: abcde
		//1-3 b: cdefg
		//2-9 c: ccccccccc

		int numberOfValidPasswords = 0;

		for (String passwordAndPolicy : input) {
			String[] passwordInfo = passwordAndPolicy.split(" ");
			int policyFirstIndex = Integer.parseInt(passwordInfo[0].substring(0, passwordInfo[0].indexOf("-")))-1;
			int policySecondIndex = Integer.parseInt(passwordInfo[0].substring(passwordInfo[0].indexOf("-") + 1))-1;
			char policyChar = passwordInfo[1].substring(0, 1).charAt(0);
			char[] password = passwordInfo[2].toCharArray();

			if (password[policyFirstIndex] == policyChar ^ password[policySecondIndex] == policyChar) {
				numberOfValidPasswords++;
			}
		}

		return numberOfValidPasswords;

	}
}
