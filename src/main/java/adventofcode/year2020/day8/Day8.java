package adventofcode.year2020.day8;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day8 {

	private static final String ACTION_NOP = "nop";
	private static final String ACTION_ACC = "acc";
	private static final String ACTION_JMP = "jmp";

	public int solvePart1(List<String> input) {

		List<Instruction> instructions = new ArrayList<>();

		for (String s : input) {
			String[] formattedInput = s.split(" ");
			Instruction instruction = new Instruction(formattedInput[0], Integer.parseInt(formattedInput[1]));
			instructions.add(instruction);
		}

		int accumulator = 0;
		Set<Instruction> instructionsRun = new HashSet();
		for(int i = 0; i<instructions.size(); i++){
			Instruction instruction = instructions.get(i);

			if (instructionsRun.contains(instruction)){
				break;
			}

			if(instruction.getAction().equals(ACTION_NOP)){
				continue;
			}
			if(instruction.getAction().equals(ACTION_ACC)){
				accumulator += instruction.getValue();
			}
			if(instruction.getAction().equals(ACTION_JMP)){
				i += instruction.getValue()-1;
			}
			instructionsRun.add(instruction);
		}
		return accumulator;
	}


	public int solvePart2(List<String> input) {

		List<Instruction> instructions = new ArrayList<>();

		for (String s : input) {
			String[] formattedInput = s.split(" ");
			Instruction instruction = new Instruction(formattedInput[0], Integer.parseInt(formattedInput[1]));
			instructions.add(instruction);
		}

		int accumulator = 0;

		for (int x =0; x<instructions.size(); x++){
			List<Instruction> tempInstructions = replaceActionInList(instructions, x);
			Set<Instruction> instructionsRun = new HashSet();
			accumulator = 0;
			boolean endedSuccessfully = true;

			for (int i = 0; i < tempInstructions.size(); i++) {
				Instruction instruction = tempInstructions.get(i);

				if (instructionsRun.contains(instruction)) {
					endedSuccessfully = false;
					break;
				}

				if (instruction.getAction().equals(ACTION_NOP)) {
					continue;
				}
				else if (instruction.getAction().equals(ACTION_ACC)) {
					accumulator += instruction.getValue();
				}
				else if (instruction.getAction().equals(ACTION_JMP)) {
					i += instruction.getValue() - 1;
				}
				instructionsRun.add(instruction);
			}
			if (endedSuccessfully) {
				break;
			}
		}
		return accumulator;
	}

	public List<Instruction> replaceActionInList(List<Instruction> instructions, int instructionId) {

		List<Instruction> tempInstructions = new ArrayList<>();
		for(Instruction instruction : instructions){
			tempInstructions.add(new Instruction(instruction.getAction(), instruction.getValue()));
		}


		if(instructionId > 0) {
			if (tempInstructions.get(instructionId).getAction().equals(ACTION_JMP)) {
				tempInstructions.get(instructionId).setAction(ACTION_NOP);
			} else if (tempInstructions.get(instructionId).getAction().equals(ACTION_NOP)) {
				tempInstructions.get(instructionId).setAction(ACTION_JMP);
			}
		}
		return tempInstructions;
	}
}