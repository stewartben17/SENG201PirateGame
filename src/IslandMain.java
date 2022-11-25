import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class IslandMain {
	
	//private ArrayList<String> storeBuyItems = new ArrayList<String>();
	//private ArrayList<Double> storeBuyPrices = new ArrayList<Double>();
	//private ArrayList<String> storeSellItems = new ArrayList<String>();
	//private ArrayList<Double> storeSellPrices = new ArrayList<Double>();
	
	/*private ArrayList<String> routes = new ArrayList<String>();
	private ArrayList<Double> routeDistance = new ArrayList<Double>();*/
	
	public String nameOfIsland;
	
	private ArrayList<Selling> sellList = new ArrayList<Selling>(); //ArrayList of type Selling class, which is defined below
	private Hashtable<Buying, Integer> buyDict = new Hashtable<Buying, Integer>();
	
	private ArrayList<Routes> routesList = new ArrayList<Routes>();
	
	/*----------------------------------------------*/
	
	//Classes
	
	public class Buying{
		
		//Keeps the item and price in the same index, makes it simple for configuring JTables.
		
		private String item;
		private double price;
		private int space;
		
		public Buying(String item, double price, int space) {
			this.item = item;
			this.price = price;
			this.space = space;
		}
		
		public String getItem() {
			return item;
		}
		
		public double getPrice() {
			return price;
		}
		
		public int getSpace()
		{
			return space;
		}
	}
	
	
	public class Selling{
		private String item;
		private double price;
		
		public Selling(String item, double price) {
			this.item = item;
			this.price = price;
		}
		
		public String getItem() {
			return item;
		}
		
		public double getPrice() {
			return price;
		}
	}
	
	public class Routes{
		
		//Keeps all information about a given route in a single index. 
		
		private String startingPoint;
		private String destination;
		private double distance;
		private int danger; //1 No danger, 5 lots of danger
		
		public Routes(String start, String end, double distance, int danger) {
			this.startingPoint = start;
			this.destination = end;
			this.distance = distance;
			this.danger = danger;
		}
		
		public String getStart() {
			return startingPoint;
		}
		
		public String getDestination() {
			return destination;
		}
		
		public double getDistance() {
			return distance;
		}
		
		public int getDanger() {
			return danger;
		}
	}
	
	/*----------------------------------------------*/
	
	public void setNameOfIsland(String tempName) {
		this.nameOfIsland = tempName;
	}
	
	public String getNameOfIsland() {
		return nameOfIsland;
	}	
	
	public void addBuyItems(Buying item) {
		
		//Takes the item and price, creates a new instance of the Buying class (x) and then adds it to an arrayList of type Buying.
		
		if (buyDict.get(item) == null)
		{
			buyDict.put(item, 1);
		}
		else
		{
			buyDict.replace(item, buyDict.get(item), buyDict.get(item)+1);
		}
	}
	
	public Set<Buying> getBuySet()
	{
		Set<Buying> buySet = buyDict.keySet();
		return buySet;
	}
	
	public ArrayList<Buying> getBuyList(){
		ArrayList<Buying> buyList = new ArrayList<Buying>();
		Set<Buying> buySet = buyDict.keySet();
		for (Buying item : buySet)
		{
			buyList.add(item);
		}
		return buyList;
	}
 	
	public void delBuyItem(Buying item)
	{
		buyDict.replace(item, buyDict.get(item), buyDict.get(item)-1);
		if (buyDict.get(item) == 0)
		{
			buyDict.remove(item);
		}
		
	}
	
	public Hashtable<Buying, Integer> getBuyDict()
	{
		return buyDict;
	}
	
	public void addSellItems(String item, double price) {
		Selling x = new Selling(item, price);
		sellList.add(x);
	}
	
	
	public ArrayList<Selling> getSellList(){
		return sellList;
	}
	
	public void setRoute(String start, String end, double distance, int danger) {
		Routes x = new Routes(start, end, distance, danger);
		routesList.add(x);
	}
	
	public ArrayList<Routes> getRoutesList(){
		return routesList;
	}
	
	public int daysToDestination(double distance, int speed) {
		
		//Takes the distance and ship speed and returns the result as an integer
		
		return (int) (distance / speed);
	}
	
	
	public double shortestRoute(IslandMain current, IslandMain destination) {
		
		//Finds the shortest  distance from the current island TO THE DESIRED ISLAND and returns it
		//Uses a for loop to get all the routes from the current island
		//Sees if the route at the given index (i) goes to the destination, if it doesn't then nothing happens
		//If it does then we see if this is the first time it's happened, if it is then its automatically the shortest distance so far
		//If it's not then the distance of that route is compared with the shortest distance so far, if its shorter then the shortest variable is changed
		//the shortest value is returned after all of the routes have been checked
		
		//This function is used inside the picking routes class. 
		
		double shortest = -1;
		for (int i = 0; i < current.getRoutesList().size(); i ++){
			if (current.getRoutesList().get(i).getDestination() == destination.getNameOfIsland()) {
				if (shortest == -1) {
					shortest = current.getRoutesList().get(i).getDistance();
				} else {
					if (current.getRoutesList().get(i).getDistance() < shortest) {
						shortest = current.getRoutesList().get(i).getDistance();
					}
				}
			}
		}
		return shortest;
	}
	
	public double shortestDistance(IslandMain island) {
		
		//Finds the shortest distance from a given island to ANY island
		//Same principle as above, however we don't need to see if the given route goes to a certain destination
		
		//This one is used in the setSail class
		
		double shortest = 0;
		for (int i = 0; i < island.getRoutesList().size(); i++) {
			if (i == 0) {
				shortest = island.getRoutesList().get(i).getDistance();
			}else {
				if (island.getRoutesList().get(i).getDistance() < shortest) {
					shortest = island.getRoutesList().get(i).getDistance();
				}
			}
		}
		return shortest;
	}
	
	
	
	/*public ArrayList<String> getStoreBuyItems() {
		return storeBuyItems;
	}
	
	public ArrayList<Double> getStoreBuyPrices(){
		return storeBuyPrices;
	}*/
	
		
	/*public ArrayList<String> getStoreSellItems(){
		return storeSellItems;
	}
	
	public ArrayList<Double> getStoreSellPrices(){
		return storeSellPrices;
	}*/
	
	/*public void setDistance(int distA, int distB, int distC, int distD, int distE) {
		this.distanceToA = distA;
		this.distanceToB = distB;
		this.distanceToC = distC;
		this.distanceToD = distD;
		this.distanceToE = distE;
	}
	
	public int getDistanceToA() {
		return distanceToA;
	}
	
	public int getDistanceToB() {
		return distanceToB;
	}
	
	public int getDistanceToC() {
		return distanceToC;
	}
	
	public int getDistanceToD() {
		return distanceToD;
	}
	
	public int getDistanceToE() {
		return distanceToE;
	}*/
	
	/*public void setStoreBuying(String item, double price) {
		storeBuyItems.add(item);
		storeBuyPrices.add(price);
	}
	
	public void setStoreSelling(String item, double price) {
		storeSellItems.add(item);
		storeSellPrices.add(price);
	}*/
	
	/*public void setRoute(String routeDescription, double tempDistance) {
		routes.add(routeDescription);
		routeDistance.add(tempDistance);
	} */
	
	/*public String getBuyItems()
	{
		
		int counterBuy = 0;
		
		String returnString = "\n\nItem's you can buy from this island\n";
		
		for (String x : storeBuyItems) {
			returnString = returnString + ("\n" + "Item: " + x + " | Price: " + getStoreBuyPrices().get(counterBuy));
			counterBuy ++;
		}
		return returnString;
	}
	
	public String getSaleItems()
	{
		int counterSell = 0;
		String returnString = "\n\nItem's you can sell to this island\n";
		
		for (String y : storeSellItems) {
			returnString = returnString + ("\n" + "Item: " + y + " | Price: $" + getStoreSellPrices().get(counterSell));
			counterSell ++;
		}
		return returnString;
		
	}*/
	
	/*public ArrayList<String> getRoutes(){
		return routes;
	}
	
	public ArrayList<Double> getRouteDistance(){
		return routeDistance;
	}*/
	
	
	/*public String toString() {
		String returnString = "Name of Island: ";
		returnString = returnString + getNameOfIsland();
		
		returnString += getBuyItems();
		
		returnString += getSaleItems();
		
		int counterRoute = 0;
		returnString = returnString + "\n\nPossible routes to take from this island\n";
		
		for (String z : routes) {
			int daysRequired = (int) (getRouteDistance().get(counterRoute)/shipSpeed/24);
			if (daysRequired == 0) {
				daysRequired = 1;
			}
			returnString = returnString + ("\nRoute " + (counterRoute + 1) + ") " + z + ", days to get to the new island: " + daysRequired);
			counterRoute ++;
		}
		
		returnString = returnString + "\n--------------------------------------------------------------------------";
		return "\n--------------------------------------------------------------------------\n" + returnString;
	}*/

	public static void main(String[] args) {
		
		//Testing
		
		IslaNublar islaNublar = new IslaNublar();
		Atlantis atlantis = new Atlantis();
		Madagascar madagascar = new Madagascar();
		Ogygia ogygia = new Ogygia();
		Jumanji jumanji = new Jumanji();
		
		System.out.println(islaNublar);
		System.out.println(atlantis);
		System.out.println(madagascar);
		System.out.println(ogygia);
		System.out.println(jumanji);
	}

}
