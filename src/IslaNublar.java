

public class IslaNublar extends IslandMain{
	
	/*private int distanceToIslaNublar = 0;
	private int distanceToAtlantis = 2;
	private int distanceToMadagascar = 3;
	private int distanceToOgygia = 6;
	private int distanceToJumanji = 5;*/
	
	public IslaNublar(){
	
		setNameOfIsland("IslaNublar");
		//setDistance(distanceToIslaNublar, distanceToAtlantis, distanceToMadagascar, distanceToOgygia, distanceToJumanji);
		Buying x = new Buying("Captain Jack Sparrow", 99.0, 4);
		addBuyItems(x);
		addBuyItems(x);
		Buying y = new Buying("Cody's water bottle", 12.0, 3);
		addBuyItems(y);


		addSellItems("Captain Jack Sparrow", 1001.00);
		addSellItems("Map", 270.0);

		
		setRoute("IslaNublar", "Atlantis", 100.0, 5);
		setRoute("IslaNublar", "Madagascar", 150.0, 5);
		setRoute("IslaNublar", "Ogygia", 300.00, 4);
		setRoute("IslaNublar", "Jumanji", 500.00, 1);
		setRoute("IslaNublar", "Jumanji", 700.00, 2);
		
		/*setRoute("IslaNublar ---> Atlantis", 100.0);
		setRoute("IslaNublar ---> Madagascar", 150.0);
		setRoute("IslaNublar ---> Ogygia", 300.0);
		setRoute("IslaNublar ---> Jumanji (Dangerous)", 500.0);
		setRoute("IslaNublar ---> Jumanji (Safe)", 700.0);*/
	}
}