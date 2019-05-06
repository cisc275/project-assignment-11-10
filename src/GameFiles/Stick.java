package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;

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
		if (this.hitbox.xpoints[0] <= 50 && this.hitbox.ypoints[0] <= 50) {
			this.hitbox.translate(0, 0);
		}
		else {
		this.hitbox.translate(cr.xSpeed, cr.ySpeed);
	}
	}
	
	
	/**
	 * calls Nest handleCollision passing in this
	 * @param a nest
	 * @author Peter Jenny
	 */
	
	
	public void handleCollision(GameObject n) {
		System.out.println("*****************************************************stick collide");
		System.out.println("*****************************************************nest collide");
		((Nest)n).numSticks += 1;
		hitbox.reset();
	}
	
	
	
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Stick.count = count;
	}
	
	
}
