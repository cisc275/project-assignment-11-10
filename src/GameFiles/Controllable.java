package GameFiles;

import java.io.File;

/**
 * represents all objects that can be controlled by the user
 *
 */
public class Controllable extends GameObject {
	
	/**
	 * speed of object being controlled 
	 */
	int speed; 
	/**
	 * 
	 * this method will be defined in subclasses, and will contain the 
	 * logic needed for the objects movement on screen.
	 * the speed will be used to increment the x and y coordinates as needed
	 */
	public void move() {
		
	}
	
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
	 * @param speed
	 * 
	 * a constructor that takes values for all fields as input parameters
	 * @param isDiving 
	 * @param currY 
	 */
	public Controllable(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, 
			int yMax, boolean isDiving, int currY, int xSpeed, int ySpeed) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, isDiving, currY, xSpeed, ySpeed);}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
