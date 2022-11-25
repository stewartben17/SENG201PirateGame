public class Argo extends PirateShips{
	
	public Argo()
	{
		setShipName("Argo");
		setShipSpeed(30);
		setCrewNum(11);
		setShipHealth(100);
		setMaxShipHealth(100);
		setShipStrength(43);
		setCargoCapacity(134);
		setCrewWage(5);
	}
	
	public static void main(String[] args) {
		PirateShips test = new Argo();
		System.out.println(test);
	}
}
