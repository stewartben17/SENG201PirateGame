import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;


public class Player {

	private String name;
	private double balance = 1000.00;
	private Hashtable<IslandMain.Buying, Integer> inventoryDict = new Hashtable<IslandMain.Buying, Integer>();	
	//The arrayList's below could be turned into a class like what is done in the IslandMain class
	
	private ArrayList<String> inventoryHistory = new ArrayList<String>();
	private ArrayList<String> islandBroughtHistory = new ArrayList<String>();
	private ArrayList<Double> costBroughtHistory = new ArrayList<Double>();
	private ArrayList<String> islandSoldHistory = new ArrayList<String>(); 
	private ArrayList<Double> costSoldHistory = new ArrayList<Double>();
	
	private int numDaysRemaining;
	private int selectedNumDays;
	
	/*----------------------------------------------*/
	
	//General getter and setter functions
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setNumDaysRemaning(int numDaysRemaining)
	{
		this.numDaysRemaining = numDaysRemaining;
	}
	
	public int getNumDaysRemaining()
	{
		return numDaysRemaining;
	}
	
	public void setSelectedNumDays(int numDays) {
		selectedNumDays = numDays;
	}
	
	public int getSelectedNumDays() {
		return selectedNumDays;
	}
	
	/*----------------------------------------------*/
	
	//Money methods
	
	public double costToSail(double days, PirateShips ship) {
		
		//Takes the chosen ship and the number of days they will be traveling and returns the total cost to sail
		//Uses the chosen ship to get the number of crew and how much they get payed
		//Checks if the ship needs to be repaired and adds that cost to the total cost if it does.
		//Returns the cost rounded to 2 decimal places.
		
		//Think the rounding is bugged
		
		double wage = ship.getCrewWage();
		int crew = ship.getCrewNum();
		
		double cost = wage * crew * days;
		
		if (ship.getShipHealth() != ship.getMaxShipHealth()) {
			cost = cost + ship.getRepairCosts();
		}
		
		
		return ((Math.round(100 * cost)) / 100);
	}
	
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	/*----------------------------------------------*/
	
	//Inventory methods
	
	
	public Hashtable<IslandMain.Buying, Integer> getInventoryDict()
	{
		return inventoryDict;
	}
	
	public void addToCurrentInventory(IslandMain.Buying item)
	{
		if (inventoryDict.get(item) == null)
		{
			inventoryDict.put(item, 1);
		}
		else
		{
			inventoryDict.replace(item, inventoryDict.get(item), inventoryDict.get(item)+1);
		}
	}
	
	public Set<IslandMain.Buying> getInventorySet()
	{
		Set<IslandMain.Buying> inventorySet = inventoryDict.keySet();
		return inventorySet;
	}
	
	public void delFromInventory(IslandMain.Buying item) {

		inventoryDict.replace(item, inventoryDict.get(item), inventoryDict.get(item)-1);
		if (inventoryDict.get(item) == 0)
		{
			inventoryDict.remove(item);
		}
			
	}
	
	public void resetCurrentInventory() {
		inventoryDict = new Hashtable<IslandMain.Buying, Integer>();
	}
	
	public void addToInventoryHistory(IslandMain.Buying item, String locationBrought) {
		
		//Adds to a list that stores the players all time inventory. This is used in the PurchasedGoodsScreen class. (Meets specification 2.2(3))
		//This is called when something is brought so placeholder values are used for the sold values.
		//There needs to be place holders so that the index values are the same.
		
		inventoryHistory.add(item.getItem());
		islandBroughtHistory.add(locationBrought);
		costBroughtHistory.add(item.getPrice());
		islandSoldHistory.add("Not sold yet!");
		costSoldHistory.add(0.00);
	}
	
	public void soldInventoryHistory(String item, String soldLocation, double soldPrice) {
		
		//Changes the values of the sold values to their actual values so they can be properly displayed.
		//Called once an item is sold
		boolean found = false;
		for (int i = 0 ; i < inventoryHistory.size() ; i++)
		{
			if (inventoryHistory.get(i) == item && islandSoldHistory.get(i) == "Not sold yet!" && found == false)
			{
				found = true;
				islandSoldHistory.set(i, soldLocation);
				costSoldHistory.set(i, soldPrice);
			}
		}

	}
	
	public ArrayList<String> getInventoryHistory(){
		return inventoryHistory;
	}
	
	public ArrayList<String> getIslandBroughtHistory(){
		return islandBroughtHistory;
	}
	
	public ArrayList<Double> getCostBroughtHistory(){
		return costBroughtHistory;
	}
	
	public ArrayList<String> getIslandSoldHistory(){
		return islandSoldHistory;
	}
	
	public ArrayList<Double> getCostSoldHistory(){
		return costSoldHistory;
	}
	
	/*----------------------------------------------*/
	

}
