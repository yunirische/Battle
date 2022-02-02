package Bat;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

import static java.util.Collections.replaceAll;

public class Main {
	static Game game;
	static Ship ship;
	static String[] name = new String[]{"aircraftCarrier", "battleship", "submarine", "cruiser", "destroyer"};
	static int[] quantity = new int[]{5, 4, 3, 3, 2};
	static int id;

	public static void main(String[] args) {
		game = new Game();
		game.gridInit(); // основное рабочее поле
		//System.out.println("grid");
		game.gridPrint(game.grid);
		//System.out.println("gridBuzzy");
		game.gridPrint(game.gridBuzzy);

		String[] name = new String[]{"Aircraft_Carrier", "battleship", "submarine", "cruiser", "destroyer"};
		int[] quantity = new int[]{5, 4, 3, 3, 2};

		for (id = 0; id < name.length; id++) {
			inputBoat(name[id], quantity[id]); // начинаем инициализировать корабли по списку
		}
	}

	static int @NotNull [] inputBoat(String name, int quantity) { // вводим координаты, проверяем и инициализируем корабль и сетку с ним
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
				System.out.println("1" + words);
				String[] digits = Game.getCoordinatesDigits(inpLine);
				System.out.println("d" + digits);

				coord[0] = game.StrToIntCoor(words.charAt(0));
				System.out.println("coor0 - " + coord[0] + ", words.charat 0 - " + words.charAt(0));
				coord[1] = Integer.parseInt(digits[0]);
				System.out.println("coor1 - " + coord[1] + ", dig.charat 0 - " + digits[0]);
				coord[2] = game.StrToIntCoor(words.charAt(1));
				System.out.println("coor2 - " + coord[2] + ", words.charat 1 - " + words.charAt(1));
				coord[3] = Integer.parseInt(digits[1]);
				System.out.println("coor3 - " + coord[3] + ", dig.charat 1 - " + digits[1]);

				System.out.println("coor" + coord[0] + coord[1] + coord[2] + coord[3]);

				res = game.checkCoord(coord, quantity);
				res1 = game.buzOrFree(coord[0], coord[1], coord[2], coord[3]);

				if (coord[0] == 100 || coord[2] == 100) continue;

				if (res && res1) {
					//System.out.println("initShipS");
					game.initShipS(name, quantity, coord[0], coord[1], coord[2], coord[3]);

					//System.out.println("grid");
					game.gridPrint(Game.grid);
					//System.out.println("gridBuzzy");
					game.gridPrint(Game.gridBuzzy);
					break;

				}
			}
		} catch (Exception e) {
			System.out.println("Error. Exception " + e.getMessage() + "\n");
			id = id - 1;
		}
		return coord;
	}

}


