import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;


public class BuyingScreen {

	private JFrame frame;
	private GameState state;
	private JTable table;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	/*----------------------------------------------*/

	public BuyingScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeBuyingScreen(this);
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
		
		//Labels
		
		lblNewLabel_3 = new JLabel("Please select an item to purchase");
		lblNewLabel_3.setBounds(404, 502, 238, 16);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		lblNewLabel_2 = new JLabel("Successful purchase!");
		lblNewLabel_2.setBounds(423, 502, 175, 16);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		lblNewLabel_1 = new JLabel("Unable to purchase this item, please check your cargo capacity and your player balance");
		lblNewLabel_1.setBounds(250, 600, 550, 16);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("What you can buy");
		lblNewLabel.setBounds(464, 226, 147, 16);
		frame.getContentPane().add(lblNewLabel);
		
		/*----------------------------------------------*/
		
		//Tables
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
		        new Object [][][] {
		            },
		            new String [] {
		                "Item","Price","Quantity"
		            }
		        ));
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object rowData[] = new Object[3];
			Set<IslandMain.Buying> buyingSet = state.currentIsland.getBuySet();
			for (IslandMain.Buying item : buyingSet)
			{
				rowData[0] = item.getItem();
				rowData[1] = item.getPrice();
				rowData[2] = state.currentIsland.getBuyDict().get(item);
				model.addRow(rowData);
			}
		table.setBounds(296, 279, 477, 161);
		frame.getContentPane().add(table);
		
		/*----------------------------------------------*/
		
		//Buttons
		
		btnNewButton_1 = new JButton("Buy");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int row_1 = table.getSelectedRow(); //Gets the row that the player selected
					IslandMain.Buying key = state.currentIsland.getBuyList().get(row_1);
					String selectedItem = key.getItem(); //Uses the row variable to get the item the player wants to buy
					double costOfItem = key.getPrice(); //Gets the cost of the item using the row variable
					int spaceOfItem = key.getSpace();
					
					double prospectivePlayerBalance = state.newPlayer.getBalance() - costOfItem; //Sees what the balance would be if it was purchased
					int prospectiveCargoSpace = state.chosenShip.getCurrentCargo() + spaceOfItem;
					
					if (prospectivePlayerBalance >= 0 && prospectiveCargoSpace <= state.chosenShip.getCargoCapacity()){
						
						//Could create a new function within this class that checks if the item can be brought
						//It would check the players balance and the ships cargo space
						
						//The player can buy if it gets to this point
						lblNewLabel_1.setVisible(false);
						lblNewLabel_2.setVisible(true);
						
						if (selectedItem == "Ship upgrade") { //Change this later to individual upgrades
							//EG you could buy more ship health from a certain island
							state.chosenShip.setUpgradeLevel(state.chosenShip.getUpgradeLevel() + 1);
						}
						state.newPlayer.setBalance(prospectivePlayerBalance);
						state.newPlayer.addToInventoryHistory(key, state.currentIsland.getNameOfIsland());
						state.newPlayer.addToCurrentInventory(key);
						state.chosenShip.setRemainingCargo(state.chosenShip.getCurrentCargo() + spaceOfItem);
						state.currentIsland.delBuyItem(key);
						state.launchBuyingScreen();
						closeWindow();
						finishedWindow();

						
					}else {
						lblNewLabel_2.setVisible(false);
						lblNewLabel_1.setVisible(true);
					}
				
				}
				catch(IndexOutOfBoundsException f)
				{
					lblNewLabel_3.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(478, 452, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
		btnNewButton_2 = new JButton("<--- Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchStoreScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_2.setBounds(6, 1, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Arial Hebrew Scholar", Font.PLAIN, 15));
		lblNewLabel_1.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/Images/Background.png")));
		lblNewLabel_1.setBounds(0, 0, 1018, 685);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
