
import javax.swing.JFrame;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ChooseNameScreen {

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/
	
	public ChooseNameScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeChooseNameScreen(this);
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
		
		JTextPane txtpnTypeYourName = new JTextPane();
		txtpnTypeYourName.setFont(new Font("Arial", Font.PLAIN, 20));
		txtpnTypeYourName.setBounds(319, 304, 438, 29);
		frame.getContentPane().add(txtpnTypeYourName);
		
		JLabel lblNewLabel = new JLabel("Name (Between 3 and 15 characters)");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(366, 263, 297, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Invalid Name");
		lblNewLabel_2.setBounds(459, 347, 232, 16);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		Pattern pattern = Pattern.compile("[^a-zA-Z]");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Once the confirm button is selected all the variables are set.
				
				
				String chosenName = txtpnTypeYourName.getText();
				
				if (chosenName.length() >= 3 && chosenName.length() <= 15)
				{
					Pattern pattern = Pattern.compile("[^a-zA-Z]");
					Matcher matcher = pattern.matcher(chosenName);
					
					boolean isNameValid = ! (matcher.find());
					
					if (isNameValid) {
						state.newPlayer.setName(chosenName);
						state.launchChooseGameLengthScreen();
						closeWindow();
						finishedWindow();
					}
					else {
						System.out.println("Nope");
					}
				}
				else
				{
					lblNewLabel_2.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(347, 405, 297, 75);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/Images/ConfirmButton.png")));
		lblNewLabel_3.setBounds(347, 397, 491, 97);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_7.setBounds(169, 216, 710, 309);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/Images/Background.png")));
		lblNewLabel_1.setBounds(0, 0, 1018, 685);
		frame.getContentPane().add(lblNewLabel_1);
	
		
	}
}
