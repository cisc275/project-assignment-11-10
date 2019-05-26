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
	
	/**
	 * tells you how long you have played the game for
	 */
	static int time = Constants.OSPREY_START_TIME;
	
	/**
	 *  the xSpeed which determines how fast you will travel (behind the scenes not actually)
	 */
	
	static int xSpeed;
	
	/**
	 *  for storing y before diving
	 */
	private int currY;
	
	/**
	 *  to check if the Osprey is diving
	 */
	private boolean isDiving;
	
	/**
	 * current distance of the Osprey
	 */
	
	static double distance = Constants.OSPREY_START_DISTANCE;
	
	/**
	 *  total distance the osprey can travel
	 */
	static double maxDistance = Constants.OSPREY_MAX_DISTANCE;
	

	
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
		Osprey.xSpeed = Constants.OSPREY_INIT_XSPEED;
		this.setySpeed(Constants.OSPREY_INIT_YSPEED);
		this.isDiving = false;
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
			this.currY = (int) this.hitbox.getBounds2D().getMinY();
			this.hitbox.translate(Constants.OSPREY_INIT_XSPEED, this.getySpeed());
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
		this.hitbox.translate(Constants.OSPREY_INIT_XSPEED, this.getySpeed());
		if (this.hitbox.getBounds2D().getMaxY() >= Constants.FRAME_Y) {
			this.setySpeed(-this.getySpeed());
		}
		if (Model.inTutoral == false) {
			distance -= Osprey.xSpeed; 
			time++;
		}
		if ((this.hitbox.getBounds2D().getMinY() <= this.currY) && (this.isDiving == true)) {
			this.isDiving = !this.isDiving;
			this.setySpeed(Constants.OSPREY_INIT_YSPEED);
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
	 * returns the current y that you are at, will be used
	 * to return to same place when diving
	 * @return currY
	 * @author Tim Mazzarelli
	 */
	public int getCurrY() {
		return currY;
	}


	/**
	 * where you set your current y
	 * @param currY
	 * @author Tim Mazzarelli
	 */
	public void setCurrY(int currY) {
		this.currY = currY;
	}


	/**
	 * tells you if the player is currently diving
	 * @return isDiving
	 * @author Timothy Mazzarelli
	 */
	public boolean getisDiving() {
		return isDiving;
	}


	/**
	 * you can set whether or not the player is diving
	 * @param isDiving
	 * @author Timothy Mazzarelli
	 */
	public void setDiving(boolean isDiving) {
		this.isDiving = isDiving;
	}


	/**
	 * you 
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
