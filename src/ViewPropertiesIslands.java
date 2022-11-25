

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewPropertiesIslands {

	private JFrame frame;
	private GameState state;
	
	/*----------------------------------------------*/

	public ViewPropertiesIslands(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeViewPropertiesIslands(this);
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
		
		JButton madagascar= new JButton();
		madagascar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state.infoIsland = state.madagascar;
        		state.launchIslandDisplay();
        		closeWindow();
        		finishedWindow();
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
        		state.infoIsland = state.jumanji;
        		state.launchIslandDisplay();
        		closeWindow();
        		finishedWindow();
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
				state.infoIsland = state.atlantis;
        		state.launchIslandDisplay();
        		closeWindow();
        		finishedWindow();
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
				state.infoIsland = state.islaNublar;
        		state.launchIslandDisplay();
        		closeWindow();
        		finishedWindow();
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
        		state.infoIsland = state.ogygia;
        		state.launchIslandDisplay();
        		closeWindow();
        		finishedWindow();
        	}
        });
		ogygia.setBounds(270, 54, 158, 107);
		frame.getContentPane().add(ogygia);
		ogygia.setBorderPainted(false);
        ogygia.setBorder(null);
        ogygia.setOpaque(false);
		ogygia.setContentAreaFilled(false);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(ViewPropertiesIslands.class.getResource("/Images/Map.PNG")));
		lblNewLabel.setBounds(0, 0, 1000, 787);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}

}
