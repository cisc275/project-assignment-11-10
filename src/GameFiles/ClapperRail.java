package GameFiles;

import java.io.File;

/**
 * represents the clapperrail for the side scroll game 
 *
 */
public class ClapperRail extends Bird {
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
	 * @param speed
	 * @param type
	 * @param hidden
	 * @param carryStick
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	public ClapperRail(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, 
			int yMax, int speed, Type type, boolean hidden, boolean carryStick) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, speed, type);
	}
	
	/**
	 * describes if the bird's coordinates matches with that of a bush on screen
	 */
	boolean hidden; 
	/**
	 * describes if the bird has a stick
	 */
	boolean carryStick; 
}
