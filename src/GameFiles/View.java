package GameFiles;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * super class for all view objects  
 *
 */


public class View extends JFrame {

	ArrayList<GameObject> game;
	static JFrame frame; 
	
	

	public ArrayList<GameObject> getGame() {
		return game;
	}

	public void setGame(ArrayList<GameObject> game) {
		this.game = game;
	}
	
	public void updateView(ArrayList<GameObject> game) {
		
	}
	
	public void addKeyListener(Controller c) {
		
	}
	
	public void addActionListener(Controller c) {
		
	}
	
	/**
	 * Default setup and full screen.
	 * @param frame JFrame item passed from the View Object
	 */
	public void setUpScreen(JFrame frame) {
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	frame.setUndecorated(true);
    	frame.pack();
    	frame.setVisible(true);
    	Constants.setFrameX(frame.getWidth());
    	Constants.setFrameY(frame.getHeight());
    	System.out.println(frame.getWidth());
	}

	
}
