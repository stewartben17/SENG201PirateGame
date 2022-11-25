

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitialScreen {

	private JFrame frame;
	private GameState state;
	
	public InitialScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeInitialScreen(this);
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
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state.launchChooseNameScreen(); //Opens the next window
				closeWindow(); //Disposes of the window from memory I think
				finishedWindow(); //Closes the window
				
			}
		});
		btnNewButton_1.setBounds(630, 429, 303, 82);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InitialScreen.class.getResource("/Images/ConfirmButton.png")));
		lblNewLabel.setBounds(630, 429, 364, 82);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/Images/Background.png")));
		lblNewLabel_1.setBounds(0, 0, 1018, 685);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
