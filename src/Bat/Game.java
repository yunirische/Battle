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

	static boolean checkCoord(int[] coord, int quantity) {
		if (coord[0] >= 0 && coord[0] < 10 && coord[2] >= 0 && coord[2] < 10 && coord[1] >= 1 && coord[1] <= 10 && coord[3] >= 1 && coord[3] <= 10) {
			if (coord[0] == coord[2] && coord[3] - coord[1] + 1 == quantity) {
				coord[0] += 1;
				coord[2] += 1;
				return true;
			}
			//else System.out.println("Error! Wrong length of the Submarine! Try again:");
			if (coord[1] == coord[3] && coord[2] - coord[0] + 1 == quantity) {
				coord[0] += 1;
				coord[2] += 1;
				return true;
			}
			else System.out.println("Error! Wrong length of the Submarine! Try again:");
		}
		System.out.println("Error! You placed it too close to another one. Try again:");
		return false;
	}

	public int StrToIntCoor(char x) {
		for (int i = 0; i < 10; i++) {
			if (x == ("ABCDEFGHIJ").charAt(i)) {
				return i;
			}
		}
		return 100;
	}

	public boolean buzOrFree(int x, int y, int x1, int y1) {
		char tmp;
		if (x == x1) {
			for (int i = y; i <= y1; i++) {
				if (gridBuzzy[x - 1][i - 1] == 'p') {
					System.out.println("Error! Wrong ship location! Try again:");
					return false;
				}
			}
		}
		if (y == y1) {
			for (int i = x; i <= x1; i++) {
				if (gridBuzzy[i - 1][y - 1] == 'p') {
					System.out.println("Error! Wrong ship location! Try again:");
					return false;
				}
			}
		}

		return true;
	}
	public static String getCoordinatesWords (String str) {

		String strDigit = str.replaceAll("[0-9]", "");
		strDigit = strDigit.replaceAll("\\s+", " ");
		//System.out.println(strDigit + "\n");
		return strDigit;
	}

	public static String[] getCoordinatesDigits (String str) {

		String strWords = str.replaceAll("[A-Za-z]", " ");
		strWords = strWords.replaceAll("\\s+", " ");
		//System.out.println(strWords + "\n");
		String[] arr = strWords.split("\\s");
//		for (String word: arr) {
			System.out.println("arr length - " + arr.length);
//		}
		return arr;
	}

//	static void strToArrCoord (String string) {
//
//		String[] arr = string.split("\\s");
//		for (String word: arr) {
//			System.out.println(word);
//		}
	//}
}

