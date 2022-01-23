package Bat;

import java.util.Scanner;

public class Ship {
	final int quantity; // количество труб
	private int state; // статус просто цифра = труб, сравниваем м/у 0 и quantity
	char[][] ship = new char[10][10]; // пустая сетка с расположением коробля для консоли

	Ship(int quantity) {
		this.quantity = quantity;
		this.state = quantity;
	}

	void shipInit(int x, int y, int x1, int y1, char[][] gridBuzzy) { //заполняем по сетке 10х10 корабль по месту без проверок
		if (x == x1) {
			for (int i = y; i <= y1; i++) {
				ship[x - 1][i - 1] = 'O';
			}
		}
		if (y == y1) {
			for (int j = x; j <= x1; j++) {
				ship[j - 1][y - 1] = 'O';
			}
		}
		for (int i = x - 2; i <= x1; i++) {
			for (int j = y - 2; j <= y1; j++) {
				if (i >= 0 && j >= 0 && i <= 9 && j <= 9) gridBuzzy[i][j] = 'o';
			}
		}
	}

	public void shipPrint() { // Сначала в проверках использовался потом удалить нахер не нужен
		System.out.println("  1 2 3 4 5 6 7 8 9 10");
		System.out.println("  ____________________");
		String str = ("ABCDEFGHIJ");
		for (int i = 0; i < 10; i++) {
			System.out.print(String.valueOf(str.charAt(i)) + "|");
			for (int j = 0; j < 10; j++) {
				System.out.print(" " + ship[i][j]);
			}
			System.out.println();
		}
	}

	public char[][] merge(char[][] grid, char[][] ship) {
		//System.out.println("Совмещаем сетку и корабль");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (ship[i][j] == 'O') {
					grid[i][j] = 'O';
				}
			}
		}
		return grid;
	}

	int[] inputBoat(String s, int q) {
		Scanner scanner = new Scanner(System.in);
		int[] coord = new int[] {1, 2, 1, 6};
		int quantity = q;
		String name = s;
		System.out.println("Input coordinate " + name + ", quantity - " + q + ", A - J, 1-10 ");
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
		return coord;
	}

}

