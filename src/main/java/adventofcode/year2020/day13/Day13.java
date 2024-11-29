package adventofcode.year2020.day13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day13 {

	public int solvePart1(List<String> input) {

		int earliestTimestamp = Integer.parseInt(input.get(0));
		int earliestBusId = 0;
		int closestBusDeparture = Integer.MAX_VALUE;


		String[] busIdString = input.get(1).split(",");
		List<Integer> busIds = new ArrayList<>();

		Map<Integer, List<Integer>> busDepartures = new HashMap<>();

		for(String s : busIdString){
			try{
				int busId = Integer.parseInt(s);
				busIds.add(busId);
				busDepartures.put(busId, new ArrayList<>());
			}catch (NumberFormatException e){
				//Do nothing
			}
		}

		for(int i = 0; i< earliestTimestamp *2; i++){
			for(Integer busId : busIds){
				if(i % busId == 0){
					busDepartures.get(busId).add(i);
				}
			}
		}


		for(Integer busId : busIds){
			for(int i = 0; i< busDepartures.get(busId).size(); i++){
				int departureTimestamp = busDepartures.get(busId).get(i);

				if(departureTimestamp >= earliestTimestamp && departureTimestamp < closestBusDeparture){
					closestBusDeparture = departureTimestamp;
					earliestBusId = busId;
				}
			}
		}

			int waitingTime = closestBusDeparture - earliestTimestamp;
			return earliestBusId * waitingTime;
	}


	public long solvePart2(List<String> input) {

		long earliestCommonTimestamp = Integer.MAX_VALUE;
		long highestBusId = 0;

		long earliestBusId = 0;
		long closestBusDeparture = Integer.MAX_VALUE;


		String[] busIdString = input.get(1).split(",");
		List<Long> busIds = new ArrayList<>();

		Map<Long, List<Long>> busDepartures = new HashMap<>();

		for(String s : busIdString){
			try{
				long busId = Long.parseLong(s);
				busIds.add(busId);
				busDepartures.put(busId, new ArrayList<>());
			}catch (NumberFormatException e){
				busIds.add(-1L);
			}
		}



		for(Long busId : busIds) {
			if (busId == -1) {
				continue;
			}
			if(busId > highestBusId){
				highestBusId = busId;
			}

		}


		long counter = 0;
		long indexOfHighestBusId = busIds.indexOf(new Long(highestBusId));
		boolean found;
		do {
			found = true;
			counter += highestBusId;

			for(Long busId : busIds){
				if(busId == -1){
					continue;
				}
				long indexOfCurrentId = busIds.indexOf(new Long(busId));
				if((counter-(indexOfHighestBusId-indexOfCurrentId)) % Long.valueOf(busId) != 0){
					found = false;
					break;
				}
			}
			System.out.println(counter);

		} while(!found);

		long startingIndex = counter - indexOfHighestBusId;

		System.out.println(startingIndex);

		return startingIndex;
	}
	}



