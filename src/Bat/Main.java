package Bat;

import java.util.Scanner;

public class Main {
	static Game game;
	static String[] name;
	static int[] quantity;
	static int id;
	public static int countBoat = 5;

	public static void main(String[] args) {
		game = new Game();
		game.gridInit(); // основное рабочее поле
		game.gridPrint(game.grid);

		name = new String[]{"Aircraft_Carrier", "battleship", "submarine", "cruiser", "destroyer"};
		quantity = new int[]{5, 4, 3, 3, 2};

		for (id = 0; id < name.length; id++) {
			inputBoat(name[id], quantity[id]); // начинаем инициализировать корабли по списку
		}

		System.out.println("The game starts!");
		game.gameProcess();

	}

	static void inputBoat(String name, int quantity) { // вводим координаты, проверяем и инициализируем корабль и сетку с ним
		Scanner scanner = new Scanner(System.in);
		int[] coordinates = new int[4];
		boolean res;
		boolean res1;

		try {
			while (true) {
//				if (name == "AircraftCarrier") name = "Aircraft Carrier";
				System.out.println("Enter the coordinates of the " + name + "(" + quantity + " cells):");
				String inpLine = scanner.nextLine().replace(" ", "");

				String words = Game.getCoordinatesWords(inpLine);
				String[] digits = Game.getCoordinatesDigits(inpLine);

				coordinates[0] = game.StrToIntCoor(words.charAt(0));
				coordinates[1] = Integer.parseInt(digits[0]);
				coordinates[2] = game.StrToIntCoor(words.charAt(1));
				coordinates[3] = Integer.parseInt(digits[1]);

				if (coordinates[1] > coordinates[3]) {
					int tmp = coordinates[1];
					coordinates[1] = coordinates[3];
					coordinates[3] = tmp;
				}
				res = Game.checkCoord(coordinates, quantity);
				res1 = game.buzOrFree(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);

				if (coordinates[0] == 100 || coordinates[2] == 100) continue;
				if (res && res1) {
					game.initShipS(name, quantity, coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
					game.gridPrint(game.grid);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Error. Exception " + e.getMessage() + "\n");
			id = id - 1;
		}
	}
	public static void shot() {
		Scanner scanner = new Scanner(System.in);
		int[] coordinateShoot = new int[2];
		boolean res;
		try {
			while (true) {
				if (countBoat == 0) {
					System.out.println("You sank the last ship. You won. Congratulations!");
					break;
				}
				System.out.println("Take a shot!");
				String inpLineShot = scanner.nextLine().replace(" ", "");

				String words = Game.getCoordinatesWords(inpLineShot);
				String[] digits = Game.getCoordinatesDigits(inpLineShot);

				coordinateShoot[0] = game.StrToIntCoor(words.charAt(0));
				coordinateShoot[1] = Integer.parseInt(digits[0]) - 1;
				res = Game.checkCoordShoot(coordinateShoot);

				if (res) {
					game.shootGrid(coordinateShoot);
//					return;
				}
			}
		} catch (Exception e) {
			System.out.println("Error. Exception " + e.getMessage() + "\n");
		}
	}
}