

public class Madagascar extends IslandMain{
	
	/*private int distanceToIslaNublar = 3;
	private int distanceToAtlantis = 2;
	private int distanceToMadagascar = 0;
	private int distanceToOgygia = 4;
	private int distanceToJumanji = 3;*/
	
	public Madagascar(){
	
		setNameOfIsland("Madagascar");
		//setDistance(distanceToIslaNublar, distanceToAtlantis, distanceToMadagascar, distanceToOgygia, distanceToJumanji);
		
		Buying x = new Buying("Meat", 52.0, 7);
		addBuyItems(x);
		Buying y = new Buying("Zebra stripes", 82.0, 12);
		addBuyItems(y);
		/*
		addSellItems("Moonshine", 500);
		addSellItems("Watch", 1000);
		addSellItems("Cody's water bottle", 5000);
		*/
		setRoute("Madagascar", "IslaNublar", 100.00, 5);
		setRoute("Madagascar", "Atlantis", 200.00, 5);
		setRoute("Madagascar", "Ogygia", 300.00, 4);
		setRoute("Madagascar", "Jumanji", 300.00, 4);
		
	
		/*setRoute("Madagascar ---> Isla Nublar", 100.0); //Distance in Km
		setRoute("Madagascar ---> Atlantis", 200.0);
		setRoute("Madagascar ---> Ogygia", 300.0);
		setRoute("Madagascar ---> Jumanji", 300.0);*/
	}
}
