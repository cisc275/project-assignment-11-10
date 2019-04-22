package GameFiles;

import java.io.File;

/**
 * represents fish that will give both birds a boost
 *
 */
public class Fish extends Collectable {
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
	 * @param type
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	/*
	 (int y, int x, File imgPose, int width, int height, int xMin, 
			int xMax, int yMin, int yMax, int id, int benefit, boolean isDiving, int currY, int xSpeed,
			int ySpeed) {
	 */
//	public Fish(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, int yMax, 
//			int id, int benefit, boolean isDiving, int currY, int xSpeed, int ySpeed, int type) {
//		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, id, benefit, isDiving, currY, xSpeed,
//				ySpeed);
//	}

	public Fish(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.setType(Type.FISH);
	}

}
