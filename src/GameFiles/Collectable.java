package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;

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
	 * @param hitbox
	 * @param img
	 * @param xSpeed
	 * 
	 **/
  
	//a constructor that takes values for all fields as input parameters
	 
	public Collectable(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, int xSpeed) {
		super(x,y,width,height, hitbox, img);
		this.xSpeed = xSpeed;
	}
	
	// all collectables move according to xSpeed and will loop back around if need be
	
	public void move() {
		this.hitbox.translate(this.xSpeed, 0);
		if((this.hitbox.xpoints[3] <= 0)) {
			this.hitbox.reset();
			this.hitbox.addPoint(x, y);
			this.hitbox.addPoint(x, y + height);
			this.hitbox.addPoint(x + width, y + height);
			this.hitbox.addPoint(x + width, y);
		}
	}


	public void handleCollision(Osprey o) {
		// TODO Auto-generated method stub
		
	}

	public void handleCollision(Nest n) {
		// TODO Auto-generated method stub
		
	}
	
}
