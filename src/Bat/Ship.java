package Bat;

public class Ship {
	private int quantity; // количество труб
	private int state; // статус просто цифра = труб, сравниваем м/у 0 и quantity
	char[][] ship = new char[10][10]; // пустая сетка с расположением коробля для консоли

	Ship(int quantity) {
		this.quantity = quantity;
		this.state = quantity;
	}

	void shipInit(int x, int y, int x1, int y1) { //заполняем по сетке 10х10 корабль по месту без проверок
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
	}

	public void shipPrint() {
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
		System.out.println("Совмещаем сетку и корабль");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (ship[i][j] == 'O') grid[i][j] = 'O';
			}
		}
		return grid;
	}
}

