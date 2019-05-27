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
	
	static boolean quizHappened = false;
	
	/**
	 * boolean whether or not the game is over
	 */
	
	static boolean gameOver = false;
	
	/**
	 * boolean for whether or not you are in Tutorial mode
	 */
	
	public static boolean inTutoral = false;
	
	
	/**
	 * defined in subclasses, updates model
	 * @param game ArrayList of GameObjects
	 */
	public void updateLocation(ArrayList<GameObject> game) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * All default objects that need to be setup.
	 * @author Mark Wolgin
	 */
	protected void defaultSetup() {
		
	}
	
	/**
	 * All default objects after the tutorial.
	 * @author Mark Wolgin
	 */
	protected void postTutorial() {
		
	}
	
	/**
	 * 
	 * @return ArrayList of GameObjects
	 */
	public ArrayList<GameObject> getGame() {
		return game;
	}
	
	/**
	 * how you handle each key press, defined in submodels
	 * @param keyPresses The ArrayList of keyPresses
	 */
	public void handleMove(HashSet<Integer> keyPresses) {
		
	}
	
	/**
	 * Sets the new game array
	 * @param game ArrayList of GameObjects
	 */
	public void setGame(ArrayList<GameObject> game) {
		this.game = game;
	} 
	
	/**
	 * Makes the model System.out.print-able
	 * @return The default string for the model
	 */
	@Override
	public String toString() {
		return "Game Over: " + gameOver + "\n" + game;
		
	}
	
	/**
	 * handles the power up effect
	 * @author Peter Jenny
	 */
	public void handlePwr() {
		
	}
	
}
