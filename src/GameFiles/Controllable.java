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
	 
	 */

	public Controllable(int x, int y, int width, int height, Polygon hitbox, BufferedImage img) {
		super(x,y,width,height, hitbox, img);
	}

	

}
