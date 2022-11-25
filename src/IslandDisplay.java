
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Set;
import javax.swing.SwingConstants;
import java.awt.Font;

public class IslandDisplay {

	private JFrame frame;
	private GameState state;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	
	/*----------------------------------------------*/

	public IslandDisplay(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeIslandDisplay(this);
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
		
		JLabel lblNewLabel = new JLabel(state.infoIsland.nameOfIsland);
		lblNewLabel.setFont(new Font("Arial Hebrew Scholar", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(304, 21, 340, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("You're already on this island you silly goose!");
		lblNewLabel_5.setFont(new Font("Arial Hebrew Scholar", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(336, 177, 416, 43);
		frame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		
		/*----------------------------------------------*/
		
		//Tables
		
		table = new JTable(); //Same as the table defined in PurchasedGoodsScreen class
		
		//Table for what you can buy from the store on the selected island
		
		table.setModel(new DefaultTableModel(
	        new Object [][][] {
	            },
	            new String [] {
	                "Item","Price","Quantity"
	            }
	        ));
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowData[] = new Object[3];
		Set<IslandMain.Buying> buyingSet = state.infoIsland.getBuySet();
		for (IslandMain.Buying item : buyingSet)
		{
			rowData[0] = item.getItem();
			rowData[1] = item.getPrice();
			rowData[2] = state.infoIsland.getBuyDict().get(item);
			model.addRow(rowData);
		}

		
		table.setBounds(291, 327, 416, 100);
		frame.getContentPane().add(table);
		
		
		
		table_1 = new JTable();
		
		//Table to see what the store sells on the given island
		
		table_1.setModel(new DefaultTableModel(
		        new Object [][] {
		            },
		            new String [] {
		                "Item","Price"
		            }
		        ));
			
			DefaultTableModel model_1 = (DefaultTableModel) table_1.getModel();
			Object rowData_1[] = new Object[2];
			for (int i = 0; i < state.infoIsland.getSellList().size(); i ++) {
				rowData_1[0] = state.infoIsland.getSellList().get(i).getItem();
				rowData_1[1] = state.infoIsland.getSellList().get(i).getPrice();
				model_1.addRow(rowData_1);
			}
		table_1.setBounds(293, 509, 414, 90);
		frame.getContentPane().add(table_1);
		
		if (state.currentIsland != state.infoIsland) {
			
			//If the island you are getting information about is not the island you are currently on another table is created
			
			table_2 = new JTable();
			
			JLabel lblNewLabel_1_1 = new JLabel("Starting location");
			lblNewLabel_1_1.setBounds(384, 109, 117, 16);
			frame.getContentPane().add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("Distance (Km)");
			lblNewLabel_1_2.setBounds(498, 109, 100, 16);
			frame.getContentPane().add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_3 = new JLabel("Danger level");
			lblNewLabel_1_3.setBounds(610, 109, 117, 16);
			frame.getContentPane().add(lblNewLabel_1_3);
			
			JLabel lblNewLabel_111 = new JLabel("Destination");
			lblNewLabel_111.setBounds(294, 109, 79, 16);
			frame.getContentPane().add(lblNewLabel_111);
			
			JLabel lblNewLabel_8_2 = new JLabel("");
			lblNewLabel_8_2.setOpaque(true);
			lblNewLabel_8_2.setBackground(Color.WHITE);
			lblNewLabel_8_2.setBounds(291, 92, 416, 43);
			frame.getContentPane().add(lblNewLabel_8_2);
			
			//Table to display the possible routes from the current island to the destination
			
			table_2.setModel(new DefaultTableModel(
					
			        new Object [][] {
			            },
			            new String [] {
			                "Starting Island","Destination","Distance","Danger"
			            }
			        ));
				
				DefaultTableModel model_2 = (DefaultTableModel) table_2.getModel();
				Object rowData_2[] = new Object[4];
				for (int i = 0; i < state.infoIsland.getRoutesList().size(); i ++) {
					if (state.infoIsland.getRoutesList().get(i).getDestination() == state.currentIsland.getNameOfIsland()) {
						rowData_2[0] = state.infoIsland.getRoutesList().get(i).getDestination();
						rowData_2[1] = state.infoIsland.getRoutesList().get(i).getStart();
						rowData_2[2] = state.infoIsland.getRoutesList().get(i).getDistance();
						rowData_2[3] = state.infoIsland.getRoutesList().get(i).getDanger();
						model_2.addRow(rowData_2);
					}
				}
			table_2.setBounds(291, 168, 416, 43);
			frame.getContentPane().add(table_2);
			
		}else {
			lblNewLabel_5.setVisible(true);
		}
		
		/*----------------------------------------------*/
		
		//Buttons
	
		JButton btnNewButton = new JButton("<--- Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchViewPropertiesIslands();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_23 = new JLabel("Items to buy");
		lblNewLabel_23.setBounds(304, 281, 101, 16);
		frame.getContentPane().add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Item to sell");
		lblNewLabel_24.setBounds(344, 455, 101, 16);
		frame.getContentPane().add(lblNewLabel_24);
		
		JLabel lblNewLabel_55 = new JLabel("Price");
		lblNewLabel_55.setBounds(573, 455, 61, 16);
		frame.getContentPane().add(lblNewLabel_55);
		
		JLabel lblNewLabel_6 = new JLabel("Price");
		lblNewLabel_6.setBounds(459, 281, 61, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Stock avaliable");
		lblNewLabel_7.setBounds(573, 281, 134, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBackground(Color.WHITE);
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBounds(291, 268, 416, 43);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setOpaque(true);
		lblNewLabel_8_1.setBounds(293, 439, 416, 43);
		lblNewLabel_8_1.setBackground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel_8_1);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/Images/Background.png")));
		lblNewLabel_1.setBounds(0, 0, 1018, 685);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
