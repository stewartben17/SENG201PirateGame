
import java.util.Random;

public class PirateShips {

	private String shipName;
	private int crewNum;
	private double crewWage;
	private int cargoCapacity;
	private int currentCargo = 0;
	private int shipHealth;
	private int maxShipHealth;
	private int shipStrength;
	private int shipSpeed;
	private int upgradedLevel = 1;
	private int captainDiceRoll = 0;
	
	
	/*----------------------------------------------*/
	
	public void setShipName(String shipName)
	{
		this.shipName = shipName;
	}
	
	public String getShipName()
	{
		return shipName;
	}
	
	public void setCrewNum(int crewNum)
	{
		this.crewNum = crewNum;
	}
	
	public int getCrewNum()
	{
		return crewNum;
	}
	
	public void setCrewWage(double crewWage)
	{
		this.crewWage = crewWage;
	}
	
	public double getCrewWage()
	{
		return crewWage;
	}
	
	public void setCargoCapacity(int cargoCapacity)
	{
		this.cargoCapacity = cargoCapacity;
	}
	
	public int getCargoCapacity()
	{
		return cargoCapacity;
	}
	
	public int getRemainingCargoCapacity()
	{
		return cargoCapacity - currentCargo;
	}
	
	public int getCurrentCargo()
	{
		return currentCargo;
	}
	
	public void setRemainingCargo(int currentCargo)
	{
		this.currentCargo = currentCargo;
	}
	
	public void setShipHealth(int shipHealth)
	{
		this.shipHealth = shipHealth;
	}
	
	public int getShipHealth()
	{
		return shipHealth;
	}
	
	public void setShipStrength(int shipStrength)
	{
		this.shipStrength = shipStrength;
	}
	
	public int getShipStrength()
	{
		return shipStrength;
	}
	
	public void setShipSpeed(int shipSpeed)
	{
		this.shipSpeed = shipSpeed;
	}
	
	public int getShipSpeed()
	{
		return shipSpeed;
	}
	
	public void setMaxShipHealth(int maxShipHealth)
	{
		this.maxShipHealth = maxShipHealth;
	}
	
	public double getRepairCosts()
	{
		return (100 - shipHealth) * 40;
	}
	
	public double repairShip()
	{
		double cost = getRepairCosts();
		shipHealth = maxShipHealth;
		return cost;
	}
	
	public int getMaxShipHealth() {
		return maxShipHealth;
	}
	
	public void setUpgradeLevel(int level) {
		upgradedLevel = level;
	}
	
	public int getUpgradeLevel() {
		return upgradedLevel;
	}
	
	public void setCaptainDiceRoll(int roll) {
		captainDiceRoll = roll;
	}
	
	public int getCaptainDiceRoll() {
		return captainDiceRoll;
	}
	
	
	/*----------------------------------------------*/
	
	/*public int randomEvents(int outOf) {
		Random rand = new Random();
		return rand.nextInt(outOf);
	}
	
	public void pirateNumberGame() {
		int currentShipLevel = 
	}
	
	public void randomPirates(int number) {
		
		//If danger = 1 there is a 100 percent chance for a pirate attack
		//If danger = 2 there is 50 percent chance for a pirate attack
		//If danger = 3 there is a 33 percent chance of a pirate attack
		//If danger = 4 there is a 25 percent chance of a pirate attack
		//If danger = 5 there is a 20 percent chance of a pirate attack
		
		int random = randomEvents(number);
		if (random == 0) {
			System.out.println("Pirates attack");
		} else {
			System.out.println("Nothing");
			System.out.println(random);
		}
	}*/
	

	public String toString()
	{
		String returnString = "Ship Name: " + shipName + "\n" + shipName + " currently has " + crewNum + " crew members ";
		returnString += "that are paid $" + crewWage + " per day.\n" + shipName + " has " + getRemainingCargoCapacity();
		returnString += " space remaining in the cargo hold. \nThe current strength of " + shipName + " is " + shipStrength + ".\n";
		returnString += shipName + "'s current health is " + shipHealth + " and will cost $" + getRepairCosts() + " to fully repair.";
		return returnString;
	}
	public static void main(String[] args) {
		
	}

}
