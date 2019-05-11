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
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * @param hitbox 
	 * @param img 
		
		
		Constructor for controllable object
	 */ 

	public Controllable(int x, int y, int width, int height) {
		super(x,y,width,height);
		
	}

	

}
