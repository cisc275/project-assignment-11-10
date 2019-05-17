package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * represents boundaries in the game 
 *
 */
public class InvisibleWall extends NonControllable {

	/**
	 * @param y
	 * @param x
	 * @param imgPose
	 * @param width
	 * @param height
	 * a constructor that takes values for all fields as input parameters
	 */

	public InvisibleWall(int x, int y, int width, int height) {
		super(x,y,width,height);
	}

}
