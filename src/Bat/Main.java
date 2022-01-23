package Bat;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Game game = new Game();
		game.gridInit(); // основное рабочее поле
		game.gridPrint();

		game.initShipS();
		game.setGridBuzzyPrint();
	}

	static int[] inputBoat(String name, int quantity) {
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
			boolean res = false;
			res = ??????checkCoord(coord[]);
			if (res) {
				//grid.print();
				break;
			}

		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage() + "\n");
		}
		return coord;
	}

	public void shoot() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Shoot A-J, 1-10");
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
	}

}
