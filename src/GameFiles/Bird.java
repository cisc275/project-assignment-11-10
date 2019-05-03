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
	
	final private int MOVE_AMOUNT = 10;
	
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * @param hitbox
	 * @param img
	 * 
	 * constructor
	 */
	
	public Bird(int x, int y, int width, int height, Polygon hitbox, BufferedImage img) {
		super(x,y,width, height, hitbox, img);
		
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


	/**
	 * @return the mOVE_AMOUNT
	 */
	public int getMOVE_AMOUNT() {
		return MOVE_AMOUNT;
	}
	
	
}
