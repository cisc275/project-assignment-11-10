package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * attributes for all sticks in the game
 *
 */
public class Stick extends Collectable{
	
	/**
	 * ySpeed of the stick (0 or clapper rail ySpeed)
	 */
	
	private int ySpeed;
	
	/**
	 * the number of sticks the that have been collected
	 */
	static int count = 0; 
	
	/**
	 * whether or not the bird is holding the stick
	 */

	static boolean onScreen;
	/**
	 * @param y
	 * @param x
	 * @param height
	 * @param width
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public Stick(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.hitbox.reset();
		this.hitbox.addPoint(x, y);
		this.hitbox.addPoint(x + width, y + height);
		this.setxSpeed(0);
		this.setySpeed(0);
		this.imgFileName = Constants.ANIMATION_STICK;
		this.curImg = randy.nextInt(imgFileName.length);
		this.setType(Type.STICK);
		
	}
	/**
	 * calls ClapperRail handleCollision passing in this
	 * @param cr
	 * @author andrew thompson/ tim mazzarelli
	 */
	
	@Override
	public void handleCollision(ClapperRail cr) {
		if (this.hitbox.getBounds2D().getMaxX() <= Constants.STICK_HANDLECOLLISION_OFFSET 
				|| this.hitbox.getBounds2D().getMinX() >= Constants.FRAME_X - Constants.STICK_HANDLECOLLISION_OFFSET
				|| this.hitbox.getBounds2D().getMaxY() <= Constants.STICK_HANDLECOLLISION_OFFSET 
				|| this.hitbox.getBounds2D().getMinY() >= Constants.FRAME_Y - Constants.STICK_HANDLECOLLISION_OFFSET){
			
			this.hitbox.reset();
			this.hitbox.addPoint(x, y);
			this.hitbox.addPoint(x + width, y + height);
		}
		this.hitbox.translate(cr.getxSpeed(), cr.getySpeed());
	}
	
	/**
	 * handles collision with the nest, resets itself and makes nest bigger
	 * @param n
	 * @author Tim Mazzarelli
	 */
		
	@Override
	public void handleCollision(Nest n) {
		if (this.collidesWith(n)) {
			hitbox.reset();
			n.hitbox.reset();
			if (Model.inTutoral == false) {
				count++;
			}
			
			this.visible = false;
			n.height = n.height + Constants.STICK_HANDLECOLLISION_OFFSET;
			n.width = n.width + Constants.STICK_HANDLECOLLISION_OFFSET;
			n.resetPoly();
			n.curImg ++;
		}
	}
	
	
	/**
	 * 
	 * @return int
	 */
	
	public static int getCount() {
		return count;
	}
	
	/**
	 * 
	 * @param count
	 */
	public static void setCount(int count) {
		Stick.count = count;
	}
	
	@Override
	public void move() {
		animate(Constants.STICK_ANIMATION_TICK_RATE);
	}
	public int getySpeed() {
		return ySpeed;
	}
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	
}
