package GameFiles;

import java.io.File;

/**
 * 
 *represents all collectable items in both games
 */
public class Collectable extends GameObject {
	
	/**
	 * will be used to describe which object is being collected
	 */
	int id; 
	/**
	 * will describe if it helps or hurts the birds collecting and by how much
	 */
	int benefit; 
	
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
	public Collectable(int y, int x, File imgPose, int width, int height, int xMin, 
			int xMax, int yMin, int yMax, int id, int benefit) {
		super(y, x, imgPose, width, height, xMin, xMax, yMin, yMax, benefit, benefit);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBenefit() {
		return benefit;
	}

	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}
	
}
