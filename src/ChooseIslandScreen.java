import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ChooseIslandScreen {

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/
	
	public ChooseIslandScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeChooseIslandScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize() {
		
		//Creates button groups for the radio buttons
		//Button groups allow only one button in the group to be selected at one time
		

		ButtonGroup islands = new ButtonGroup();
		
		/*----------------------------------------------*/
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 707);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Pick your home island!");
		lblNewLabel.setFont(new Font("Arial Hebrew", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(203, 58, 609, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Please pick an island");
		lblNewLabel_2.setFont(new Font("Arial Hebrew", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(409, 107, 224, 37);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Isla Nublar");
		rdbtnNewRadioButton_4.setBounds(129, 388, 106, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Atlantis");
		rdbtnNewRadioButton_5.setBounds(452, 388, 93, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Madagascar");
		rdbtnNewRadioButton_6.setBounds(786, 388, 117, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_6);
		
		islands.add(rdbtnNewRadioButton_4);
		islands.add(rdbtnNewRadioButton_5);
		islands.add(rdbtnNewRadioButton_6);
		
		JButton btnNewButton_3 = new JButton(); //Shows islaNublar info
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				state.currentIsland = state.islaNublar;
				state.infoIsland = state.islaNublar;
				state.launchViewIslandScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_3.setBounds(37, 156, 287, 168);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setContentAreaFilled(false);
		
		
		JButton btnNewButton_2 = new JButton();
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state.currentIsland = state.atlantis;
				state.infoIsland = state.atlantis;
				state.launchViewIslandScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_2.setBounds(363, 156, 287, 168);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false);
		
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state.currentIsland = state.madagascar;
				state.infoIsland = state.madagascar;
				state.launchViewIslandScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton_1.setBounds(695, 156, 287, 168);
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
				
				if (rdbtnNewRadioButton_4.isSelected()) {
					state.setChosenIsland(state.islaNublar);
					state.setCurrentIsland(state.islaNublar);
					valid = true;
				} else if (rdbtnNewRadioButton_5.isSelected()) {
					state.setChosenIsland(state.atlantis);
					state.setCurrentIsland(state.atlantis);
					valid = true;
				} else if (rdbtnNewRadioButton_6.isSelected()) {
					state.setChosenIsland(state.madagascar);
					state.setCurrentIsland(state.madagascar);
					valid = true;
				}
				else
				{
					lblNewLabel_2.setVisible(true);
				}
				if (valid == true)
				{
					state.launchIslandMenu();
					closeWindow();
					finishedWindow();
				}
				
			}
		});
		btnNewButton.setBounds(363, 456, 297, 75);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ChooseIslandScreen.class.getResource("/Images/IslaNublar.png")));
		lblNewLabel_1.setBounds(59, 159, 224, 153);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setIcon(new ImageIcon(ChooseIslandScreen.class.getResource("/Images/Atlantis.png")));
		lblNewLabel_1_1.setBounds(383, 174, 250, 136);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(ChooseIslandScreen.class.getResource("/Images/Madagascar.png")));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(695, 176, 275, 136);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_3_1_2_3 = new JLabel("");
		lblNewLabel_3_1_2_3.setOpaque(true);
		lblNewLabel_3_1_2_3.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_3.setBackground(Color.WHITE);
		lblNewLabel_3_1_2_3.setBounds(363, 155, 287, 169);
		frame.getContentPane().add(lblNewLabel_3_1_2_3);
		
		JLabel lblNewLabel_3_1_2_3_1 = new JLabel("");
		lblNewLabel_3_1_2_3_1.setOpaque(true);
		lblNewLabel_3_1_2_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_2_3_1.setBounds(37, 155, 287, 169);
		frame.getContentPane().add(lblNewLabel_3_1_2_3_1);
		
		JLabel lblNewLabel_3_1_2_3_2 = new JLabel("");
		lblNewLabel_3_1_2_3_2.setOpaque(true);
		lblNewLabel_3_1_2_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_3_2.setBackground(Color.WHITE);
		lblNewLabel_3_1_2_3_2.setBounds(695, 155, 287, 169);
		frame.getContentPane().add(lblNewLabel_3_1_2_3_2);
		
		JLabel lblNewLabel_3_1_2_3_1_1 = new JLabel("");
		lblNewLabel_3_1_2_3_1_1.setOpaque(true);
		lblNewLabel_3_1_2_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_3_1_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_2_3_1_1.setBounds(37, 375, 287, 49);
		frame.getContentPane().add(lblNewLabel_3_1_2_3_1_1);
		
		JLabel lblNewLabel_3_1_2_3_1_1_1 = new JLabel("");
		lblNewLabel_3_1_2_3_1_1_1.setOpaque(true);
		lblNewLabel_3_1_2_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_3_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_2_3_1_1_1.setBounds(363, 375, 287, 49);
		frame.getContentPane().add(lblNewLabel_3_1_2_3_1_1_1);
		
		JLabel lblNewLabel_3_1_2_3_1_1_2 = new JLabel("");
		lblNewLabel_3_1_2_3_1_1_2.setOpaque(true);
		lblNewLabel_3_1_2_3_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_3_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_3_1_2_3_1_1_2.setBounds(695, 375, 287, 49);
		frame.getContentPane().add(lblNewLabel_3_1_2_3_1_1_2);
		
		JLabel lblNewLabel_5 = new JLabel("Tip! Click on an island's flag to see more information about it");
		lblNewLabel_5.setFont(new Font("Arial Hebrew", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(256, 598, 584, 31);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ChooseIslandScreen.class.getResource("/Images/BlankButton.png")));
		lblNewLabel_3.setBounds(59, 562, 976, 95);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ChooseIslandScreen.class.getResource("/Images/ConfirmButton.png")));
		lblNewLabel_4.setBounds(363, 456, 358, 75);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(IslandMenu.class.getResource("/Images/Background.png")));
		lblNewLabel_14.setBounds(0, 0, 1003, 686);
		frame.getContentPane().add(lblNewLabel_14);
		
		
		
		
		
		
		
		
	
		
	}
}
