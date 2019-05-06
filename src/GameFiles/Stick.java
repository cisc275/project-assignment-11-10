package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * attributes for all sticks in the game
 *
 */
public class Stick extends Collectable{
	int ySpeed;
	/**
	 * the number of sticks the that have been collected
	 */
	static int count; 
	/**
	 * whether or not the bird is holding the stick
	 */

	static boolean onScreen;
	/**
	 * @param y
	 * @param x
	 * @param height
	 * @param width
	 * @param hitbox
	 * @param img
	 * @param xSpeed
	 * @param ySpeed
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public Stick(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, int xSpeed, int ySpeed) {
		super(x,y,width,height, hitbox, img, xSpeed);
		this.ySpeed = ySpeed;
		this.setType(Type.STICK);
		
	}
	/**
	 * calls ClapperRail handleCollision passing in this
	 * @param cr
	 * @author andrew thompson
	 */
	
	
	public void handleCollision(ClapperRail cr) {
		this.hitbox.translate(cr.xSpeed, cr.ySpeed);
	}
		
	@Override
	public void handleCollision(Nest n) {
		if (this.collidesWith(n)) {
			this.hitbox.reset();
			n.hitbox.reset();
			n.height = n.height + 30;
			n.width = n.width + 30;
			n.hitbox.addPoint(n.x, n.y);
			n.hitbox.addPoint(n.x , n.y + n.height);
			n.hitbox.addPoint(n.x + n.width,n.y + n.height);
			n.hitbox.addPoint(n.x + n.width, n.y);
	}
	}
	
	
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Stick.count = count;
	}
	
	
}
