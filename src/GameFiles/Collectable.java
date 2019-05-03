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


	public void handleCollision(Osprey o) {
		// TODO Auto-generated method stub
		
	}
	
}
