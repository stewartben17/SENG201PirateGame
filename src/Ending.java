import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ending {

	private JFrame frame;
	private GameState state;
	
	public Ending(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeEnding(this);
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
		
		JLabel lblNewLabel = new JLabel("Game over");
		lblNewLabel.setBounds(283, 23, 126, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ending balance");
		lblNewLabel_1.setBounds(145, 143, 164, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(145, 56, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total profit");
		lblNewLabel_3.setBounds(145, 181, 119, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Selected length of the game");
		lblNewLabel_4.setBounds(145, 87, 199, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Actual length of the game");
		lblNewLabel_5.setBounds(145, 115, 199, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Score");
		lblNewLabel_6.setBounds(145, 224, 61, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(state.newPlayer.getName());
		lblNewLabel_7.setBounds(402, 56, 61, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(String.valueOf(state.newPlayer.getSelectedNumDays()));
		lblNewLabel_8.setBounds(402, 87, 134, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(String.valueOf(state.newPlayer.getSelectedNumDays() - state.newPlayer.getNumDaysRemaining()));
		lblNewLabel_9.setBounds(402, 115, 134, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(String.valueOf(state.newPlayer.getBalance()));
		lblNewLabel_10.setBounds(402, 143, 134, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(String.valueOf(state.newPlayer.getBalance() - 1000));
		lblNewLabel_11.setBounds(402, 181, 173, 16);
		frame.getContentPane().add(lblNewLabel_11);
		
		JButton btnNewButton = new JButton("Return to the home screen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state.reset();
				state.launchInitialScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton.setBounds(221, 354, 288, 29);
		frame.getContentPane().add(btnNewButton);
	}

}
