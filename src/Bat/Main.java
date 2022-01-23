package Bat;

public class Main {


	public static void main(String[] args) {
		Game game = new Game();
		game.gridInit(); // основное рабочее поле
		game.gridPrint();

		game.initShipS();
		game.gridPrint();
		game.setGridBuzzyPrint();

	}
}
