package GameFiles;

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
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
//	public InvisibleWall(int y, int x, File imgPose, int width, int height, 
//			int xMin, int xMax, int yMin, int yMax, boolean isDiving, int currY, int xSpeed, int ySpeed) {
//		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, isDiving, currY, xSpeed, ySpeed);
//	}
	public InvisibleWall(int x, int y, int width, int height) {
		super(x,y,width,height);
	}

}
