import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Ship> ships = new ArrayList<>();
		
		Ship ship1 = new Ship("Zeus", 2);
		Ship ship2 = new Ship("Copacabana", 100);
		Ship ship3 = new Ship("Tinos", 220);
		Ship ship4 = new Ship("Hercules", 180);
		Ship ship5 = new Ship("SuperStar", 240);
		Ship ship6 = new Ship("Olympia", 320);
		
		ships.add(ship1);
		ships.add(ship2);
		ships.add(ship3);
		ships.add(ship4);
		ships.add(ship5);
		ships.add(ship6);
		
		new ChargeCalculator(ships);

	}

}
