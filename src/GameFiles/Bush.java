package GameFiles;

import java.io.File;

/**
 * represents the bush(es) that the clapperrail can use to hide
 *
 */
public class Bush extends NonControllable {

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
	public Bush(int y, int x, File imgPose, int width, int height,
			int xMin, int xMax, int yMin, int yMax) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax);
	}

}
