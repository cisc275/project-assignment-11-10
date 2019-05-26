/**
 * 
 */
package GameFiles;

import java.awt.Polygon;
import java.io.File;

/**
 * A class for images that do not interact, used for tutorials.
 * @author Mark Wolgin
 *
 */
public class TutorialObject extends NonControllable {
	
	/**
	 * Creates a Tutorial Object with a hitbox of and an img.
	 * @param x			The x location of the object
	 * @param y			The x location of the object
	 * @param w		Width of the object
	 * @param h		Height of the object
	 * @param img Sting array of file paths
 	 */
	public TutorialObject(int x, int y, int w, int h, String[] img) {
		super(x, y, Constants.FRAME_X - Constants.FRAME_X, Constants.FRAME_Y - Constants.FRAME_Y);
		this.width = w;
		this.height = h;
		this.imgFileName = img;
		this.resetPoly();
	}
	
	@Override
	public void move() {
		animate(Constants.TO_ANIMATION_TICK_RATE);
	}

}
