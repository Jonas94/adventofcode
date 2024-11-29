package adventofcode.year2020.day16;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day16 {
	public long solvePart1(List<String> input) {

		int firstEmptyLineId = findIdOfNextEmptyLine(0, input);
		int secondEmptyLineId = findIdOfNextEmptyLine(firstEmptyLineId + 1, input);

		Set<Integer> validNumbers = new HashSet<>();

		for (int i = 0; i < firstEmptyLineId; i++) {
			String line = input.get(i);

			Pattern pattern = Pattern.compile("\\d+-\\d+");

			Matcher matcher = pattern.matcher(line);

			while (matcher.find()) {
				String[] validRange = matcher.group().split("-");

				int lowerRange = Integer.parseInt(validRange[0]);
				int higherRange = Integer.parseInt(validRange[1]);

				for (int number = lowerRange; number <= higherRange; number++) {
					validNumbers.add(number);
				}
			}
		}

		List<Integer> invalidNumbers = new ArrayList<>();

		for (int i = secondEmptyLineId + 2; i < input.size(); i++) {
			String line = input.get(i);
			String[] chars = line.split(",");

			for (String number : chars) {
				int parsedNumber = Integer.parseInt(number);
				if (!validNumbers.contains(parsedNumber)) {
					invalidNumbers.add(parsedNumber);
					break;
				}
			}
		}
		return invalidNumbers.stream().reduce(0, Integer::sum);
	}

	private int findIdOfNextEmptyLine(int start, List<String> input) {
		for (int i = start; i < input.size(); i++) {
			if (input.get(i).isEmpty()) {
				return i;
			}
		}
		return 0;
	}

	public long solvePart2(List<String> input) {
		Set<Integer> allValidNumbers = new HashSet<>();
		List<String> validTickets = new ArrayList<>();
		int firstEmptyLineId = findIdOfNextEmptyLine(0, input);
		int secondEmptyLineId = findIdOfNextEmptyLine(firstEmptyLineId + 1, input);
		Map<String, Integer> decidedFields = new HashMap<>();


		Map<String, Set<Integer>> ticketRanges = new HashMap<>();

		for (int i = 0; i < firstEmptyLineId; i++) {
			String line = input.get(i);
			String[] information = line.split(":");
			Pattern pattern = Pattern.compile("\\d+-\\d+");
			Matcher matcher = pattern.matcher(line);
			Set<Integer> validNumbers = new HashSet<>();

			while (matcher.find()) {
				String[] validRange = matcher.group().split("-");

				int lowerRange = Integer.parseInt(validRange[0]);
				int higherRange = Integer.parseInt(validRange[1]);

				for (int number = lowerRange; number <= higherRange; number++) {
					validNumbers.add(number);
					allValidNumbers.add(number);
				}
			}
			ticketRanges.put(information[0], validNumbers);
		}

		for (int i = secondEmptyLineId + 2; i < input.size(); i++) {
			String line = input.get(i);
			String[] chars = line.split(",");
			boolean valid = true;

			for (String number : chars) {
				int parsedNumber = Integer.parseInt(number);
				if (!allValidNumbers.contains(parsedNumber)) {
					valid = false;
					break;
				}
			}
			if (valid) {
				validTickets.add(line);
			}
		}

		Map<String, Set<Integer>> possibleFields = new HashMap<>();

		String line = input.get(firstEmptyLineId + 2);
		String[] numbers = line.split(",");
		for (Map.Entry<String, Set<Integer>> entry : ticketRanges.entrySet()) {
			Set<Integer> fields = new HashSet<>();
			for (int i = 0; i < numbers.length; i++) {
				fields.add(i);
			}

			possibleFields.put(entry.getKey(), fields);
		}

		for (Map.Entry<String, Set<Integer>> entry : ticketRanges.entrySet()) {
			for (String ticket : validTickets) {

				String[] chars = ticket.split(",");

				for (int i = 0; i < chars.length; i++) {
					int parsedNumber = Integer.parseInt(chars[i]);

					if (!entry.getValue().contains(parsedNumber)) {
						possibleFields.get(entry.getKey()).remove(i);
					}
				}

			}
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());

		}

		while (decidedFields.size() < 20) {
			for (Map.Entry<String, Set<Integer>> entry : possibleFields.entrySet()) {
				if (entry.getValue().size() == 1) {
					System.out.println(entry.getKey() + " Can only be in field " + entry.getValue());
					decidedFields.put(entry.getKey(), entry.getValue().iterator().next());
				}
			}

			for (Map.Entry<String, Integer> entry : decidedFields.entrySet()) {
				for (Map.Entry<String, Set<Integer>> possibleFieldsEntry : possibleFields.entrySet()) {
					possibleFieldsEntry.getValue().remove(entry.getValue());
				}
			}
		}

		Set<Integer> departureIds = new HashSet<>();

		for (Map.Entry<String, Integer> entry : decidedFields.entrySet()) {

			if (entry.getKey().contains("departure")) {
				departureIds.add(entry.getValue());
			}
		}

		String[] myTicket = getMyTicketAsArray(firstEmptyLineId, input);

		long sum = 1;
		for (Integer departureId : departureIds) {

			sum = sum * Integer.parseInt(myTicket[departureId]);

		}

		return sum;
	}

	private String[] getMyTicketAsArray(int firstEmptyLineId, List<String> input) {

		int ticketPosition = firstEmptyLineId + 2;

		return input.get(ticketPosition).split(",");
	}


}
