import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SetSailScreen {

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/

	public SetSailScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeSetSailScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	public boolean canTravelToIsland() {
		
		//Checks if the player can travel to a specific island 
		
		int minimumDays = state.currentIsland.daysToDestination((state.currentIsland.shortestRoute(state.currentIsland, state.travellingIsland)), (state.chosenShip.getShipSpeed()));
		
		double minimumCostToSail = state.newPlayer.costToSail(minimumDays, state.chosenShip);

		if (minimumCostToSail > state.newPlayer.getBalance()) {
			return false;
		}
		else if (minimumDays > state.newPlayer.getNumDaysRemaining()) {
			return false;
		}
		else if (state.travellingIsland.getNameOfIsland() == state.currentIsland.getNameOfIsland()) {
			return false;
		}
		
		
		return true;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 707);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Sorry, you can't sail here!");
		lblNewLabel_1.setFont(new Font("Arial Hebrew Scholar", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(574, 312, 254, 55);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JButton madagascar = new JButton();
		madagascar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.travellingIsland = state.madagascar;
				if (canTravelToIsland() == true){
					state.launchPickingRoutesScreen();
					closeWindow();
					finishedWindow();
				} 
				else {
					lblNewLabel_1.setVisible(true);
				}
			}
		});
		madagascar.setBounds(391, 275, 117, 144);
		frame.getContentPane().add(madagascar);
		madagascar.setBorderPainted(false);
        madagascar.setBorder(null);
        madagascar.setOpaque(false);
		madagascar.setContentAreaFilled(false);
        
        JButton jumanji = new JButton();
        jumanji.setVerticalAlignment(SwingConstants.TOP);
        jumanji.setHorizontalAlignment(SwingConstants.TRAILING);
        jumanji.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		state.travellingIsland = state.jumanji;
				if (canTravelToIsland() == true){
					state.launchPickingRoutesScreen();
					closeWindow();
					finishedWindow();
				} 
				else {
					lblNewLabel_1.setVisible(true);
				}
        	}
        });
		jumanji.setBounds(520, 0, 480, 293);
		frame.getContentPane().add(jumanji);
		jumanji.setBorderPainted(false);
        jumanji.setBorder(null);
        jumanji.setOpaque(false);
		jumanji.setContentAreaFilled(false);
     
		
		JButton atlantis= new JButton();
		atlantis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.travellingIsland = state.atlantis;
				if (canTravelToIsland() == true){
					state.launchPickingRoutesScreen();
					closeWindow();
					finishedWindow();
				} 
				else {
					lblNewLabel_1.setVisible(true);
				}
			}
		});
		atlantis.setBounds(63, 328, 180, 233);
		frame.getContentPane().add(atlantis);
		atlantis.setBorderPainted(false);
        atlantis.setBorder(null);
        atlantis.setOpaque(false);
		atlantis.setContentAreaFilled(false);
		
		JButton islaNublar = new JButton();
		islaNublar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.travellingIsland = state.islaNublar;
				if (canTravelToIsland() == true){
					state.launchPickingRoutesScreen();
					closeWindow();
					finishedWindow();
				} 
				else {
					lblNewLabel_1.setVisible(true);
				}
			}
		});
		islaNublar.setBounds(362, 472, 164, 164);
		frame.getContentPane().add(islaNublar);
		islaNublar.setBorderPainted(false);
        islaNublar.setBorder(null);
        islaNublar.setOpaque(false);
		islaNublar.setContentAreaFilled(false);
        
        JButton ogygia = new JButton();
        ogygia.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		state.travellingIsland = state.ogygia;
				if (canTravelToIsland() == true){
					state.launchPickingRoutesScreen();
					closeWindow();
					finishedWindow();
				} 
				else {
					lblNewLabel_1.setVisible(true);
				}
        	}
        });
		ogygia.setBounds(270, 54, 158, 107);
		frame.getContentPane().add(ogygia);
		ogygia.setBorderPainted(false);
        ogygia.setBorder(null);
        ogygia.setOpaque(false);
		ogygia.setContentAreaFilled(false);
		
		JLabel map = new JLabel();
		map.setVerticalAlignment(SwingConstants.TOP);
		map.setIcon(new ImageIcon(ViewPropertiesIslands.class.getResource("/Images/Map.PNG")));
		map.setBounds(0, 0, 1000, 787);
		frame.getContentPane().add(map);
		
	}
}

