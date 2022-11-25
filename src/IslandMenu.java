import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Set;

public class IslandMenu {
	
	//The menu with the 6 options

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/
	
	public IslandMenu(GameState incomingState) {
		state = incomingState;
		if(canTravel() | canSell() | canBuy())
		{
			initialize();
			frame.setVisible(true);
		}
		else
		{		
			state.launchEnding();
		}
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeIslandMenu(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 707);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		/*----------------------------------------------*/
		
		//All labels are defined before anything so that we can use the label.setVisible(false) function to show them when we want too
		
		
		JLabel lblNewLabel = new JLabel(String.valueOf(((double)Math.round(state.newPlayer.getBalance() * 100d)/100d)));
		lblNewLabel.setBounds(108, 20, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(String.valueOf(state.newPlayer.getNumDaysRemaining()));
		lblNewLabel_1.setBounds(155, 51, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(state.getCurrentIsland().getNameOfIsland());
		lblNewLabel_2.setBounds(322, 20, 99, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Not enough days remaining or insufficient funds to sail anywhere!");
		lblNewLabel_6.setBounds(318, 51, 280, 16);
		frame.getContentPane().add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
		JLabel lblNewLabel_7 = new JLabel("You don't have enough money to repair your ship");
		lblNewLabel_7.setBounds(332, 51, 310, 16);
		frame.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Yo bitch! What do you want to do?");
		lblNewLabel_3.setBounds(463, 17, 250, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Balance = $");
		lblNewLabel_4.setBounds(34, 20, 73, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Days remaining = ");
		lblNewLabel_5.setBounds(34, 51, 123, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		/*----------------------------------------------*/
		
		//Buttons
		
		JButton btnNewButton = new JButton("Map (Icon)"); //Goes to nothing currently
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchMap();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton.setBounds(877, 16, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_2 = new JButton("End game");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state.launchEndingConfirmation();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_2.setBounds(874, 64, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		
		JButton btnNewButton_1 = new JButton(); //View player
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state.launchPlayerScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_1.setBounds(322, 102, 291, 69);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		
		
		JButton btnNewButton_1_1 = new JButton(); //view your ship
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchPirateShipScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_1_1.setBounds(322, 278, 295, 75);
		frame.getContentPane().add(btnNewButton_1_1);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.setContentAreaFilled(false);
		
		
		JButton btnNewButton_1_2 = new JButton(); //View what you have purchased
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchPurchasedGoodsScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_1_2.setBounds(318, 183, 295, 76);
		frame.getContentPane().add(btnNewButton_1_2);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBorder(null);
		btnNewButton_1_2.setOpaque(false);
		btnNewButton_1_2.setContentAreaFilled(false);
		
		
		JButton btnNewButton_1_3 = new JButton(); //View the properties of each island
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchViewPropertiesIslands();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_1_3.setBounds(322, 466, 291, 72);
		frame.getContentPane().add(btnNewButton_1_3);
		btnNewButton_1_3.setBorderPainted(false);
		btnNewButton_1_3.setBorder(null);
		btnNewButton_1_3.setOpaque(false);
		btnNewButton_1_3.setContentAreaFilled(false);
		
		
		JButton btnNewButton_1_4 = new JButton(); //Visit the store
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchStoreScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_1_4.setBounds(322, 371, 291, 69);
		frame.getContentPane().add(btnNewButton_1_4);
		btnNewButton_1_4.setBorderPainted(false);
		btnNewButton_1_4.setBorder(null);
		btnNewButton_1_4.setOpaque(false);
		btnNewButton_1_4.setContentAreaFilled(false);
		
		JButton btnNewButton_1_5 = new JButton(); //Set sail
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (canTravel() == true) {
					
					state.launchSetSailScreen();
					closeWindow();
					finishedWindow();
				} else {
					lblNewLabel_6.setVisible(true);
				}
			}
		});
		btnNewButton_1_5.setBounds(322, 553, 291, 76);
		frame.getContentPane().add(btnNewButton_1_5);
		btnNewButton_1_5.setBorderPainted(false);
		btnNewButton_1_5.setBorder(null);
		btnNewButton_1_5.setOpaque(false);
		btnNewButton_1_5.setContentAreaFilled(false);
		
		JLabel lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setIcon(new ImageIcon(IslandMenu.class.getResource("/Images/SetSail.png")));
		lblNewLabel_8.setBounds(320, 550, 306, 79);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(IslandMenu.class.getResource("/Images/IslandProperties.png")));
		lblNewLabel_9.setBounds(318, 459, 305, 82);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(IslandMenu.class.getResource("/Images/VisitStore.png")));
		lblNewLabel_10.setBounds(318, 365, 325, 85);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(IslandMenu.class.getResource("/Images/ViewPurchases.png")));
		lblNewLabel_11.setBounds(317, 186, 337, 73);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(IslandMenu.class.getResource("/Images/ViewPlayer.png")));
		lblNewLabel_12.setBounds(315, 96, 338, 81);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(IslandMenu.class.getResource("/Images/ViewShip.png")));
		lblNewLabel_13.setBounds(320, 270, 322, 89);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(IslandMenu.class.getResource("/Images/Background.png")));
		lblNewLabel_14.setBounds(0, 0, 1003, 686);
		frame.getContentPane().add(lblNewLabel_14);
	}
	
	public boolean canTravel() {
		//Sees if the player can travel to any island based on days remaining and money
		//Variables are initialized and can be changed if any routes are added in game
		
		int minDistance = (int) state.currentIsland.shortestDistance(state.currentIsland);
		int minimumDays = (int) ((minDistance) / state.chosenShip.getShipSpeed());
	
		double minimumCostToSail = state.newPlayer.costToSail(minimumDays, state.chosenShip);
	
		if (minimumDays > state.newPlayer.getNumDaysRemaining()) {
			return false;
		}
		else if (minimumCostToSail > state.newPlayer.getBalance()) {
			return false;
		}
		if (state.chosenShip.getShipHealth() != state.chosenShip.getMaxShipHealth()){
			if (state.newPlayer.getBalance() - state.chosenShip.getRepairCosts() > state.newPlayer.getBalance()) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean canBuy()
	{
		ArrayList<IslandMain.Buying> buyItems = state.currentIsland.getBuyList();
		
		boolean possiblePurchase = false;
		
		for (IslandMain.Buying item : buyItems)
		{
			double costOfItem = item.getPrice(); 
			int spaceOfItem = item.getSpace();
			
			double prospectivePlayerBalance = state.newPlayer.getBalance() - costOfItem; 
			int prospectiveCargoSpace = state.chosenShip.getRemainingCargoCapacity() - spaceOfItem;
			
			if (prospectivePlayerBalance >= 0 && prospectiveCargoSpace >= 0){
				possiblePurchase = true;
			}
		}
		return possiblePurchase;
		
	}
	
	public boolean canSell()
	{
		ArrayList<IslandMain.Selling> sellItems = state.currentIsland.getSellList();
		Set<IslandMain.Buying> inventorySet = state.newPlayer.getInventorySet();
		
		boolean possibleSale = false;
		
		for (IslandMain.Selling item : sellItems)
		{
			String selectedItem = item.getItem();
			
			for (IslandMain.Buying invItem : inventorySet)
			{
				if (invItem.getItem() == selectedItem)
				{
					possibleSale = true;
				}
			}
		}
		return possibleSale;
	}
	
}
