package adventofcode.year2020.day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day22 {
	public long solvePart1(List<String> input) {

		List<Integer> player1Cards = new ArrayList<>();
		List<Integer> player2Cards = new ArrayList<>();

		int emptyLine = 0;

		for(int i = 0; i< input.size(); i++){
			String line = input.get(i);
			if(line.isEmpty()){
				emptyLine = i;
				break;
			}
		}

		for(int i = 0; i< emptyLine; i++){
			String line = input.get(i);
			if(line.contains("Player")){
				continue;
			}
			player1Cards.add(Integer.parseInt(line));
		}

		for(int i = emptyLine+1; i< input.size(); i++){
			String line = input.get(i);
			if(line.contains("Player")){
				continue;
			}
			player2Cards.add(Integer.parseInt(line));
		}


		while(!player1Cards.isEmpty() && !player2Cards.isEmpty() ){

			int player1Card = player1Cards.get(0);
			int player2Card = player2Cards.get(0);
			player1Cards.remove(0);
			player2Cards.remove(0);


			if(player1Card > player2Card){
				player1Cards.add(player1Card);
				player1Cards.add(player2Card);
			}
			else{
					player2Cards.add(player2Card);
					player2Cards.add(player1Card);
			}
		}

		List<Integer> winningList;
		if(player1Cards.size() > 0) {
			winningList = player1Cards;
		}
		else{
			winningList = player2Cards;

		}

		int sum = 0;
		Collections.reverse(winningList);
		for(int i = 0; i< winningList.size(); i++){
			sum += (i+1)*winningList.get(i);
		}


		return sum;
	}



	public long solvePart2(List<String> input) {
		return 0;
	}
}
