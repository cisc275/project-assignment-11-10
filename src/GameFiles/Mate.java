package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// mate of the osprey

public class Mate extends Bird {
	
	/**
	 * true if the Osprey's distance is equivalent to max distance
	 */
	static boolean caughtUp;
	
	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
	 */
	
	public Mate(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.imgFileName = Constants.ANIMATION_OSPREY;
		this.curImg = randy.nextInt(imgFileName.length);
		Mate.caughtUp = false;
		this.setxSpeed(Constants.MATE_CAUGHT_SPEED);
	}
	
	/**
	 * handles moving when the osprey has caught up, stays still if not
	 * @author tim Mazzarelli
	 */

	public void move() {
		if (this.hitbox.getBounds2D().getMaxX() <= Constants.OSPREY_STARTX) {
			resetPoly();
			Mate.caughtUp = true;
		}
		else if (Osprey.distance >= Osprey.maxDistance) {
			this.hitbox.translate(this.getxSpeed(), Constants.MATE_INIT_SPEED);	
		}
		else {
			this.hitbox.translate(Constants.MATE_INIT_SPEED, Constants.MATE_INIT_SPEED);
			}
		this.animate(Constants.MATE_ANIMATION_TICK_RATE);
	}


	/**
	 * handles collision with osprey, game has been one and now to the quiz
	 * @param o
	 * @author tim Mazzarelli
	 */

	@Override
	public void handleCollision(Osprey o) {
		resetPoly();
		Mate.caughtUp = true;
		
	}

}



