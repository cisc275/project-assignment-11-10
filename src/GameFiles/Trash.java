package GameFiles;

import java.io.File;

/**
 * represents trash that user can collect
 */
public class Trash extends Collectable {
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
	public Trash(int y, int x, File imgPose, int width, int height, int xMin, int xMax, int yMin, int yMax, int id,
			int benefit, int type) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, id, benefit);
	}

	/**
	 * describes what trash has been collected to decide the level of severity to the bird
	 */
	int type;

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	} 
}
