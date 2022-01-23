package Bat;

import java.util.Scanner;

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
//		int x = 0;
//		int y = 0;
//		int x1 = 0;
//		int y1 = 0;
		int [] coord = battleship.inputBoat("AircraftCarrier", 5);
		aircraftCarrier.shipInit(coord[0], coord[1], coord[2], coord[3], gridBuzzy);
		aircraftCarrier.merge(grid, aircraftCarrier.ship);

		int [] coord1 = battleship.inputBoat("Battleship", 4);
		battleship.shipInit(coord1[0], coord1[1], coord1[2], coord1[3], gridBuzzy);
		battleship.merge(grid, battleship.ship);

		int [] coord2 = battleship.inputBoat("Submarine", 3);
		submarine.shipInit(coord2[0], coord2[1], coord2[2], coord2[3], gridBuzzy);
		submarine.merge(grid, submarine.ship);

		int [] coord3 = battleship.inputBoat("Cruiser", 3);
		cruiser.shipInit(coord3[0], coord3[1], coord3[2], coord3[3], gridBuzzy);
		cruiser.merge(grid, cruiser.ship);

		int [] coord4 = battleship.inputBoat("Destroyer", 2);
		destroyer.shipInit(coord4[0], coord4[1], coord4[2], coord4[3], gridBuzzy);
		destroyer.merge(grid, destroyer.ship);

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

//	public int[] inputBoat(String s, int q) {
//		Scanner scanner = new Scanner(System.in);
//		int[] coord = new int[] {1, 2, 1, 6};
//		int quantity = q;
//		String name = s;
//		System.out.println("Input coordinate " + name + ", quantity - " + q + ", A - J, 1-10 ");
//		//		while (sc.hasNext()) {
////			String move1 = sc.nextLine().replace(" ", "");
////			try {
////				int x = Integer.parseInt(String.valueOf(move1.charAt(0)));
////				int y = Integer.parseInt(String.valueOf(move1.charAt(1)));
////				boolean res = grid.stepX(x, y);
////				if (res) {
////					grid.print();
////					answer = grid.check();
////					break;
////				}
////
////			} catch (Exception e) {
////				System.out.println("Exception " + e.getMessage() + "\n");
////			}
//		return coord;
//	}


	public void shoot() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Shoot A-J, 1-10");
//		while (sc.hasNext()) {
//			String move1 = sc.nextLine().replace(" ", "");
//			try {
//				int x = Integer.parseInt(String.valueOf(move1.charAt(0)));
//				int y = Integer.parseInt(String.valueOf(move1.charAt(1)));
//				boolean res = grid.stepX(x, y);
//				if (res) {
//					grid.print();
//					answer = grid.check();
//					break;
//				}
//
//			} catch (Exception e) {
//				System.out.println("Exception " + e.getMessage() + "\n");
//			}
	}
}
