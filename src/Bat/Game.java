package Bat;

//import static Bat.Main.inputBoat;
//import static Bat.Main.ship;

import static Bat.Main.ship;

public class Game {

	char[][] grid = new char[10][10];
	char[][] gridBuzzy = new char[10][10];
	Ship[] ships = new Ship[5];
	int index = 0;

	public void gridInit() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = '~';
				gridBuzzy[i][j] = '~';
			}
		}
	}

	public Ship getShip(String name){
		Ship res = null;
		for (int i = 0; i < this.ships.length; i++){
			if (this.ships[i].name == name){
				return this.ships[i];
			}
		}
		return res;
	}

	public void initShipS(String name, int quantity, int x, int y, int x1, int y1) {
		ships[index] = new Ship(name, quantity, x, y, x1, y1);
		index++;

		//int[] coord = inputBoat("AircraftCarrier", aircraftCarrier.quantity);
		//ship.shipInit(x, y, x1, y1, grid);
		//ship.merge(grid, aircraftCarrier.ship);
		//gridPrint();

		//int[] coord1 = inputBoat("Battleship", battleship.quantity);
		//battleship.shipInit(coord1[0], coord1[1], coord1[2], coord1[3], gridBuzzy);
//		battleship.merge(grid, battleship.ship);
		//gridPrint();

		//int[] coord2 = inputBoat("Submarine", submarine.quantity);
		//submarine.shipInit(coord2[0], coord2[1], coord2[2], coord2[3], gridBuzzy);
//		submarine.merge(grid, submarine.ship);
		//gridPrint();

		//int[] coord3 = inputBoat("Cruiser", cruiser.quantity);
		//cruiser.shipInit(coord3[0], coord3[1], coord3[2], coord3[3], gridBuzzy);
//		cruiser.merge(grid, cruiser.ship);
		//gridPrint();

		//int[] coord4 = inputBoat("Destroyer", destroyer.quantity);
		//destroyer.shipInit(coord4[0], coord4[1], coord4[2], coord4[3], gridBuzzy);
//		destroyer.merge(grid, destroyer.ship);
		//gridPrint();

	}

	public void gridPrint(char[][] grid) {
		this.grid = grid;
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

	public void GridBuzzyPrint() { // Для проверки сетки занято, затем удалить этот метод
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
		boolean res = true;
		return res;
	}
}
