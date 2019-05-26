package GameFiles;

import java.awt.Polygon;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


/**
 * represents the osprey in the top down view game 
 *
 */
public class Osprey extends Bird {
	
	int count = 0;
	static int time = 0;
	int lowCount = 0;
	/**
	 *  the xSpeed which determines how fast you will travel (behind the scenes not actually)
	 */
	
	static int xSpeed;
	
	/**
	 *  for storing y before diving
	 */
	int currY;
	
	/**
	 *  to check if the Osprey is diving
	 */
	boolean isDiving;
	
	/**
	 * current distance of the Osprey
	 */
	
	static double distance;
	
	/**
	 *  total distance the osprey can travel
	 */
	static double maxDistance = Constants.OSPREY_MAX_DISTANCE;
	
	/**
	 *  maximum y speed
	 */
	
	final int MAX_Y_SPEED;
	
	/**
	 *  will be used to indicate if the osprey has made a negative collision
	 */
	static public boolean negHitOs = false;
	
	/**
	 * will be used to indicate if the osprey has made a positive collision
	 */
	static public boolean posHitOs = false;
	
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * 
	 * a constructor that takes values for all fields except currY as input parameters
	 */

	public Osprey(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.imgFileName = Constants.ANIMATION_OSPREY;
		this.curImg = randy.nextInt(imgFileName.length);
		Osprey.xSpeed = -10;
		this.setySpeed(0);
		this.isDiving = false;
		distance = 0;
		MAX_Y_SPEED = (int)(height/4);
		this.setType(Type.OSPREY);
		Osprey.time = 0;
	}

	
	
	/**
	 * this method will be called whenever the user presses the dive button
	 * at which point the bird will dive into the water and possibly collect 
	 * fish or trash. the logic for this action will be contained here.
	 * 
	 * @author tim Mazzarelli
	 */
	public void dive() {
			this.isDiving = !this.isDiving;
			this.setySpeed(Constants.OSPREY_DIVESPEED);
			this.currY = this.hitbox.ypoints[0];
			this.hitbox.translate(0, this.getySpeed());
		}
		
	
	/**
	 * moves the osprey according to location and ySpeed determined by key inputs
	 * 
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void move() {
		if (Osprey.xSpeed < Constants.OSPREY_MAX_SPEED) {
			Osprey.xSpeed = Constants.OSPREY_MAX_SPEED;
		}
		if (this.hitbox.ypoints[0] <= this.height) {
			count++;
			if (count % 30 == 0) {
				Osprey.xSpeed -= 1;
			}
		}
		if (this.hitbox.ypoints[1] >= Constants.FRAME_Y - this.height) {
			lowCount++;
			if (lowCount % 30 == 0) {
				Osprey.xSpeed += 1;
			}
		}
		this.hitbox.translate(0, this.getySpeed());
		if (this.hitbox.ypoints[2] >= Constants.FRAME_Y) {
			this.setySpeed(-this.getySpeed());
		}
		if (Model.inTutoral == false) {
			distance -= Osprey.xSpeed; 
			time++;
		}
		if ((this.hitbox.ypoints[0] <= this.currY) && (this.isDiving == true)) {
			this.isDiving = !this.isDiving;
			this.setySpeed(0);
		}
		boundaries();
		this.animate(Constants.OSPREY_ANIMATION_TICK_RATE);
	}
	
	/**
	 * checks for collision in ArrayList of gameobjects and sends to handleCollision accordingly
	 * @param g
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void collision(ArrayList<GameObject> g) {
		for (GameObject a : g) {
			if (this.collidesWith(a)){
				a.handleCollision(this);
			}
		}		
	}


	/**
	 * 
	 * @return currY
	 */
	public int getCurrY() {
		return currY;
	}


	/**
	 * 
	 * @param currY
	 */
	public void setCurrY(int currY) {
		this.currY = currY;
	}


	/**
	 * 
	 * @return isDiving
	 */
	public boolean isDiving() {
		return isDiving;
	}


	/**
	 * 
	 * @param isDiving
	 */
	public void setDiving(boolean isDiving) {
		this.isDiving = isDiving;
	}


	/**
	 * 
	 * @return MAX_Y_SPEED
	 */
	public int getMaxYSpeed() {
		return MAX_Y_SPEED;
	}


	/**
	 * 
	 * @param xSpeed
	 */
	public void setXSpeed(int xSpeed) {
		Osprey.xSpeed = xSpeed;
		
	}

	
	/**
	 * @return Osprey.xSpeed
	 */
	public static int getXSpeed() {
		// TODO Auto-generated method stub
		return Osprey.xSpeed;
	}
	
}
