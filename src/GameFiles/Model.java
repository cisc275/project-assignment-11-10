package GameFiles;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

public class Model implements Serializable {
	
	/**
	 * serialVersionUID auto generated
	 */
	private static final long serialVersionUID = 1344012034511117384L;

	/**
	 * a list of the objects in our game
	 */
	ArrayList<GameObject> game;
	
	/**
	 * boolean for whether the game is over or not
	 */
	
	static boolean gameOver = false;
	
	protected boolean inTutoral = false;
	
	
	/**
	 * defined in subclasses, updates model
	 * @param game
	 */
	public void updateLocation(ArrayList<GameObject> game) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * All default objects that need to be setup.
	 */
	protected void defaultSetup() {
		
	}
	
	/**
	 * 
	 * @return ArrayList<GameObject>
	 */
	public ArrayList<GameObject> getGame() {
		return game;
	}
	
	/**
	 * how you handle each key press, defined in submodels
	 * @param keyPresses
	 */
	public void handleMove(HashSet<Integer> keyPresses) {
		
	}
	
	/**
	 * 
	 * @param game
	 */
	public void setGame(ArrayList<GameObject> game) {
		this.game = game;
	} 
	
	/**
	 * @return String
	 */
	@Override
	public String toString() {
		return "Game Over: " + gameOver + "\n" + game;
		
	}
	
	
}
