package Bat;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Game game = new Game();
		game.gridInit(); // основное рабочее поле
		game.gridPrint();

		game.initShipS();
		game.gridPrint();
		game.setGridBuzzyPrint();
	}

	static int[] inputBoat(String s, int q) {
		Scanner scanner = new Scanner(System.in);
		int[] coord = new int[]{1, 2, 1, 6};
		int quantity = q;
		String name = s;
		System.out.println("Input coordinate " + name + ", quantity - " + q + ", A - J, 1-10 ");
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
