package Bat;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

import static java.util.Collections.replaceAll;

public class Main {
	static Game game;
	static Ship ship;
	static String[] name;
	static int[] quantity;
	static int id;
	public static int countBoat = 5;

	public static void main(String[] args) {
		game = new Game();
		game.gridInit(); // основное рабочее поле
		game.gridPrint(game.grid);

		name = new String[]{"AircraftCarrier", "battleship", "submarine", "cruiser", "destroyer"};
		quantity = new int[]{5, 4, 3, 3, 2};

		for (id = 0; id < name.length; id++) {
			inputBoat(name[id], quantity[id]); // начинаем инициализировать корабли по списку
		}

		System.out.println("The game starts!");
		game.gameProcess();

	}

	static int[] inputBoat(String name, int quantity) { // вводим координаты, проверяем и инициализируем корабль и сетку с ним
		Scanner scanner = new Scanner(System.in);
		int[] coord = new int[4];
		boolean res = false;
		boolean res1 = false;

		try {
			while (true) {
				if (name == "AircraftCarrier") name = "Aircraft Carrier";
				System.out.println("Enter the coordinates of the " + name + "(" + quantity + " cells):");
				String inpLine = scanner.nextLine().replace(" ", "");

				String words = Game.getCoordinatesWords(inpLine);
				String[] digits = Game.getCoordinatesDigits(inpLine);

				coord[0] = game.StrToIntCoor(words.charAt(0));
				coord[1] = Integer.parseInt(digits[0]);
				coord[2] = game.StrToIntCoor(words.charAt(1));
				coord[3] = Integer.parseInt(digits[1]);

				if (coord[1] > coord[3]) {
					int tmp = coord[1];
					coord[1] = coord[3];
					coord[3] = tmp;
				}
				res = game.checkCoord(coord, quantity);
				res1 = game.buzOrFree(coord[0], coord[1], coord[2], coord[3]);

				if (coord[0] == 100 || coord[2] == 100) continue;
				if (res && res1) {
					game.initShipS(name, quantity, coord[0], coord[1], coord[2], coord[3]);
					game.gridPrint(game.grid);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Error. Exception " + e.getMessage() + "\n");
			id = id - 1;
		}
		return coord;
	}
	public static String shot() {
		Scanner scanner = new Scanner(System.in);
		int[] coordShoot = new int[2];
		boolean res = false;
		String result = new String("XXX");
		try {
			while (true) {
				if (countBoat == 0) {
					System.out.println("You sank the last ship. You won. Congratulations!");
					break;
				}
				System.out.println("Take a shot!");
				System.out.println("countBoat - " + countBoat);
				String inpLineShot = scanner.nextLine().replace(" ", "");

				String words = Game.getCoordinatesWords(inpLineShot);
				String[] digits = Game.getCoordinatesDigits(inpLineShot);

				coordShoot[0] = game.StrToIntCoor(words.charAt(0));
				coordShoot[1] = Integer.parseInt(digits[0]) - 1;

				res = game.checkCoordShoot(coordShoot);

				if (res) {
					game.shootGrid(coordShoot);
					return "XXX";
				}
			}
		} catch (Exception e) {
			System.out.println("Error. Exception " + e.getMessage() + "\n");
		}
		return result;
	}
}