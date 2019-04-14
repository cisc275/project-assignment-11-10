package GameFiles;

import java.io.File;

/**
 * represents air currents that osprey can use to fly faster 
 *
 */
public class AirCurrent extends Collectable {
	/**
	 * used to determine if the aircurrent will speed up or slow down the bird
	 */
	String direction; 
	/**
	 * describes if there is an aircurrent currently on screen
	 */
	boolean onScreen; 
	
	
	/**
	 * @param y
	 * @param x
	 * @param imgPose
	 * @param width
	 * @param height
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
	 * @param id
	 * @param benefit
	 * @param direction
	 * @param onScreen
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	public AirCurrent(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, 
			int yMax, int id, int benefit, String direction, boolean onScreen) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, id, benefit);
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public boolean isOnScreen() {
		return onScreen;
	}


	public void setOnScreen(boolean onScreen) {
		this.onScreen = onScreen;
	}
}
