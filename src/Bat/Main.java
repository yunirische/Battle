package Bat;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

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
//				String inpLine1 = inpLine.replace("\\d", " ");
//				String[] arrayFromString = inpLine.split(" ");
//				for (int i = 0; i < arrayFromString.length; i++) {
//					System.out.println(arrayFromString[i]);
//				}

				coord[0] = game.StrToIntCoor(inpLine.charAt(0));
				coord[1] = Integer.parseInt(String.valueOf(inpLine.charAt(1)));
				coord[2] = game.StrToIntCoor(inpLine.charAt(2));
				coord[3] = Integer.parseInt(String.valueOf(inpLine.charAt(3)));

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


