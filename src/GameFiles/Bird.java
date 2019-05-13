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
     * getter for type
     */
	public Type getType() {
		return type;
	}
	
    /**
     * setter for type
     * @param type,
     * 
     */
	public void setType(Type type) {
		this.type = type;
	}


	/**
	 * @return the mOVE_AMOUNT
	 */
	public int getMOVE_AMOUNT() {
		return Constants.BIRD_MOVE_AMOUNT;
	}
	
	
}
