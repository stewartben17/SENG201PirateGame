public class Titanic extends PirateShips {

	public Titanic()
	{
		setShipName("The Titanic");
		setShipSpeed(2);
		setCrewNum(11);
		setShipHealth(100);
		setShipStrength(43);
		setCargoCapacity(134);
		setMaxShipHealth(100);
		setCrewWage(45);
	}
	
	public static void main(String[] args) {
		PirateShips test = new Titanic();
		System.out.println(test);
	}
	
}
