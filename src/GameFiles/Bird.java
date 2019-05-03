package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * super class for both bird objects
 */
public class Bird extends Controllable{
	

	/**
	 * describes which bird has been selected
	 */
	Type type; 
	
	final private int INIT_BIRD_SPEED = 10;
	final private int MOVE_AMOUNT = 10;
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
	

	

	public Bird(int x, int y, int width, int height, Polygon hitbox, BufferedImage img) {
		super(x,y,width, height, hitbox, img);
		birdSpeed = INIT_BIRD_SPEED;
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


	/**
	 * @return the mOVE_AMOUNT
	 */
	public int getMOVE_AMOUNT() {
		return MOVE_AMOUNT;
	}
	
	
}
