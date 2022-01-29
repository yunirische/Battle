package Bat;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {
	static Game game;
	static Ship ship;
	static String[] name = new String[]{"aircraftCarrier", "battleship", "submarine", "cruiser", "destroyer"};
	static int[] quantity = new int[]{5, 4, 3, 3, 2};

	public static void main(String[] args) {
		game = new Game();
		game.gridInit(); // основное рабочее поле
		System.out.println("grid");
		game.gridPrint(game.grid);
		System.out.println("gridBuzzy");
		game.gridPrint(game.gridBuzzy);

		String[] name = new String[]{"aircraftCarrier", "battleship", "submarine", "cruiser", "destroyer"};
		int[] quantity = new int[]{5, 4, 3, 3, 2};

		for (int i = 0; i < name.length; i++) {
			inputBoat(name[i], quantity[i]); // начинаем инициализировать корабли по списку
		}
	}

	static int @NotNull [] inputBoat(String name, int quantity) { // вводим координаты, проверяем и инициализируем корабль и сетку с ним
		Scanner scanner = new Scanner(System.in);
		int[] coord = new int[4];

		try {
			System.out.println("Input coordinate " + name + ", quantity - " + quantity + ", A - J, 1-10 \n две строки цифры x y через пробел");
			String inpLine = scanner.nextLine().replace(" ", "");
			String inpLine1 = scanner.nextLine().replace(" ", "");
			coord[0] = Integer.parseInt(String.valueOf(inpLine.charAt(0)));
			coord[1] = Integer.parseInt(String.valueOf(inpLine.charAt(1)));
			coord[2] = Integer.parseInt(String.valueOf(inpLine1.charAt(0)));
			coord[3] = Integer.parseInt(String.valueOf(inpLine1.charAt(1)));
			boolean res = true;
			res = Game.checkCoord(coord);
			if (res) {
				System.out.println("initShipS");
				game.initShipS(name, quantity, coord[0], coord[1], coord[2], coord[3]);


				System.out.println("grid");
				game.gridPrint(game.grid);

				System.out.println("gridBuzzy");
				game.gridPrint(game.gridBuzzy);

			}

		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage() + "\n");
		}
		return coord;
	}
}


