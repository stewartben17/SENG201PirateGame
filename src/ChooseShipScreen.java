import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class ChooseShipScreen {

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/
	
	public ChooseShipScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeChooseShipScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize() {
		
		//Creates button groups for the radio buttons
		//Button groups allow only one button in the group to be selected at one time
		
		ButtonGroup ships = new ButtonGroup();
		
		/*----------------------------------------------*/
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 707);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Pick your ship!");
		lblNewLabel.setFont(new Font("Arial Hebrew", Font.PLAIN, 20));
		lblNewLabel.setBounds(427, 18, 146, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Please pick a ship");
		lblNewLabel_2.setFont(new Font("Arial Hebrew", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(409, 42, 277, 69);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Argo");
		rdbtnNewRadioButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(843, 419, 76, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Black Pearl");
		rdbtnNewRadioButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(44, 418, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Titanic");
		rdbtnNewRadioButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rdbtnNewRadioButton_2.setBounds(577, 419, 87, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Jolly Roger");
		rdbtnNewRadioButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rdbtnNewRadioButton_3.setBounds(299, 419, 116, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		
		ships.add(rdbtnNewRadioButton);
		ships.add(rdbtnNewRadioButton_1);
		ships.add(rdbtnNewRadioButton_2);
		ships.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton_4 = new JButton(); //Views properties of the argo
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				state.chosenShip = state.argo;
				state.launchViewShipScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_4.setBounds(779, 106, 191, 237);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setContentAreaFilled(false);
		
		JButton btnNewButton_3 = new JButton(); //View properties of the Black Pearl 
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				state.chosenShip = state.blackPearl;
				state.launchViewShipScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_3.setBounds(44, 106, 155, 237);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setContentAreaFilled(false);
		
		
		JButton btnNewButton_2 = new JButton(); //Vies the properties of the Titanic
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state.chosenShip = state.titanic;
				state.launchViewShipScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_2.setBounds(501, 106, 246, 256);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false);
		
		
		JButton btnNewButton_1 = new JButton(); //Views the properties of the jolly roger
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state.chosenShip = state.jollyRoger;
				state.launchViewShipScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_1.setBounds(233, 106, 240, 219);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Once the confirm button is selected all the variables are set.
				boolean valid = false;
				if (rdbtnNewRadioButton.isSelected()) {
					state.setChosenShip(state.argo);
					valid = true;
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					state.setChosenShip(state.blackPearl);
					valid = true;
				} else if (rdbtnNewRadioButton_2.isSelected()) {
					state.setChosenShip(state.titanic);
					valid = true;
				} else if (rdbtnNewRadioButton_3.isSelected()) {
					state.setChosenShip(state.jollyRoger);
					valid = true;
				}
				else
				{
					lblNewLabel_2.setVisible(true);
				}
				if (valid == true)
				{
					state.launchChooseIslandScreen();
					closeWindow();
					finishedWindow();
				}
				

			}
		});
		btnNewButton.setBounds(351, 479, 298, 74);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ChooseShipScreen.class.getResource("/Images/JollyRoger.png")));
		lblNewLabel_1.setBounds(233, 83, 256, 261);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(ChooseShipScreen.class.getResource("/Images/Argo.png")));
		lblNewLabel_1_1.setBounds(768, 61, 321, 301);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(ChooseShipScreen.class.getResource("/Images/Titanic.png")));
		lblNewLabel_1_1_1.setBounds(501, 106, 256, 237);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(ChooseShipScreen.class.getResource("/Images/BlackPearl.png")));
		lblNewLabel_1_1_1_1.setBounds(34, 69, 191, 293);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setOpaque(true);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_1.setBounds(19, 94, 198, 271);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setOpaque(true);
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_1.setBounds(229, 94, 256, 271);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1.setOpaque(true);
		lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_1_1.setBounds(501, 94, 256, 271);
		frame.getContentPane().add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1_1.setOpaque(true);
		lblNewLabel_3_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_1_1_1.setBounds(769, 94, 212, 271);
		frame.getContentPane().add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("");
		lblNewLabel_3_1_2.setOpaque(true);
		lblNewLabel_3_1_2.setForeground(Color.WHITE);
		lblNewLabel_3_1_2.setBackground(Color.WHITE);
		lblNewLabel_3_1_2.setBounds(19, 392, 198, 74);
		frame.getContentPane().add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("");
		lblNewLabel_3_1_2_1.setOpaque(true);
		lblNewLabel_3_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_2_1.setBounds(233, 392, 256, 74);
		frame.getContentPane().add(lblNewLabel_3_1_2_1);
		
		JLabel lblNewLabel_3_1_2_2 = new JLabel("");
		lblNewLabel_3_1_2_2.setOpaque(true);
		lblNewLabel_3_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_2.setBackground(Color.WHITE);
		lblNewLabel_3_1_2_2.setBounds(501, 392, 256, 74);
		frame.getContentPane().add(lblNewLabel_3_1_2_2);
		
		JLabel lblNewLabel_3_1_2_3 = new JLabel("");
		lblNewLabel_3_1_2_3.setOpaque(true);
		lblNewLabel_3_1_2_3.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_3.setBackground(Color.WHITE);
		lblNewLabel_3_1_2_3.setBounds(768, 392, 213, 74);
		frame.getContentPane().add(lblNewLabel_3_1_2_3);
		
		JLabel lblNewLabel_5 = new JLabel("Tip! Click on a ship to see more information about it");
		lblNewLabel_5.setFont(new Font("Arial Hebrew", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(256, 598, 584, 31);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon(ChooseIslandScreen.class.getResource("/Images/ConfirmButton.png")));
		lblNewLabel_20.setBounds(351, 478, 358, 75);
		frame.getContentPane().add(lblNewLabel_20);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ChooseIslandScreen.class.getResource("/Images/BlankButton.png")));
		lblNewLabel_3.setBounds(59, 562, 976, 95);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(IslandMenu.class.getResource("/Images/Background.png")));
		lblNewLabel_14.setBounds(0, 0, 1003, 686);
		frame.getContentPane().add(lblNewLabel_14);
	
		
	}
}
