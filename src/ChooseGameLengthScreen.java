import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ChooseGameLengthScreen {

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/
	
	public ChooseGameLengthScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeChooseGameLengthScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 707);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		

		JLabel lblNewLabel_1 = new JLabel("Pick the length of your game!");
		lblNewLabel_1.setFont(new Font("Arial Hebrew", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(357, 243, 316, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(2);
		slider.setSnapToTicks(true);
		slider.setForeground(Color.BLACK);
		slider.setPaintLabels(true);
		slider.setValue(20);
		slider.setPaintTicks(true);
		slider.setMinimum(20);
		slider.setMaximum(50);
		slider.setBounds(229, 289, 487, 56);
		frame.getContentPane().add(slider);
		

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Once the confirm button is selected all the variables are set.
				
				state.newPlayer.setNumDaysRemaning(slider.getValue());
				state.newPlayer.setSelectedNumDays(slider.getValue());
				
				state.launchChooseShipScreen();
				closeWindow();
				finishedWindow();
			}
		});
		
		btnNewButton.setBounds(305, 376, 316, 80);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_4.setBounds(220, 289, 513, 56);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ChooseGameLengthScreen.class.getResource("/Images/ConfirmButton.png")));
		lblNewLabel_3.setBounds(305, 376, 326, 80);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(116, 192, 705, 276);
		lblNewLabel.setOpaque(true);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/Images/Background.png")));
		lblNewLabel_2.setBounds(0, 0, 1018, 685);
		frame.getContentPane().add(lblNewLabel_2);
	
		
	}
}
