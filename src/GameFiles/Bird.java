package GameFiles;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * super class for both bird objects
 */
public class Bird extends Controllable implements Moveable{
	

	/**
	 * describes which bird has been selected
	 */
	Type type; 
	private int birdSpeed;
	
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
	 * @param type
	 * 
	 * a constructor that takes values for all fields as input parameters
	 * @param isDiving 
	 * @param currY 
	 */
	

	
//	public Bird(int y, int x, File imgPose, int width, int height, int xMin, int xMax, 
//			int yMin, int yMax,Type type, boolean isDiving, int currY, int xSpeed, int ySpeed) {
//		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, isDiving, currY, xSpeed, ySpeed);
//		}
	public Bird(int x, int y, int width, int height) {
		super(x,y,width,height);
		birdSpeed = 10;
	}
	
	public Bird(BufferedImage createImage, int i, int j) {
		// TODO Auto-generated constructor stub
		super(createImage, i, j);
	}

	public Bird(String string, int i, int j) {
		super(string,i,j);
	}

	public void move() {
		x = x + birdSpeed; 
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	public int getBirdSpeed() {
		return birdSpeed;
	}
	public void setBirdSpeed(int birdSpeed) {
		this.birdSpeed = birdSpeed;
	}
	
	
}
