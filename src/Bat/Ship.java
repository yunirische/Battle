package Bat;

import static Bat.Main.countBoat;

public class Ship {
	public String name;
	public char[][] ship = new char[10][10];
	final int quantity; // количество труб
	public int state; // статус просто цифра = труб, сравниваем м/у 0 и quantity
	int[] cor;

	Ship(String name, int quantity, int x, int y, int x1, int y1) {
		this.quantity = quantity;
		this.state = quantity;
		this.name = name;
		cor = new int[]{x, y, x1, y1};
	}

	public boolean checkState() {
		this.state--;
		if (state == 0) {
			return true;
		}
		return false;
	}

	char[][] shipInit(int x, int y, int x1, int y1, char[][] gridBuzzy, char[][] grid) { //заполняем по сетке 10х10 корабль по месту без проверок
		if (x == x1 && (y1 - y + 1) == quantity) {
			for (int i = y; i <= y1; i++) {
				grid[x - 1][i - 1] = 'O';
				ship[x - 1][i - 1] = 'O';
				for (int n = x - 2; n <= x1; n++) {
					for (int j = y - 2; j <= y1; j++) {
						if (n >= 0 && j >= 0 && n <= 9 && j <= 9) gridBuzzy[n][j] = 'p';
					}
				}
			}
		}
		if (y == y1 && (x1 - x + 1) == quantity) {
			for (int j = x; j <= x1; j++) {
				grid[j - 1][y - 1] = 'O';
				ship[j - 1][y - 1] = 'O';
				for (int i = x - 2; i <= x1; i++) {
					for (int n = y - 2; n <= y1; n++) {
						if (i >= 0 && n >= 0 && i <= 9 && n <= 9) gridBuzzy[i][n] = 'p';
					}
				}
			}
		}

		return grid;
	}

	public void whtsHpndShip(int x, int y) {
		boolean r = false;
		if (ship[x][y] == 'O' || ship[x][y] == 'X') {
			ship[x][y] = 'X';
			r = checkState();
			if (r) {
				System.out.println("You sank a ship! Specify a new target:");
				countBoat--;
			}
		}
	}
}