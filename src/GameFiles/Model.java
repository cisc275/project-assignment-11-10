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
	 * serialVersionUID auto genorated
	 */
	private static final long serialVersionUID = 1344012034511117384L;

	/**
	 * a list of the objects in our game
	 */
	ArrayList<GameObject> game;
	
	static boolean gameOver = false;
	
	public void updateLocation(ArrayList<GameObject> game) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<GameObject> getGame() {
		return game;
	}
	public void handleMove(HashSet<Integer> keyPresses) {}

	public void setGame(ArrayList<GameObject> game) {
		this.game = game;
	} 
	
	@Override
	public String toString() {
		return "Game Over: " + gameOver + "\n" + game;
		
	}
	
	
}
