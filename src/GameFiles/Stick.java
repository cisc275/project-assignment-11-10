package GameFiles;

import java.io.File;

/**
 * attributes for all sticks in the game
 *
 */
public class Stick extends Collectable{
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
	 * @param id
	 * @param benefit
	 * @param count
	 * @param holding
	 * @param onScreen
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	public Stick(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, int yMax, int id,
			int benefit, int count, boolean holding, boolean onScreen) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, id, benefit);
	}
	/**
	 * the number of sticks the that have been collected
	 */
	static int count; 
	/**
	 * whether or not the bird is holding the stick
	 */
	static boolean holding;
	/**
	 * whether or not a stick is currently on screen
	 */
	static boolean onScreen; 
	
}
