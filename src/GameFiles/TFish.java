package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * represents fish that will give both birds a boost
 *	@author Mark Wolgin
 */
public class TFish extends Collectable {
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */

	public TFish(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.imgFileName = Constants.ANIMATION_FISH;
		this.curImg = randy.nextInt(imgFileName.length);
	}
	
	

	/** handles fish collision with osprey
	 * @param o
	 * @author Timothy Mazzarelli
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		Osprey.posHitOs = true;
		if (this.visible == true) {;
			o.setXSpeed(Osprey.getXSpeed() - 15);
		}
		if (Osprey.xSpeed <= Constants.OSPREY_MAX_SPEED) {
			o.setXSpeed(Constants.OSPREY_MAX_SPEED);
			}
	}
	
	/* (non-Javadoc)
	 * @see GameFiles.Collectable#move()
	 */
	@Override
	public void move() {
		this.hitbox.translate(this.getxSpeed(), Constants.COLLECTABLE_YSPEED);
		this.x += this.getxSpeed();
		if(this.hitbox.getBounds2D().getMinX() <= Constants.FRAME_X - Constants.FRAME_X) {
			resetPoly();
		}
		animate(Constants.FISH_ANIMATION_TICK_RATE);	
	}
	

}
