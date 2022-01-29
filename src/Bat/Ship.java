package Bat;

public class Ship {
	String name;
	final int quantity; // количество труб
	private int state; // статус просто цифра = труб, сравниваем м/у 0 и quantity

	Ship(String name, int quantity, int x, int y, int x1, int y1) {
		this.quantity = quantity;
		this.state = quantity;
		this.name = name;
	}


	char[][] shipInit(int x, int y, int x1, int y1, char[][] gridBuzzy, char[][] grid) { //заполняем по сетке 10х10 корабль по месту без проверок
		if (x == x1) {
			for (int i = y; i <= y1; i++) {
				grid[x - 1][i - 1] = 'O';
				System.out.println("grid 0 x===" + grid[x-1][i-1] + ", " + x + ", " + i);
			}
		}
		if (y == y1) {
			for (int j = x; j <= x1; j++) {
				grid[j - 1][y - 1] = 'O';
				System.out.println("grid 0 y===" + grid[j-1][y-1] + ", " + x + ", " + y);
			}
		}
		for (int i = x - 2; i <= x1; i++) {
			for (int j = y - 2; j <= y1; j++) {
				if (i >= 0 && j >= 0 && i <= 9 && j <= 9) gridBuzzy[i][j] = 'p';
			}
		}
		return grid;
	}

}


