import java.util.Random;

public class GameState {
	
	//Initializing all the classes and necessary variables

	Player newPlayer = new Player();
	
	IslandMain islaNublar = new IslaNublar();
	IslandMain atlantis = new Atlantis();
	IslandMain madagascar = new Madagascar();
	IslandMain ogygia = new Ogygia();
	IslandMain jumanji = new Jumanji();
	
	PirateShips titanic = new Titanic();
	PirateShips blackPearl = new BlackPearl();
	PirateShips argo = new Argo();
	PirateShips jollyRoger = new JollyRoger();
	
	PirateShips chosenShip;
	IslandMain homeIsland;
	IslandMain currentIsland;
	IslandMain infoIsland;
	IslandMain travellingIsland;
	
	
	/*----------------------------------------------*/
	
	//Getter and setter methods to allow any class that inherits the state variable to access and change the key variables.
	
	public PirateShips getChosenShip() {
		return chosenShip;
	}
	
	public void setChosenShip(PirateShips ship) {
		chosenShip = ship;
	}
	
	public IslandMain getChosenIsland() {
		return homeIsland;
	}
	
	public void setChosenIsland(IslandMain island) {
		homeIsland = island;
	}
	
	public IslandMain getCurrentIsland() {
		return currentIsland;
	}
	
	public void setCurrentIsland(IslandMain islandWeAreAt) {
		currentIsland = islandWeAreAt;
		}
	
	public IslandMain getInfoIsland(){
		return infoIsland;
	}
	
	public void setInfoIsland(IslandMain island) {
		infoIsland = island;
	}
	
	/*----------------------------------------------*/
	
	//Launching and closing functions
	//All classes that inherit the state variable can open and close windows
	
	public void launchInitialScreen() {
		InitialScreen initialScreen = new InitialScreen(this);
	}
	
	public void closeInitialScreen(InitialScreen initialScreen) {
		initialScreen.closeWindow();
	}
	
	public void launchChooseNameScreen() {
		ChooseNameScreen chosenNameScreen = new ChooseNameScreen(this);
	}
	
	public void closeChooseNameScreen(ChooseNameScreen nameWindow) {
		nameWindow.closeWindow();
	}
	
	public void launchChooseGameLengthScreen() {
		ChooseGameLengthScreen chosenGameLength = new ChooseGameLengthScreen(this);
	}
	
	public void closeChooseGameLengthScreen(ChooseGameLengthScreen nameWindow) {
		nameWindow.closeWindow();
	}
	
	public void launchChooseShipScreen() {
		ChooseShipScreen chosenNameScreen = new ChooseShipScreen(this);
	}
	
	public void closeChooseShipScreen(ChooseShipScreen nameWindow) {
		nameWindow.closeWindow();
	}
	
	public void launchChooseIslandScreen() {
		ChooseIslandScreen chosenNameScreen = new ChooseIslandScreen(this);
	}
	
	public void closeChooseIslandScreen(ChooseIslandScreen nameWindow) {
		nameWindow.closeWindow();
	}
	
	public void launchViewShipScreen()
	{
		ViewShipScreen viewShipScreen = new ViewShipScreen(this);
	}
	
	public void closeViewShipScreen(ViewShipScreen nameWindow)
	{
		nameWindow.closeWindow();
	}
	
	public void launchViewIslandScreen()
	{
		ViewIslandScreen viewShipScreen = new ViewIslandScreen(this);
	}
	
	public void closeViewIslandScreen(ViewIslandScreen nameWindow)
	{
		nameWindow.closeWindow();
	}
	
	public void launchIslandMenu() {
		IslandMenu islandMenuScreen = new IslandMenu(this);
	}
	
	public void closeIslandMenu(IslandMenu islandMenuScreen) {
		islandMenuScreen.closeWindow();
	}
	
	public void launchPlayerScreen() {
		PlayerWindow playerScreen = new PlayerWindow(this);
	}
	
	public void closePlayerWindow(PlayerWindow playerScreen) {
		playerScreen.closeWindow();
	}
	
	public void launchPirateShipScreen() {
		PirateShipScreen pirateShipWindow = new PirateShipScreen(this);
	}
	
	public void closePirateShipScreen(PirateShipScreen pirateShipWindow) {
		pirateShipWindow.closeWindow();
	}
	
	public void launchPurchasedGoodsScreen() {
		PurchasedGoodsScreen purchasedGoodsScreen = new PurchasedGoodsScreen(this);
	}
	
	public void closePurchasedGoodsScreen(PurchasedGoodsScreen purchasedGoodsScreen) {
		purchasedGoodsScreen.closeWindow();
	}
	
