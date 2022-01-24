package Bat;

import static Bat.Main.inputBoat;

public class Game {

	char[][] grid = new char[10][10];
	char[][] gridBuzzy = new char[10][10];

	public void gridInit() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = '~';
				gridBuzzy[i][j] = '~';
			}
		}
	}

	Ship aircraftCarrier = new Ship(5);
	Ship battleship = new Ship(4);
	Ship submarine = new Ship(3);
	Ship cruiser = new Ship(3);
	Ship destroyer = new Ship(2);


	public void initShipS() {

		int[] coord = inputBoat("AircraftCarrier", aircraftCarrier.quantity);
		aircraftCarrier.shipInit(coord[0], coord[1], coord[2], coord[3], gridBuzzy);
		aircraftCarrier.merge(grid, aircraftCarrier.ship);
		gridPrint();

		int[] coord1 = inputBoat("Battleship", battleship.quantity);
		battleship.shipInit(coord1[0], coord1[1], coord1[2], coord1[3], gridBuzzy);
		battleship.merge(grid, battleship.ship);
		gridPrint();

		int[] coord2 = inputBoat("Submarine", submarine.quantity);
		submarine.shipInit(coord2[0], coord2[1], coord2[2], coord2[3], gridBuzzy);
		submarine.merge(grid, submarine.ship);
		gridPrint();

		int[] coord3 = inputBoat("Cruiser", cruiser.quantity);
		cruiser.shipInit(coord3[0], coord3[1], coord3[2], coord3[3], gridBuzzy);
		cruiser.merge(grid, cruiser.ship);
		gridPrint();

		int[] coord4 = inputBoat("Destroyer", destroyer.quantity);
		destroyer.shipInit(coord4[0], coord4[1], coord4[2], coord4[3], gridBuzzy);
		destroyer.merge(grid, destroyer.ship);
		gridPrint();

	}

	public void gridPrint() {
		System.out.println("  1 2 3 4 5 6 7 8 9 10");
		System.out.println("  ____________________");
		String str = ("ABCDEFGHIJ");
		for (int i = 0; i < 10; i++) {
			System.out.print(String.valueOf(str.charAt(i)) + "|");
			for (int j = 0; j < 10; j++) {
				System.out.print(" " + grid[i][j]);
			}
			System.out.println();
		}
	}

	public void setGridBuzzyPrint() { // Для проверки сетки занято, затем удалить этот метод
		System.out.println("\nЗанятые поля");
		System.out.println("  1 2 3 4 5 6 7 8 9 10");
		System.out.println("  ____________________");
		String str = ("ABCDEFGHIJ");
		for (int i = 0; i < 10; i++) {
			System.out.print(String.valueOf(str.charAt(i)) + "|");
			for (int j = 0; j < 10; j++) {
				System.out.print(" " + gridBuzzy[i][j]);
			}
			System.out.println();
		}
	}

	static boolean checkCoord(int[] coord) {
		boolean res = false;
		return res;
	}
}
