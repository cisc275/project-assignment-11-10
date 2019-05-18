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
	 * Creates a Tutorial Object with a hitbox of 0,0 and an img.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public TutorialObject(int x, int y, int w, int h, String[] img) {
		super(x, y, 0, 0);
		this.width = w;
		this.height = h;
		this.imgFileName = img;
		this.resetPoly();
	}
	
	@Override
	public void move() {
		this.curImgTickCount ++;
		if (curImgTickCount == Constants.TO_ANIMATION_TICK_RATE) {
			curImg = (curImg + 1) % this.imgFileName.length;
			//System.out.println(curImg);
			curImgTickCount = 0;
			//this.visible = false;
		}
	}

}
