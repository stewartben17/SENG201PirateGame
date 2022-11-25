

public class Atlantis extends IslandMain{
	
	/*private int distanceToIslaNublar = 2;
	private int distanceToAtlantis = 0;
	private int distanceToMadagascar = 2;
	private int distanceToOgygia = 3;
	private int distanceToJumanji = 7;*/
	
	public Atlantis(){
	
		setNameOfIsland("Atlantis");
		
		Buying x = new Buying("Lost Trident", 58.99, 12);
		Buying y = new Buying("Map", 22.0, 2);
		Buying z = new Buying("Ship upgrade", 100, 402);
		addBuyItems(x);
		addBuyItems(y);
		addBuyItems(z);

		/*
		addSellItems("Captain Jack Sparrows EyePatch", 270.0);
		addSellItems("Ben's muddy boots", 49.99);
		*/
		setRoute("Atlantis", "IslaNublar", 100.00, 5);
		setRoute("Atlantis", "Madagascar", 200.00, 5);
		setRoute("Atlantis", "Ogygia", 200.00, 4);
		setRoute("Atlantis", "Ogygia", 700.00, 4);
		setRoute("Atlantis", "Jumanji", 700.0, 3);
		/*setRoute("Atlantis ---> Isla Nublar", 100.0);
		setRoute("Atlantis ---> Madagascar", 200.0);
		setRoute("Atlantis ---> Ogygia", 200.0);
		setRoute("Atlantis ---> Jumanji", 700.0);*/
	}
}