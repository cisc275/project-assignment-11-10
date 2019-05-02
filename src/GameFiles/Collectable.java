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
	 * will be used to describe which object is being collected
	 */
	int id; 
	/**
	 * will describe if it helps or hurts the birds collecting and by how much
	 */
	int benefit; 
	int xSpeed;
	
	/**
	 * @param y
	 * @param x
	 * @param imgPose
	 * @param width
	 * @param height
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	

	public Collectable(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, int xSpeed) {
		super(x,y,width,height, hitbox, img);
		this.xSpeed = xSpeed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBenefit() {
		return benefit;
	}

	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}

	public void handleCollision(Osprey o) {
		// TODO Auto-generated method stub
		
	}
	
}
