package Bat;

public class Main {


	public static void main(String[] args) {
		Game game = new Game();
		game.gridInit(); // основное рабочее поле
		game.gridPrint();
		game.initShipS();
//		game.aircraftCarrier.shipPrint();
//		game.battleship.shipPrint();
//		game.submarine.shipPrint();
//		game.cruiser.shipPrint();
//		game.destroyer.shipPrint();
		game.gridPrint();

	}
}
