package GameFiles;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * represents all objects that can be controlled by the user
 *
 */
public class Controllable extends GameObject {
	
	/**
	 * speed of object being controlled 
	 */
	int xSpeed; 
	int ySpeed;
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
//	public Controllable(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, 
//			int yMax, boolean isDiving, int currY, int xSpeed, int ySpeed) {
//		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, isDiving, currY, xSpeed, ySpeed);
//		}
	public Controllable(int x, int y, int width, int height) {
		super(x,y,width,height);
	}

	public Controllable(BufferedImage createImage, int i, int j) {
		// TODO Auto-generated constructor stub
		super(createImage, i, j);
	}

	public Controllable(String string, int i, int j) {
		super(string,i,j);
	}

	/**
	 * @return the xSpeed
	 */
	public int getxSpeed() {
		return xSpeed;
	}

	/**
	 * @param xSpeed the xSpeed to set
	 */
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * @return the ySpeed
	 */
	public int getySpeed() {
		return ySpeed;
	}

	/**
	 * @param ySpeed the ySpeed to set
	 */
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

}
