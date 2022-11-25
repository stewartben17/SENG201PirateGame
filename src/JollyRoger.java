public class JollyRoger extends PirateShips{
	
	public JollyRoger()
	{
		setShipName("The Jolly Roger");
		setShipSpeed(30);
		setCrewNum(11);
		setShipHealth(100);
		setShipStrength(43);
		setMaxShipHealth(100);
		setCargoCapacity(134);
		setCrewWage(45);
	}
	
	public static void main(String[] args) {
		PirateShips test = new JollyRoger();
		System.out.println(test);
	}

	
}
