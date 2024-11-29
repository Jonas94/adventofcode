package adventofcode.year2020.day4;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Day4 {

	private static final String[] EYE_COLORS = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
	private static final String FOUR_DIGIT_REGEX = "\\d{4}";
	public int solvePart1(String input) {

		String formattedInput = input.replaceAll("(?m)^\\R", ";");
		formattedInput = formattedInput.replace(";;", ";");
		formattedInput = formattedInput.replace("\n", " ");
		String[] passportStrings = formattedInput.split(";");

		int numberOfValidPassports = 0;
		for (String passport : passportStrings) {
			if (parsePassport(passport)) {
				numberOfValidPassports++;
			}
		}
		return numberOfValidPassports;
	}

	public int solvePart2(String input) {

		String formattedInput = input.replaceAll("(?m)^\\R", ";");
		formattedInput = formattedInput.replace(";;", ";");
		formattedInput = formattedInput.replace("\n", " ");

		String[] passportStrings = formattedInput.split(";");

		int numberOfValidPassports = 0;
		for (String passport : passportStrings) {
			if (parsePassport(passport)) {
				numberOfValidPassports++;
			}
		}

		return numberOfValidPassports;
	}

	private boolean parsePassport(String passport) {

		String[] fields = passport.split(" ");

		boolean ecl = false;
		boolean pid = false;
		boolean eyr = false;
		boolean hcl = false;
		boolean byr = false;
		boolean iyr = false;
		boolean hgt = false;
		boolean validated;

		for (String field : fields) {
			if (field.contains("ecl")) {
				ecl = true;
			} else if (field.contains("pid")) {
				pid = true;
			} else if (field.contains("eyr")) {
				eyr = true;
			} else if (field.contains("hcl")) {
				hcl = true;
			} else if (field.contains("byr")) {
				byr = true;
			} else if (field.contains("iyr")) {
				iyr = true;
			} else if (field.contains("hgt")) {
				hgt = true;
			}
		}
		validated = validatePassport(passport);

		return ecl && pid && eyr && hcl && byr && iyr && hgt && validated;
	}

	private boolean validatePassport(String passport) {
		String[] fields = passport.split(" ");

		boolean ecl = false;
		boolean pid = false;
		boolean eyr = false;
		boolean hcl = false;
		boolean byr = false;
		boolean iyr = false;
		boolean hgt = false;

		for (String field : fields) {
			if (field.contains("ecl")) {
				String[] data = field.split(":");
				if (Arrays.stream(EYE_COLORS).anyMatch(data[1]::equalsIgnoreCase)) {
					ecl = true;
				}

			} else if (field.contains("pid")) {
				String[] data = field.split(":");
				if (Pattern.matches("\\d{9}", data[1])) {
					pid = true;
				}

			} else if (field.contains("eyr")) {
				String[] data = field.split(":");

				if (Pattern.matches(FOUR_DIGIT_REGEX, data[1])) {
					int year = Integer.parseInt(data[1]);
					if (year >= 2020 && year <= 2030) {
						eyr = true;
					}
				}

			} else if (field.contains("hcl")) {
				String[] data = field.split(":");
				if (Pattern.matches("#[a-z0-9]{6}", data[1])) {
					hcl = true;
				}
			} else if (field.contains("byr")) {

				String[] data = field.split(":");

				if (Pattern.matches(FOUR_DIGIT_REGEX, data[1])) {
					int year = Integer.parseInt(data[1]);
					if (year >= 1920 && year <= 2002) {
						byr = true;

					}
				}
			} else if (field.contains("iyr")) {
				String[] data = field.split(":");

				if (Pattern.matches(FOUR_DIGIT_REGEX, data[1])) {
					int year = Integer.parseInt(data[1]);
					if (year >= 2010 && year <= 2020) {
						iyr = true;
					}
				}

			} else if (field.contains("hgt")) {
				String[] data = field.split(":");
				if (Pattern.matches("\\d{1,3}[a-z]{2}", data[1])) {

					String[] heightAndFormat = data[1].split("(?=[a-z]{2})");

					int height = Integer.parseInt(heightAndFormat[0]);

					if (heightAndFormat[1].equalsIgnoreCase("cm")) {

						if (height >= 150 && height <= 193) {
							hgt = true;
						}

					} else if (heightAndFormat[1].equalsIgnoreCase("in")) {
						if (height >= 59 && height <= 76) {
							hgt = true;
						}
					}
				}
			}
		}
		return ecl && pid && eyr && hcl && byr && iyr && hgt;
	}
}