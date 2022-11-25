import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PirateShipScreen {

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/
	
	public PirateShipScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closePirateShipScreen(this);
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
		
		JLabel lblNewLabel = new JLabel("Name of the ship");
		lblNewLabel.setBounds(312, 142, 116, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number of crew");
		lblNewLabel_1.setBounds(312, 204, 108, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cost per day to sail");
		lblNewLabel_2.setBounds(312, 276, 130, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Remaining space in cargo");
		lblNewLabel_3.setBounds(312, 336, 161, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Upgrades purchased for the ship");
		lblNewLabel_4.setBounds(312, 399, 205, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Damage to the ship");
		lblNewLabel_5.setBounds(312, 456, 179, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cost to fix the ship");
		lblNewLabel_6.setBounds(312, 526, 161, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(state.chosenShip.getShipName());
		lblNewLabel_7.setBounds(567, 142, 179, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(String.valueOf(state.chosenShip.getCrewNum()));
		lblNewLabel_8.setBounds(567, 204, 168, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(String.valueOf(state.chosenShip.getCrewWage()));
		lblNewLabel_9.setBounds(567, 276, 61, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(String.valueOf(state.chosenShip.getRemainingCargoCapacity()));
		lblNewLabel_10.setBounds(567, 336, 168, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("Upgrades purchased *Need to do!"); //Needs to be coded
		lblNewLabel_10_1.setBounds(567, 399, 161, 16);
		frame.getContentPane().add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_2 = new JLabel(String.valueOf(100 - state.chosenShip.getShipHealth()));
		lblNewLabel_10_2.setBounds(567, 456, 218, 16);
		frame.getContentPane().add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_10_3 = new JLabel(String.valueOf(state.chosenShip.getRepairCosts()));
		lblNewLabel_10_3.setBounds(567, 526, 140, 16);
		frame.getContentPane().add(lblNewLabel_10_3);
		
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
		btnNewButton.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBackground(Color.WHITE);
		lblNewLabel_11.setBounds(203, 99, 609, 493);
		frame.getContentPane().add(lblNewLabel_11);
		lblNewLabel_11.setOpaque(true);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/Images/Background.png")));
		lblNewLabel_21.setBounds(0, 0, 1018, 685);
		frame.getContentPane().add(lblNewLabel_21);
	}
}
