package GameFiles;

import java.io.File;

/**
 * Objects in the game that the user will not be able to control
 *
 */
public class NonControllable extends GameObject {

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
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	public NonControllable(int y, int x, File imgPose, int width, int height,
			int xMin, int xMax, int yMin, int yMax) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax);
	}

}
