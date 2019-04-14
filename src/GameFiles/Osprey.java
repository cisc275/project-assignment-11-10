package GameFiles;

import java.io.File;

/**
 * represents the osprey in the top down view game 
 *
 */
public class Osprey extends Bird {
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
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	public Osprey(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, int yMax, 
			Type type, boolean isDiving, int currY, int xSpeed, int ySpeed){
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, type, isDiving, currY, xSpeed, ySpeed);
}
	
	/**
	 * this method will be called whenever the user presses the dive button
	 * at which point the bird will dive into the water and possibly collect 
	 * fish or trash. the logic for this action will be contained here.
	 */
	public void dive() {
		
	}
}
