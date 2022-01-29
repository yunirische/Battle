package Bat;

import static Bat.Main.game;
import static Bat.Main.ship;

public class Game {

	static char[][] grid = new char[10][10];
	static char[][] gridBuzzy = new char[10][10];
	public Ship[] ships = new Ship[5];
	public int index = 0;

	public void gridInit() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = '~';
				gridBuzzy[i][j] = '~';
			}
		}
	}

	public Ship getShip(String name) {
		Ship res = null;
		for (int i = 0; i < this.ships.length; i++) {
			if (this.ships[i].name == name) {
				return this.ships[i];
			}
		}
		return res;
	}

	public void initShipS(String name, int quantity, int x, int y, int x1, int y1) {

		ships[index] = new Ship(name, quantity, x, y, x1, y1);
		grid = ships[index].shipInit(x, y, x1, y1, gridBuzzy, grid);

		System.out.println(ships[index].name);
		System.out.println(ships[index].quantity);

		index++;

	}

	public void gridPrint(char[][] gridX) {
		System.out.println("   1 2 3 4 5 6 7 8 9 10");
		System.out.println("  ____________________");
		String str = ("ABCDEFGHIJ");
		for (int i = 0; i < 10; i++) {
			System.out.print(String.valueOf(str.charAt(i)) + "|");
			for (int j = 0; j < 10; j++) {
				System.out.print(" " + gridX[i][j]);
			}
			System.out.println();
		}
	}
	static boolean checkCoord(int[] coord) {
		boolean res = true;
		return res;
	}
}
