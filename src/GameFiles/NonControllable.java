package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Objects in the game that the user will not be able to control
 *
 */
public class NonControllable extends GameObject {

	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * @param hitbox
	 * @param img
	 * a constructor that takes values for all fields as input parameters
	 */
	

	public NonControllable(int x, int y, int width, int height) {
		super(x,y,width,height);
	}

}
