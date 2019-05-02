package GameFiles;

import java.awt.Polygon;
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
	/**
	 * 
	 * this method will be defined in subclasses, and will contain the 
	 * logic needed for the objects movement on screen.
	 * the speed will be used to increment the x and y coordinates as needed
	 */
	
	
	/**
	 * @param y
	 * @param x
	 * @param imgPose
	 * @param width
	 * @param height
	 * @param hitbox 
	 * @param img 
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

	public Controllable(int x, int y, int width, int height, Polygon hitbox, BufferedImage img) {
		super(x,y,width,height, hitbox, img);
	}

	

}
