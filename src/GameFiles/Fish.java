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
	public Fish(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, int yMax, int id,
			int benefit, int type) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, id, benefit);
	}

	/**
	 * determines the amount of boost this fish will give the bird
	 */
	int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	} 
}
