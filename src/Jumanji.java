
public class Jumanji extends IslandMain{
	//Scary
	/*private int distanceToIslaNublar = 5;
	private int distanceToAtlantis = 7;
	private int distanceToMadagascar = 3;
	private int distanceToOgygia = 5;
	private int distanceToJumanji = 0;*/
	
	public Jumanji(){
	
		setNameOfIsland("Jumanji");
		//setDistance(distanceToIslaNublar, distanceToAtlantis, distanceToMadagascar, distanceToOgygia, distanceToJumanji);
		
		Buying x = new Buying("Scary artifact" , 1200.0, 400);
		addBuyItems(x);
		Buying y = new Buying("Basketball", 12.0, 32);
		addBuyItems(y);
		
		
		addSellItems("Darren", 100000);
		

		/*
		addSellItems("Ben's muddy boots", 5000.0);
		addSellItems("Meat", 1000.0);
		*/
		setRoute("Jumanji", "IslaNublar", 500.00, 1);
		setRoute("Jumanji", "IslaNublar", 700.00, 4);
		setRoute("Jumanji", "Atlantis", 700.00, 4);
		setRoute("Jumanji", "Madagascar", 300.00, 4);
		setRoute("Jumanji", "Ogygia", 400.00, 4);
		
		/*setRoute("Jumanji ---> Isla Nublar (Dangerous)", 500.0);
		setRoute("Jumanji ---> Isla Nublar (Safe)", 700.0);
		setRoute("Jumanji ---> Atlantis", 700.0);
		setRoute("Jumanji ---> Madagascar", 300.0);
		setRoute("Jumanji ---> Ogygia", 400.0);*/
	}
}