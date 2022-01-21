package Bat;

public class Game {

	char[][] grid = new char[10][10];

	public void gridInit() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = '~';
			}
		}
	}

	Ship aircraftCarrier = new Ship(5);
	Ship aircraftCarrierDouble = new Ship(5);

	public void initShipS() {
		aircraftCarrier.shipInit(1,2,1,7);
		aircraftCarrier.shipPrint();
		aircraftCarrierDouble.shipInit(3,3,8,3);
		aircraftCarrierDouble.shipPrint();
	}
	/*	Ship battleship = new Ship(4);
		Ship submarine = new Ship(3);
		Ship cruiser = new Ship(3);
		Ship destroyer = new Ship(2);*/


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
}
