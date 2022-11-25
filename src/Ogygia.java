

public class Ogygia extends IslandMain{
	
	/*private int distanceToIslaNublar = 6;
	private int distanceToAtlantis = 3;
	private int distanceToMadagascar = 4;
	private int distanceToOgygia = 0;
	private int distanceToJumanji = 5;*/
	
	public Ogygia(){
	
		setNameOfIsland("Ogygia");
		//setDistance(distanceToIslaNublar, distanceToAtlantis, distanceToMadagascar, distanceToOgygia, distanceToJumanji);
		
		Buying x = new Buying("Moonshine", 199.0, 156);
		addBuyItems(x);
		Buying y = new Buying("Watch", 500.00, 1);
		addBuyItems(y);
		Buying z = new Buying("Darren", 20, 20);
		addBuyItems(z);

		/*
		addSellItems("BasketBall", 2000);
		addSellItems("Lost Trident", 8999.99);
		*/
		setRoute("Ogygia", "IslaNublar", 300.00, 4);
		setRoute("Ogygia", "Atlantis", 200.00, 4);
		setRoute("Ogygia", "Madagascar", 300.00, 4);
		setRoute("Ogygia", "Jumanji", 400.00, 4);
		
		/*setRoute("Ogygia ---> Isla Nublar", 300.0);
		setRoute("Ogygia ---> Atlantis", 200.0);
		setRoute("Ogygia ---> Madagascar", 300.0);
		setRoute("Ogygia ---> Jumanji", 400.0);*/
	}
}
