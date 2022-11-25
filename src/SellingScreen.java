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

public class SellingScreen {

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/

	public SellingScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeSellingScreen(this);
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
		
		JLabel lblNewLabel = new JLabel("What you can sell");
		lblNewLabel.setFont(new Font("Arial Hebrew Scholar", Font.PLAIN, 15));
		lblNewLabel.setBounds(437, 242, 163, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please select an item to sell");
		lblNewLabel_1.setBounds(415, 454, 200, 29);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Item succesfully sold");
		lblNewLabel_2.setBounds(437, 454, 150, 29);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("You do not own this item");
		lblNewLabel_3.setBounds(415, 454, 211, 29);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		/*----------------------------------------------*/
		
		//Tables
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
		        new Object [][] {
		            },
		            new String [] {
		                "Item","Price"
		            }
		        ));
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object rowData[] = new Object[2];
			for (int i = 0; i < state.currentIsland.getSellList().size(); i ++) {
				rowData[0] = state.currentIsland.getSellList().get(i).getItem();
				rowData[1] = state.currentIsland.getSellList().get(i).getPrice();
				model.addRow(rowData);
			}
		table.setBounds(268, 283, 477, 161);
		frame.getContentPane().add(table);
		
		/*----------------------------------------------*/
		
		//Buttons
		
		JButton btnNewButton_1 = new JButton("Sell");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int row_1 = table.getSelectedRow();
					IslandMain.Selling key = state.currentIsland.getSellList().get(row_1);
					String selectedItem = key.getItem();
					double costOfItem = key.getPrice();
					
					//Hiding both messages for possible sales
					lblNewLabel_2.setVisible(false);
					lblNewLabel_3.setVisible(false);
					
					//Making sure the player actually has the item they are trying to sell
					boolean found = false;
					IslandMain.Buying buyKey = null;
					Set<IslandMain.Buying> inventorySet = state.newPlayer.getInventorySet();
					
					for (IslandMain.Buying item : inventorySet)
					{
						if (item.getItem() == selectedItem)
						{
							buyKey = item;
							found = true;
						}
					}
					if (found == true) {
						state.newPlayer.delFromInventory(buyKey); 
						state.chosenShip.setRemainingCargo(state.chosenShip.getCurrentCargo() - buyKey.getSpace());
						state.newPlayer.soldInventoryHistory(selectedItem, state.currentIsland.getNameOfIsland(), costOfItem); //Updates the historical inventory
						state.newPlayer.setBalance(state.newPlayer.getBalance() + costOfItem);
						lblNewLabel_2.setVisible(true);
					}
					else
					{
						lblNewLabel_3.setVisible(true);
					}
				}
				catch (IndexOutOfBoundsException f)
				{
					lblNewLabel_1.setVisible(true);
				}
				
			}
		});
		btnNewButton_1.setBounds(453, 495, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("<--- Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchStoreScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton.setBounds(6, 16, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/Images/Background.png")));
		lblNewLabel_21.setBounds(0, 0, 1018, 685);
		frame.getContentPane().add(lblNewLabel_21);
		
	}
	
	

}
