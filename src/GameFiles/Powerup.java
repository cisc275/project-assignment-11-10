package GameFiles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Powerup extends Collectable {

	
	
	public static boolean power = false;
	/**
	 * @param x
	 * @param y 
	 * @param width
	 * @param height
	 * 
	 * A constructor that takes values for all fields as input parameters
	 */
	public Powerup(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.xSpeed = -20;
		this.imgFileName = Constants.ANIMATION_CRAB;
		this.curImg = randy.nextInt(imgFileName.length);
	}

	/**
	 * @param ClapperRail cr
	 * 
	 * deals with collision with respect to ClapperRail
	 * 
	 * @author tim mazzarelli
	 */
	@Override
	public void handleCollision(ClapperRail cr) {
		resetPoly();
		cr.xSpeed = 0;
		cr.ySpeed = 0;
		power = true;
		new Quiz("td");		
	}
	
	@Override
	public void move() {
		this.hitbox.translate(this.xSpeed, 0);
		if(this.hitbox.xpoints[3] <= 0) {
			resetPoly();
		}
		this.animate(Constants.CRAB_ANIMATION_TICK_RATE);
	}
	
	
	/**
	 * 
	 *  Resets Polygon with its origin at x, y and its size to be its width and height
	 * 
	 * @author Peter Jenny
	 */
	public void resetPoly() {
		this.hitbox.reset();
		this.hitbox.addPoint(x + Constants.FRAME_X, y);
		this.hitbox.addPoint(x + Constants.FRAME_X, y + height);
		this.hitbox.addPoint(x + Constants.FRAME_X + width, y + height);
		this.hitbox.addPoint(x + Constants.FRAME_X + width, y);
	}
	
	
	
	/**
	 * @param Osprey o
	 * 
	 * deals with collision with respect to Osprey
	 * @author tim mazzarelli
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		Model.quizHappened = true;
		power = true;
		resetPoly();
		new Quiz("sides");
	
	}



}
