package GameFiles;

import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * super class for all view objects  
 *
 */


public class View extends JPanel {

	ArrayList<GameObject> game;

	public ArrayList<GameObject> getGame() {
		return game;
	}

	public void setGame(ArrayList<GameObject> game) {
		this.game = game;
	}
	
}
