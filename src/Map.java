import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Map {

	private JFrame frame;
	private GameState state;

	
	/*----------------------------------------------*/

	public Map(GameState incomingState) {
		state = incomingState;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		state.closeMap(this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 707);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton madagascar = new JButton();
		madagascar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Madagascar");
			}
		});
		madagascar.setIcon(new ImageIcon("/Users/ben/eclipse-workspace/DownloadedSengGame/src/Images/Madagascar.png"));
		madagascar.setBorder(null);
		madagascar.setBounds(410, 283, 95, 141);
		
		frame.getContentPane().add(madagascar);
		
		
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("/Users/ben/eclipse-workspace/DownloadedSengGame/src/Images/Map.PNG"));
		lblNewLabel.setBounds(0, 0, 1000, 787);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
