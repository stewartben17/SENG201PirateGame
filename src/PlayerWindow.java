import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class PlayerWindow {

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/
	
	public PlayerWindow(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closePlayerWindow(this);
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
		
		JLabel lblNewLabel_5 = new JLabel(String.valueOf(state.newPlayer.getBalance()));
		lblNewLabel_5.setBounds(596, 186, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel(String.valueOf(state.newPlayer.getNumDaysRemaining()));
		lblNewLabel_3.setBounds(489, 215, 31, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Your current balance is $");
		lblNewLabel_1.setFont(new Font("Arial Hebrew Scholar", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(395, 188, 204, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("There is currently");
		lblNewLabel_2.setFont(new Font("Arial Hebrew Scholar", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(350, 217, 148, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("days left in the quest!");
		lblNewLabel_4.setFont(new Font("Arial Hebrew Scholar", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(510, 216, 165, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		/*----------------------------------------------*/
		
		//Buttons
		
		JButton btnNewButton = new JButton("<--- Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchIslandMenu();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton.setBounds(21, 17, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JTable table_2 = new JTable(); //Creates a new table
		table_2.setModel(new DefaultTableModel(
				
				//Sets a model for the table
				
		        new Object [][] {
		            },
		            new String [] {
		                "Item", "Quantity" //This is the header of the table, for each column write the header here
		            }
		        ));
			
			DefaultTableModel model_2 = (DefaultTableModel) table_2.getModel(); //Sets the table to the chosen model we created
			Object rowData_2[] = new Object[2]; //Shows how many columns we want in the table
			
			Set<IslandMain.Buying> inventorySet = state.newPlayer.getInventorySet();
			for (IslandMain.Buying item : inventorySet)
			{
				rowData_2[0] = item.getItem();
				rowData_2[1] = state.newPlayer.getInventoryDict().get(item);
				model_2.addRow(rowData_2);
			}
			

        
		table_2.setBounds(362, 303, 295, 228);
		frame.getContentPane().add(table_2);
		
		
		JLabel lblNewLabel_6 = new JLabel("Current inventory");
		lblNewLabel_6.setFont(new Font("Arial Hebrew Scholar", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(440, 277, 165, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/Images/Background.png")));
		lblNewLabel_21.setBounds(0, 0, 1018, 685);
		frame.getContentPane().add(lblNewLabel_21);
	}
}
