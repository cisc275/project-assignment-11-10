package GameFiles;

import java.awt.Polygon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

/**
 * 
 *represents all collectable items in both games
 */
public class Collectable extends GameObject {
	

	/**
	 * describes the speed with which collectables move, also the benefit
	 */
	
	int xSpeed;
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * 
	 * a constructor that takes values for all fields as input parameters
	 **/
 	 
	public Collectable(int x, int y, int width, int height) {
		super(x,y,width,height);
		Random r = new Random();
		this.xSpeed = -r.nextInt(10) - 15;
	}
	
	/**
	 * moves the aircurrent according to x speed and resets if it goes back over the left screen
	 * @author Tim Mazzarelli
	 */
	
	public void move() {
		this.hitbox.translate(this.xSpeed, 0);
		if(this.hitbox.xpoints[3] <= 0) {
			resetPoly();
		}
	}



	
}
