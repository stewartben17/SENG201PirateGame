

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;

public class PurchasedGoodsScreen {

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/

	public PurchasedGoodsScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closePurchasedGoodsScreen(this);
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
		
		JLabel lblNewLabel = new JLabel("Item");
		lblNewLabel.setBounds(375, 85, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Island brought from");
		lblNewLabel_1.setBounds(375, 136, 126, 16);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Island Sold too");
		lblNewLabel_2.setBounds(375, 264, 126, 16);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Price brought for");
		lblNewLabel_3.setBounds(375, 198, 106, 16);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("Price sold for");
		lblNewLabel_4.setBounds(375, 326, 83, 16);
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		JLabel lblNewLabel_5 = new JLabel("Profit");
		lblNewLabel_5.setBounds(375, 396, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(574, 85, 157, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(574, 136, 185, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(574, 198, 197, 16);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(574, 264, 203, 16);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBounds(574, 326, 142, 16);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setBounds(574, 396, 157, 16);
		frame.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_7 = new JLabel("Please select an item");
		lblNewLabel_7.setBounds(158, 490, 200, 29);
		frame.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		
		/*----------------------------------------------*/
		
		//Tables
		
		JTable table_1 = new JTable(); //Creates a new table
		table_1.setModel(new DefaultTableModel(
				
				//Sets a model for the table
				
		        new Object [][] {
		            },
		            new String [] {
		                "Item" //This is the header of the table, for each column write the header here
		            }
		        ));
			
			DefaultTableModel model_1 = (DefaultTableModel) table_1.getModel(); //Sets the table to the chosen model we created
			Object rowData_1[] = new Object[1]; //Shows how many columns we want in the table
			for (int i = 0; i < state.newPlayer.getInventoryHistory().size(); i ++) {
				
				//Adding data to the rows
				//Adds all the data in the all time inventory
				
				rowData_1[0] = state.newPlayer.getInventoryHistory().get(i);
				model_1.addRow(rowData_1);
			}
        
		table_1.setBounds(113, 63, 215, 374);
		frame.getContentPane().add(table_1);
		
		/*----------------------------------------------*/
		
		//Buttons
		
		JButton btnNewButton_1 = new JButton("<--- Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchIslandMenu();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_1.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JButton btnNewButton = new JButton("Get info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int selectedRow = table_1.getSelectedRow();
					
					//Sets all the predefined labels that weren't visible to be visible
					
					lblNewLabel.setVisible(true);
					lblNewLabel_1.setVisible(true);
					lblNewLabel_2.setVisible(true);
					lblNewLabel_3.setVisible(true);
					lblNewLabel_4.setVisible(true);
					lblNewLabel_5.setVisible(true);
					
					//Uses the selectedRow variable to set the empty labels to certain values
					//This works but could be done better I think
					
					lblNewLabel_6.setText(state.newPlayer.getInventoryHistory().get(selectedRow));
					lblNewLabel_1_1.setText(String.valueOf(state.newPlayer.getIslandBroughtHistory().get(selectedRow)));
					lblNewLabel_3_1.setText(String.valueOf(state.newPlayer.getCostBroughtHistory().get(selectedRow)));
					lblNewLabel_2_1.setText(state.newPlayer.getIslandSoldHistory().get(selectedRow));
					lblNewLabel_4_1.setText(String.valueOf(state.newPlayer.getCostSoldHistory().get(selectedRow)));
					lblNewLabel_5_1.setText(String.valueOf(state.newPlayer.getCostSoldHistory().get(selectedRow) - state.newPlayer.getCostBroughtHistory().get(selectedRow)));
					
					JLabel lblNewLabel_8 = new JLabel("");
					lblNewLabel_8.setBounds(364, 68, 421, 369);
					frame.getContentPane().add(lblNewLabel_8);
					lblNewLabel_8.setBackground(Color.WHITE);
					lblNewLabel_8.setOpaque(true);
				}
				
				catch (IndexOutOfBoundsException f)
				{
					
				}
			}
		});
		btnNewButton.setBounds(158, 449, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnTipToView = new JTextPane();
		txtpnTipToView.setEditable(false);
		txtpnTipToView.setFont(new Font("Arial Hebrew Scholar", Font.PLAIN, 15));
		txtpnTipToView.setText("Tip! To view the stats of an item you have purchesed click on the desired item and then click the \"get info\" button!");
		txtpnTipToView.setBounds(179, 564, 669, 40);
		frame.getContentPane().add(txtpnTipToView);
		
		JLabel background = new JLabel();
		background.setVerticalAlignment(SwingConstants.TOP);
		background.setIcon(new ImageIcon(ViewPropertiesIslands.class.getResource("/Images/Background.PNG")));
		background.setBounds(0, 0, 1000, 787);
		frame.getContentPane().add(background);
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
