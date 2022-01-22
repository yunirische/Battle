package Bat;

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
		aircraftCarrier.shipInit(1, 2, 1, 6, gridBuzzy);
		aircraftCarrier.merge(grid, aircraftCarrier.ship);
		battleship.shipInit(5, 1, 5, 4, gridBuzzy);
		battleship.merge(grid, battleship.ship);
		submarine.shipInit(7, 8, 7, 10, gridBuzzy);
		submarine.merge(grid, submarine.ship);
		cruiser.shipInit(9, 7, 9, 9, gridBuzzy);
		cruiser.merge(grid, cruiser.ship);
		destroyer.shipInit(10, 1, 10, 2, gridBuzzy);
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
}
