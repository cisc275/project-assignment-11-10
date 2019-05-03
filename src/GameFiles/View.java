package GameFiles;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * super class for all view objects  
 *
 */


public class View extends JFrame {

	ArrayList<GameObject> game;
	int frameSize = 800;

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

	
}