	public void launchViewPropertiesIslands() {
		ViewPropertiesIslands viewPropertiesIslands = new ViewPropertiesIslands(this);
	}
	
	public void closeViewPropertiesIslands(ViewPropertiesIslands viewPropertiesIslands) {
		viewPropertiesIslands.closeWindow();
	}
	
	public void launchIslandDisplay() {
		IslandDisplay islandDisplay = new IslandDisplay(this);
	}
	
	public void closeIslandDisplay(IslandDisplay islandDisplay) {
		islandDisplay.closeWindow();
	}
	
	public void launchStoreScreen() {
		StoreScreen storeScreen = new StoreScreen(this);
	}
	
	public void closeStoreScreen(StoreScreen storeScreen) {
		storeScreen.closeWindow();
	}
	
	public void launchBuyingScreen() {
		BuyingScreen buyingScreen = new BuyingScreen(this);
	}
	
	public void closeBuyingScreen(BuyingScreen buyingScreen) {
		buyingScreen.closeWindow();
	}
	
	public void launchSellingScreen() {
		SellingScreen sellingScreen = new SellingScreen(this);
	}
	
	public void closeSellingScreen(SellingScreen sellingScreen) {
		sellingScreen.closeWindow();
	}
	
	public void launchSetSailScreen() {
		SetSailScreen setSailScreen = new SetSailScreen(this);
	}
	
	public void closeSetSailScreen(SetSailScreen setSailScreen) {
		setSailScreen.closeWindow();
	}
	
	public void launchPickingRoutesScreen() {
		PickingRoutesScreen pickingRoutesScreen = new PickingRoutesScreen(this);
	}
	
	public void closePickingRoutesScreen(PickingRoutesScreen pickingRoutesScreen) {
		pickingRoutesScreen.closeWindow();
	}
	
	public void launchEndingConfirmation() {
		EndingConfirmation endingConfirmation = new EndingConfirmation(this);
	}
	
	public void closeEndingConfirmation(EndingConfirmation endingConfirmation) {
		endingConfirmation.closeWindow();
	}
	
	public void launchEnding() {
		Ending ending = new Ending(this);
	}
	
	public void closeEnding(Ending ending) {
		ending.closeWindow();
	}
	
	public void launchMap() {
		Map map = new Map(this);
	}
	
	public void closeMap(Map map) {
		map.closeWindow();
	}
	/*----------------------------------------------*/
	
	public void reset() {
		newPlayer = new Player();
	
		titanic = new Titanic();
		blackPearl = new BlackPearl();
		argo = new Argo();
		jollyRoger = new JollyRoger();
		
		islaNublar = new IslaNublar();
		atlantis = new Atlantis();
		madagascar = new Madagascar();
		ogygia = new Ogygia();
		jumanji = new Jumanji();
	}
	
	public int randomEvents(int outOf) {
		Random rand = new Random();
		return rand.nextInt(outOf);
	}
	
	public int randomSailors() {
		int status = 0;
		if (randomEvents(10) == 0) {
			System.out.println("Sailors rescued");
			newPlayer.setBalance(newPlayer.getBalance() + 2000);
			status = 1;
		}
		return status;
	}
	
	public int randomWeather(int danger) {
		//Makes the ship take a random amount of damage from 0-80 hit points
		int status = 0;
		if (randomEvents(danger) == 0) {
			System.out.println("Ship damaged from weather");
			chosenShip.setShipHealth(chosenShip.getMaxShipHealth() - randomEvents(80) + 1);
			
			System.out.println(chosenShip.getShipHealth());
			System.out.println(chosenShip.getRepairCosts());
			status = 1;
		}
		return status;
		
		
	}
	
	public int pirateNumberGame() {
		int status = 0;
		int chance = 2 * chosenShip.getUpgradeLevel();
		int random = randomEvents(chance);
		chosenShip.setCaptainDiceRoll(random);
		
		if (random == 0) { //Pirates win
			if (newPlayer.getInventorySet().size() >= 2){ //Pirates win and take the inventory
				newPlayer.resetCurrentInventory();
				status = 2;
				
			} else { //Pirates kill you
				newPlayer.setBalance(0);
				status = 1;
			}
		} else { //You win pirates leave
			status = 4;
		}
		return status;
	}
	
	public int randomPirates(int number) {
		
		int random = randomEvents(number);
		int status = 0;
		if (random == 0) {
			System.out.println("Pirates attack");
			status = pirateNumberGame();
		} else {
			System.out.println("Nothing");
			System.out.println(random);
		}
		
		return status;
	}
	
	//The main function starts the game by launching the first window
	//Other windows are then opened by calling the above methods from different classes
	
	public static void main(String[] args) {
		GameState state = new GameState();
		state.launchInitialScreen();
	}
}

