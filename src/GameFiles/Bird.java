package GameFiles;

import java.io.File;

/**
 * super class for both bird objects
 */
public class Bird extends Controllable{
	

	/**
	 * describes which bird has been selected
	 */
	Type type; 
	
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
	 * @param isDiving 
	 * @param currY 
	 */
	public Bird(int y, int x, File imgPose, int width, int height, int xMin, int xMax, 
			int yMin, int yMax,Type type, int xSpeed, int ySpeed) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, xSpeed, ySpeed);
		}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
