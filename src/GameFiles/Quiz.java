package GameFiles;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * represents the quiz at the end of each game 
 *
 */
public class Quiz extends View {
	/**
	 * button that will allow user to select the osprey game
	 */
	 static JButton right; 
	/**
	 * button that will allow user to select the clapperrail game
	 */
	JButton wrong;
	JButton moreWrong;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public Quiz() {
		
		
		right = new JButton("Tall nest on a pole");
		wrong = new JButton("Low nest on the ground");
		moreWrong = new JButton ("Ospreys don't make nests");
		this.setLayout(new FlowLayout());
		this.add(right);
		this.add(wrong);
		this.add(moreWrong);
		this.setTitle("Where should you put your nest?");
		this.setSize(screenSize.getSize());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}
	
	public void addActionListener(Controller controller) {
		right.addActionListener(controller);
		wrong.addActionListener(controller);
		moreWrong.addActionListener(controller);
		System.out.println("hi");
		}
	
	public static void main(String[] args) {
		Quiz sv = new Quiz();
	}
}