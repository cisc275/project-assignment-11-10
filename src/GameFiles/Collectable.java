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
	 **/
  
	//a constructor that takes values for all fields as input parameters
	 
	public Collectable(int x, int y, int width, int height) {
		super(x,y,width,height);
		Random r = new Random();
		this.xSpeed = -r.nextInt(10) - 15;
	}
	
	// all collectables move according to xSpeed and will loop back around if need be
	
	public void move() {
		this.hitbox.translate(this.xSpeed, 0);
		if(this.hitbox.xpoints[3] <= 0) {
			resetPoly();
		}
	}


	public void handleCollision(Osprey o) {
		// TODO Auto-generated method stub
		
	}

	public void handleCollision(Nest n) {
		// TODO Auto-generated method stub
		
	}
	
}
