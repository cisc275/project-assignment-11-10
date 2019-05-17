package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * super class for both bird objects
 */
public class Bird extends Controllable{
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * 
	 * constructor
	 */
	
	public Bird(int x, int y, int width, int height) {
		super(x,y,width, height);		
	}
	


	/**
	 * @return the mOVE_AMOUNT
	 */
	public int getMOVE_AMOUNT() {
		return Constants.BIRD_MOVE_AMOUNT;
	}
	
	
}
