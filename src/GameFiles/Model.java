package GameFiles;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

public class Model {
	/**
	 * a list of the objects in our game
	 */
	ArrayList<GameObject> game;
	final int RIGHT = 39;
	final int LEFT = 37;
	final int UP = 38;
	final int DOWN = 40;
	final int SPACE = 32;
	
	static boolean gameOver = false;
	
	public void updateLocation(ArrayList<GameObject> game) {
		// TODO Auto-generated method stub
		
	}
	public void advanceWorld(ArrayList<GameObject> game) {
		
	}

	public ArrayList<GameObject> getGame() {
		return game;
	}
	public void handleMove(HashSet<Integer> keyPresses) {}

	public void setGame(ArrayList<GameObject> game) {
		this.game = game;
	} 
	
	
	
}
