package adventofcode.year2020.day12;

import java.util.List;

public class Day12 {


	public int solvePart2(List<String> input) {
		int eastWestShip = 0;
		int northSouthShip = 0;

		int eastWestWaypoint = 10;
		int northSouthWaypoint = 1;

		WaypointDirection currentlyHeading = WaypointDirection.NORTH_EAST;

		for(String instruction : input){
			String action = instruction.substring(0,1);
			int value = Integer.parseInt(instruction.substring(1));

			System.out.println(action + "  " + value);

			if(action.equals("R")){

				int numberOfSteps = value / 90;
				int newDirectionId = 0;
				int currentDirectionId = WaypointDirection.valueOf(currentlyHeading.name()).ordinal();

				if(currentDirectionId+numberOfSteps >= WaypointDirection.values().length){
					newDirectionId = currentDirectionId+numberOfSteps-(WaypointDirection.values().length);
				}
				else{
					newDirectionId = currentDirectionId + numberOfSteps;
				}

				for(int i = 0; i<numberOfSteps; i++){

					int deltaEastWest = eastWestWaypoint - eastWestShip;
					int deltaNorthSouth = northSouthWaypoint - northSouthShip;

					switch (currentlyHeading){
						case NORTH_EAST:
							northSouthWaypoint = northSouthShip-deltaEastWest;
							eastWestWaypoint = eastWestShip - deltaNorthSouth;
							break;
						case SOUTH_EAST:
							eastWestWaypoint = eastWestShip-deltaNorthSouth;
							break;
						case SOUTH_WEST:
							northSouthWaypoint = northSouthShip+deltaEastWest;
							break;
						case NORTH_WEST:
							eastWestWaypoint = eastWestShip + deltaNorthSouth;
							break;

					}
					currentlyHeading = WaypointDirection.values()[newDirectionId];



					/*
					10 east, 4 north

					4 east, 10 south (-10 north)
					 */


					/*
					N3 moves the waypoint 3 units north to 10 units east and 4 units north of the ship. The ship remains at east 100, north 10.
					R90 rotates the waypoint around the ship clockwise 90 degrees, moving it to 4 units east and 10 units south of the ship.
					 */


				}


			}
			else if(action.equals("L")){
				int numberOfSteps = value / 90;
				int newDirectionId = 0;
				int currentDirectionId = Direction.valueOf(currentlyHeading.name()).ordinal();

				if(currentDirectionId-numberOfSteps < 0){
					newDirectionId = currentDirectionId-numberOfSteps+(Direction.values().length);
				}
				else{
					newDirectionId = currentDirectionId - numberOfSteps;
				}

				currentlyHeading = WaypointDirection.values()[newDirectionId];
			}

			if(action.equals("N")){
				northSouthWaypoint += value;
			}
			else if(action.equals("S")){
				northSouthWaypoint -= value;
			}
			else if(action.equals("E")){
				eastWestWaypoint += value;
			}
			else if(action.equals("W")){
				eastWestWaypoint -= value;
			}

			if(action.equals("F")) {

				for(int i = 0; i< value; i++) {
					int deltaEastWest = eastWestWaypoint - eastWestShip;
					int deltaNorthSouth = northSouthWaypoint - northSouthShip;
					eastWestShip = eastWestWaypoint;
					northSouthShip = northSouthWaypoint;

					eastWestWaypoint += deltaEastWest;
					northSouthWaypoint += deltaNorthSouth;
				}
			}


			System.out.println("EAST WEST " + eastWestShip);
			System.out.println("NORTH SOUTH " + northSouthShip);


		}

		return Math.abs(eastWestShip) + Math.abs(northSouthShip);
	}




	/*
F10 moves the ship to the waypoint 10 times (a total of 100 units east and 10 units north), leaving the ship at east 100, north 10. The waypoint stays 10 units east and 1 unit north of the ship.
N3 moves the waypoint 3 units north to 10 units east and 4 units north of the ship. The ship remains at east 100, north 10.
F7 moves the ship to the waypoint 7 times (a total of 70 units east and 28 units north), leaving the ship at east 170, north 38. The waypoint stays 10 units east and 4 units north of the ship.
R90 rotates the waypoint around the ship clockwise 90 degrees, moving it to 4 units east and 10 units south of the ship. The ship remains at east 170, north 38.
F11 moves the ship to the waypoint 11 times (a total of 44 units east and 110 units south), leaving the ship at east 214, south 72. The waypoint stays 4 units east and 10 units south of the ship.
	 */

	public int solvePart1(List<String> input) {
		int eastWest = 0;
		int northSouth = 0;

		Direction currentlyHeading = Direction.EAST;

		for(String instruction : input){
			String action = instruction.substring(0,1);
			int value = Integer.parseInt(instruction.substring(1));

			System.out.println(action + "  " + value);

			if(action.equals("R")){

				int numberOfSteps = value / 90;
				int newDirectionId = 0;
				int currentDirectionId = Direction.valueOf(currentlyHeading.name()).ordinal();

				if(currentDirectionId+numberOfSteps >= Direction.values().length){
					newDirectionId = currentDirectionId+numberOfSteps-(Direction.values().length);
				}
				else{
					newDirectionId = currentDirectionId + numberOfSteps;
				}

				currentlyHeading = Direction.values()[newDirectionId];

			}
			else if(action.equals("L")){
				int numberOfSteps = value / 90;
				int newDirectionId = 0;
				int currentDirectionId = Direction.valueOf(currentlyHeading.name()).ordinal();

				if(currentDirectionId-numberOfSteps < 0){
					newDirectionId = currentDirectionId-numberOfSteps+(Direction.values().length);
				}
				else{
					newDirectionId = currentDirectionId - numberOfSteps;
				}

				currentlyHeading = Direction.values()[newDirectionId];

			}


			if(action.equals("N")){
				northSouth += value;
			}
			else if(action.equals("S")){
				northSouth -= value;
			}
			else if(action.equals("E")){
				eastWest += value;
			}
			else if(action.equals("W")){
				eastWest -= value;
			}

			if(action.equals("F")) {
				switch (currentlyHeading){
					case EAST:
						eastWest += value;
						break;
					case WEST:
						eastWest -= value;
						break;
					case NORTH:
						northSouth += value;
						break;
					case SOUTH:
						northSouth -= value;
						break;

				}
			}


			System.out.println("EAST WEST " + eastWest);
			System.out.println("NORTH SOUTH " + northSouth);


		}

		return Math.abs(eastWest) + Math.abs(northSouth);
	}

	private enum Direction{
		EAST,
		SOUTH,
		WEST,
		NORTH;

	}

	private enum WaypointDirection{
		NORTH_EAST,
		SOUTH_EAST,
		SOUTH_WEST,
		NORTH_WEST;

	}


}