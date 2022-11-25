import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;


public class PickingRoutesScreen {

	private JFrame frame;
	private GameState state;
	private JTable table;
	private ArrayList<Integer> dist = new ArrayList<Integer>();
	private ArrayList<Integer> danger = new ArrayList<Integer>();
	int row_1;
	private int endingState = 0;
	
	/*----------------------------------------------*/

	public PickingRoutesScreen(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closePickingRoutesScreen(this);
	}
	
	public int getRow_1() {
		return row_1;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void callEnd() {
		
		state.launchEnding();
		closeWindow();
		finishedWindow();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 707);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		/*----------------------------------------------*/
		
		//Labels
		
		JLabel possibleRoutesLabel = new JLabel("Possible routes ");
		possibleRoutesLabel.setBounds(469, 11, 119, 16);
		frame.getContentPane().add(possibleRoutesLabel);
		
		JLabel crewWagesLabel = new JLabel("Crew wages");
		crewWagesLabel.setBounds(486, 294, 178, 16);
		frame.getContentPane().add(crewWagesLabel);
		
		JLabel costRepairShipLabel = new JLabel("Cost to repair ship");
		costRepairShipLabel.setBounds(456, 350, 132, 16);
		frame.getContentPane().add(costRepairShipLabel);
		
		JLabel costToSailLabel = new JLabel("");
		costToSailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		costToSailLabel.setBounds(478, 439, 109, 16);
		frame.getContentPane().add(costToSailLabel);
		
		JLabel crewWageLabel = new JLabel("");
		crewWageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		crewWageLabel.setBounds(476, 322, 84, 16);
		frame.getContentPane().add(crewWageLabel);
		
		JLabel totalCostLabel = new JLabel("Total cost");
		totalCostLabel.setBounds(486, 411, 111, 16);
		frame.getContentPane().add(totalCostLabel);
		
		JLabel piratesChanceLabel = new JLabel("Chance to encounter pirates:");
		piratesChanceLabel.setBounds(432, 194, 186, 16);
		frame.getContentPane().add(piratesChanceLabel);
		piratesChanceLabel.setVisible(false);
		
		JLabel sailingLabel = new JLabel("Sailing...");
		sailingLabel.setBounds(501, 208, 61, 16);
		frame.getContentPane().add(sailingLabel);
		
		JLabel piratesAppearLabel = new JLabel("Oh no! Pirates!! And they have dice D:");
		piratesAppearLabel.setBounds(415, 239, 335, 16);
		frame.getContentPane().add(piratesAppearLabel);
		
		JLabel piratesEncounterWin = new JLabel("You won the dice roll, the pirates are leaving");
		piratesEncounterWin.setBounds(374, 322, 370, 16);
		frame.getContentPane().add(piratesEncounterWin);
		
		JLabel piratesEncounterLose = new JLabel("Yikes, you lost the dice roll. The pirates took all your things and left");
		piratesEncounterLose.setBounds(319, 333, 605, 16);
		frame.getContentPane().add(piratesEncounterLose);
		
		JLabel piratesWin = new JLabel("Yikes, you lost the dice roll. The pirates are making you walk the plank.");
		piratesWin.setBounds(310, 350, 550, 16);
		frame.getContentPane().add(piratesWin);
		
		JLabel weatherDamage = new JLabel("Oh no! The weather has damaged your boat by");
		weatherDamage.setBounds(343, 383, 298, 16);
		frame.getContentPane().add(weatherDamage);
		
		JLabel weatherDamageValue = new JLabel("");
		weatherDamageValue.setBounds(648, 383, 102, 16);
		frame.getContentPane().add(weatherDamageValue);
		
		JLabel rescuedSailors = new JLabel("Wow! You rescued some sailers and they gave you 2000 dollars :)");
		rescuedSailors.setBounds(326, 439, 480, 16);
		frame.getContentPane().add(rescuedSailors);
		
		JLabel selectRoute = new JLabel("Please select a route");
		selectRoute.setBounds(452, 216, 200, 29);
		frame.getContentPane().add(selectRoute);
		selectRoute.setVisible(false);
		
		JLabel encounterWeatherChance = new JLabel("Chance to encounter dangerous weather:");
		encounterWeatherChance.setBounds(405, 222, 267, 16);
		frame.getContentPane().add(encounterWeatherChance);
		
		JLabel chanceFindSailors = new JLabel("Chance to find sailors:");
		chanceFindSailors.setBounds(456, 250, 149, 16);
		frame.getContentPane().add(chanceFindSailors);
		
		JLabel lblNewLabel_1_1 = new JLabel("Starting location");
		lblNewLabel_1_1.setBounds(309, 42, 117, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Amounts of days");
		lblNewLabel_1_2.setBounds(533, 42, 131, 16);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Danger level");
		lblNewLabel_1_3.setBounds(662, 42, 117, 16);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel destinationLabel = new JLabel("Destination");
		destinationLabel.setBounds(432, 42, 79, 16);
		frame.getContentPane().add(destinationLabel);
		
		JLabel lblNewLabel_8_2 = new JLabel("");
		lblNewLabel_8_2.setOpaque(true);
		lblNewLabel_8_2.setBackground(Color.WHITE);
		lblNewLabel_8_2.setBounds(298, 31, 469, 38);
		frame.getContentPane().add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_1 = new JLabel("10%");
		lblNewLabel_1.setBounds(604, 250, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_19 = new JLabel("100%");
		lblNewLabel_19.setBounds(630, 194, 61, 16);
		frame.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_19_1 = new JLabel("50%");
		lblNewLabel_19_1.setBounds(630, 194, 61, 16);
		frame.getContentPane().add(lblNewLabel_19_1);
		
		JLabel lblNewLabel_19_2 = new JLabel("33%");
		lblNewLabel_19_2.setBounds(630, 194, 61, 16);
		frame.getContentPane().add(lblNewLabel_19_2);
		
		JLabel lblNewLabel_19_3 = new JLabel("25%");
		lblNewLabel_19_3.setBounds(630, 194, 61, 16);
		frame.getContentPane().add(lblNewLabel_19_3);
		
		JLabel lblNewLabel_19_4 = new JLabel("20%");
		lblNewLabel_19_4.setBounds(630, 194, 61, 16);
		frame.getContentPane().add(lblNewLabel_19_4);
		
		JLabel weatherChance1 = new JLabel("100%");
		weatherChance1.setBounds(664, 222, 61, 16);
		frame.getContentPane().add(weatherChance1);
		
		JLabel weatherChance2 = new JLabel("50%");
		weatherChance2.setBounds(664, 222, 61, 16);
		frame.getContentPane().add(weatherChance2);
		
		JLabel weatherChance3 = new JLabel("33%");
		weatherChance3.setBounds(664, 222, 61, 16);
		frame.getContentPane().add(weatherChance3);
		
		JLabel weatherChance4 = new JLabel("25%");
		weatherChance4.setBounds(664, 222, 61, 16);
		frame.getContentPane().add(weatherChance4);
		
		JLabel weatherChance5 = new JLabel("20%");
		weatherChance5.setBounds(664, 222, 61, 16);
		frame.getContentPane().add(weatherChance5);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(466, 383, 92, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel piratesWinning = new JLabel("The pirates win if you roll a 0 D:");
		piratesWinning.setBounds(425, 266, 209, 16);
		frame.getContentPane().add(piratesWinning);
		
		JLabel roll = new JLabel("Your roll is:");
		roll.setBounds(450, 294, 95, 16);
		frame.getContentPane().add(roll);
		
		JLabel rollValue = new JLabel("");
		rollValue.setBounds(557, 294, 61, 16);
		frame.getContentPane().add(rollValue);
		
		JTextPane pickRouteTip = new JTextPane();
		pickRouteTip.setText("To select a route to travel on, click on your desired route! "
				+ "You can then get more information about the route by clicking the \"Get info\" button or you can "
				+ "confirm your selection by clicking the \"Confirm\" button. The amount of danger of a route corresponds to the chance of random events");
		pickRouteTip.setBounds(298, 567, 469, 98);
		frame.getContentPane().add(pickRouteTip);
		
		JTextPane sailingTip = new JTextPane();
		sailingTip.setText("You are now sailing! Watch out though, pirates might try and board your boat armed with a dice!"
				+ " Try and negotiate your way through the encounter by rolling the correct value. "
				+ "You could also encounter some wild wheather or some stranded sailors.");
		sailingTip.setBounds(298, 567, 469, 98);
		frame.getContentPane().add(sailingTip);
		sailingTip.setVisible(false);
		
		
		
		//Pirate chances
		
		sailingLabel.setVisible(false);
		piratesAppearLabel.setVisible(false);
		piratesEncounterWin.setVisible(false);
		piratesEncounterLose.setVisible(false);
		piratesWin.setVisible(false);
		weatherDamage.setVisible(false);
		weatherDamageValue.setVisible(false);
		rescuedSailors.setVisible(false);
		lblNewLabel_19.setVisible(false);
		lblNewLabel_19_1.setVisible(false);
		lblNewLabel_19_2.setVisible(false);
		lblNewLabel_19_3.setVisible(false);
		lblNewLabel_19_4.setVisible(false);
		chanceFindSailors.setVisible(false);
		encounterWeatherChance.setVisible(false);
		lblNewLabel_1.setVisible(false);
		weatherChance1.setVisible(false);
		weatherChance2.setVisible(false);
		weatherChance3.setVisible(false);
		weatherChance4.setVisible(false);
		weatherChance5.setVisible(false);
		costRepairShipLabel.setVisible(false);
		totalCostLabel.setVisible(false);
		crewWagesLabel.setVisible(false);
		piratesWinning.setVisible(false);
		roll.setVisible(false);
		rollValue.setVisible(false);
		
		
		/*----------------------------------------------*/
		
		//Tables
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
				
		        new Object [][] {
		            },
		            new String [] {
		                "Starting Island","Destination","Days to get there","Danger"
		            }
		        ));
			
			DefaultTableModel model_2 = (DefaultTableModel) table.getModel();
			Object rowData_2[] = new Object[4];
			for (int i = 0; i < state.travellingIsland.getRoutesList().size(); i ++) {
				if (state.travellingIsland.getRoutesList().get(i).getDestination() == state.currentIsland.getNameOfIsland()) {
					
					if (state.travellingIsland.daysToDestination(state.travellingIsland.getRoutesList().get(i).getDistance(), state.chosenShip.getShipSpeed()) 
							<= state.newPlayer.getNumDaysRemaining()) {
						
						if (state.newPlayer.costToSail(state.travellingIsland.daysToDestination(state.travellingIsland.getRoutesList().get(i).getDistance(), state.chosenShip.getShipSpeed()), state.chosenShip) 
								<= state.newPlayer.getBalance()){
							
							rowData_2[0] = state.travellingIsland.getRoutesList().get(i).getDestination();
							rowData_2[1] = state.travellingIsland.getRoutesList().get(i).getStart();
							rowData_2[2] = state.travellingIsland.daysToDestination(state.travellingIsland.getRoutesList().get(i).getDistance(),
									state.chosenShip.getShipSpeed());
							rowData_2[3] = state.travellingIsland.getRoutesList().get(i).getDanger();
							model_2.addRow(rowData_2);
							dist.add(state.travellingIsland.daysToDestination(state.travellingIsland.getRoutesList().get(i).getDistance(), state.chosenShip.getShipSpeed()));
							danger.add(state.travellingIsland.getRoutesList().get(i).getDanger());
						}
					}
				}
			}
		
		table.setBounds(298, 81, 471, 71);
		frame.getContentPane().add(table);
		
		
		/*----------------------------------------------*/
		
		//Buttons
		
		
		JButton btnNewButton_1 = new JButton("Get more info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int row_1 = table.getSelectedRow();
					double costToSail = state.newPlayer.costToSail(dist.get(row_1), state.chosenShip);
					double crewWageForRoute = state.chosenShip.getCrewWage() * state.chosenShip.getCrewNum() * dist.get(row_1);
					
					encounterWeatherChance.setVisible(true);
					chanceFindSailors.setVisible(true);
					lblNewLabel_1.setVisible(true);
					costRepairShipLabel.setVisible(true);
					crewWagesLabel.setVisible(true);
					totalCostLabel.setVisible(true);
					
					
					
					if (state.chosenShip.getShipHealth() != state.chosenShip.getMaxShipHealth()) {
						lblNewLabel_8.setText(String.valueOf(state.newPlayer.getBalance() - state.chosenShip.getRepairCosts()));
					} else {
						lblNewLabel_8.setText("0");
					}
					
					selectRoute.setVisible(false);
					piratesChanceLabel.setVisible(true);
					
					costToSailLabel.setText(String.valueOf(costToSail));
					
					if (danger.get(row_1) == 1) {
						lblNewLabel_19.setVisible(true);
						weatherChance1.setVisible(true);
						
					} else if (danger.get(row_1) == 2) {
						lblNewLabel_19_1.setVisible(true);
						weatherChance2.setVisible(true);
						
					} else if (danger.get(row_1) == 3) {
						lblNewLabel_19_2.setVisible(true);
						weatherChance3.setVisible(true);
						
					} else if (danger.get(row_1) == 4) {
						lblNewLabel_19_3.setVisible(true);
						weatherChance4.setVisible(true);
						
					} else if (danger.get(row_1) == 5) {
						lblNewLabel_19_4.setVisible(true);
						weatherChance5.setVisible(true);
					}
					
					crewWageLabel.setText(String.valueOf(crewWageForRoute));
				}
				catch (IndexOutOfBoundsException t)
				{
					selectRoute.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(471, 153, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("<--- Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.launchSetSailScreen();
				closeWindow();
				finishedWindow();
			}
		});
		btnNewButton.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Continue");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (endingState == 1) {
					callEnd();
				}else {
					state.launchIslandMenu();
					closeWindow();
					finishedWindow();
				}
			}
		});
		btnNewButton_3.setBounds(458, 532, 117, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_3.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("Confirm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					//CanTravel
					int row_1 = table.getSelectedRow();
					int status = state.randomPirates(danger.get(row_1));
					
					btnNewButton.setVisible(false);
					btnNewButton_1.setVisible(false);
					btnNewButton_2.setVisible(false);
					table.setVisible(false);
					
					possibleRoutesLabel.setVisible(false);
					lblNewLabel_1.setVisible(false);
					crewWagesLabel.setVisible(false);
					costRepairShipLabel.setVisible(false);
					costToSailLabel.setVisible(false);
					crewWageLabel.setVisible(false);
					totalCostLabel.setVisible(false);
					piratesChanceLabel.setVisible(false);
					lblNewLabel_8.setVisible(false);
					encounterWeatherChance.setVisible(false);
					chanceFindSailors.setVisible(false);
					pickRouteTip.setVisible(false);
					sailingTip.setVisible(true);
					
					weatherChance1.setVisible(false);
					weatherChance2.setVisible(false);
					weatherChance3.setVisible(false);
					weatherChance4.setVisible(false);
					weatherChance5.setVisible(false);
					
					lblNewLabel_19.setVisible(false);
					lblNewLabel_19_1.setVisible(false);
					lblNewLabel_19_2.setVisible(false);
					lblNewLabel_19_3.setVisible(false);
					lblNewLabel_19_4.setVisible(false);
					
					lblNewLabel_8_2.setVisible(false);
					lblNewLabel_1_1.setVisible(false);
					lblNewLabel_1_2.setVisible(false);
					lblNewLabel_1_3.setVisible(false);
					destinationLabel.setVisible(false);
		
					selectRoute.setVisible(false);
					
					sailingLabel.setVisible(true);
					
					btnNewButton_3.setVisible(true);
					
					rollValue.setText(String.valueOf(state.chosenShip.getCaptainDiceRoll()));
					
					if (status == 1) { //Pirates show up, win the dice roll and kill you
						piratesAppearLabel.setVisible(true);
						piratesWinning.setVisible(true);
						roll.setVisible(true);
						rollValue.setVisible(true);
						piratesWin.setVisible(true);
						endingState = 1;
						
					} else {
						if (status == 2){ //Pirates show up, win and take your items
							piratesAppearLabel.setVisible(true);
							piratesWinning.setVisible(true);
							roll.setVisible(true);
							rollValue.setVisible(true);
							piratesEncounterLose.setVisible(true);
						}
						
						else if (status == 4) {//Pirates show up but you win
							
							piratesAppearLabel.setVisible(true);
							piratesWinning.setVisible(true);
							roll.setVisible(true);
							rollValue.setVisible(true);
							piratesEncounterWin.setVisible(true);
							
						}
						
						if (state.chosenShip.getShipHealth() != state.chosenShip.getMaxShipHealth()) {
							state.newPlayer.setBalance(state.newPlayer.getBalance() - state.chosenShip.repairShip());
						} //Repairs the ship if needed
						
						
						state.newPlayer.setBalance(state.newPlayer.getBalance() - state.chosenShip.getCrewNum() * state.chosenShip.getCrewWage() * 
								(dist.get(row_1))); //Takes the crews wage from balance
						
						state.newPlayer.setNumDaysRemaning(state.newPlayer.getNumDaysRemaining() - dist.get(row_1)); //Takes the number of days
						
						state.currentIsland = state.travellingIsland;
						
						if (state.randomWeather(danger.get(row_1)) == 1) {
							weatherDamage.setVisible(true);
							weatherDamageValue.setText(String.valueOf(state.chosenShip.getMaxShipHealth() - state.chosenShip.getShipHealth()));
							weatherDamageValue.setVisible(true);
						}
						
						if (state.randomSailors() == 1) {
							rescuedSailors.setVisible(true);
						}
						
					}	
				}
				catch (IndexOutOfBoundsException f)
				{
					selectRoute.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(458, 467, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel boarder = new JLabel("");
		boarder.setBounds(296, 183, 471, 317);
		frame.getContentPane().add(boarder);
		boarder.setOpaque(true);
		boarder.setBackground(Color.WHITE);
		
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(ChooseNameScreen.class.getResource("/Images/Background.png")));
		lblNewLabel_21.setBounds(0, 0, 1018, 685);
		frame.getContentPane().add(lblNewLabel_21);	
		
		
	}
}
