public class BlackPearl extends PirateShips{

	public BlackPearl()
	{
		setShipName("The Black Pearl");
		setShipSpeed(30);
		setCrewNum(11);
		setShipHealth(100);
		setMaxShipHealth(100);
		setShipStrength(43);
		setCargoCapacity(134);
		setCrewWage(45);
	}
	
	public static void main(String[] args) {
		PirateShips test = new BlackPearl();
		System.out.println(test);
	}

	
}

