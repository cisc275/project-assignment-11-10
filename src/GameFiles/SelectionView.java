package GameFiles;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * View for the selection screen
 */
public class SelectionView extends View {
	
	/**
	 * button that will allow user to select the osprey game
	 */
	static JButton osprey; 
	/**
	 * button that will allow user to select the clapperrail game
	 */
	static JButton clapperRail;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public SelectionView() {
		
		
		osprey = new JButton(new ImageIcon("img/selectOsprey.png"));
		clapperRail = new JButton(new ImageIcon("img/selectCR.png"));
		this.setLayout(new FlowLayout());
		this.add(osprey);
		this.add(clapperRail);
	
		this.setSize(screenSize.getSize());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		
	}
	
	public void addActionListener(Controller controller) {
		osprey.addActionListener(controller);
		clapperRail.addActionListener(controller);
		
	}
	public static void main(String[] args) {
		View sv = new SelectionView();
	}
}
