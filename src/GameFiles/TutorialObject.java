/**
 * 
 */
package GameFiles;

import java.awt.Polygon;
import java.io.File;

/**
 * @author wolginm
 *
 */
public class TutorialObject extends NonControllable {

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public TutorialObject(int x, int y, String img) {
		super(x, y, 0, 0);
		this.img = this.createImage(new File(img));
		this.img.getWidth();
		this.setWidth(this.img.getWidth());
		this.setHeight(this.img.getHeight());
		this.hitbox = new Polygon();

		// TODO Auto-generated constructor stub
	}

}
