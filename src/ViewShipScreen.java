import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewShipScreen {

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/
	
	public ViewShipScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeViewShipScreen(this);
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
		lblNewLabel.setBounds(312, 222, 116, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number of crew");
		lblNewLabel_1.setBounds(312, 284, 108, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cost per day to sail");
		lblNewLabel_2.setBounds(312, 368, 130, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Remaining space in cargo");
		lblNewLabel_3.setBounds(312, 443, 161, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel(state.chosenShip.getShipName());
		lblNewLabel_7.setBounds(567, 222, 179, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(String.valueOf(state.chosenShip.getCrewNum()));
		lblNewLabel_8.setBounds(567, 284, 168, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(String.valueOf(state.chosenShip.getCrewWage()));
		lblNewLabel_9.setBounds(567, 368, 61, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(String.valueOf(state.chosenShip.getRemainingCargoCapacity()));
		lblNewLabel_10.setBounds(578, 443, 168, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		
		/*----------------------------------------------*/
		
		//Buttons
		
		JButton btnNewButton = new JButton("<--- Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchChooseShipScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(284, 194, 406, 302);
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setOpaque(true);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/Images/Background.png")));
		lblNewLabel_21.setBounds(0, 0, 1018, 685);
		frame.getContentPane().add(lblNewLabel_21);
		
	}
}
