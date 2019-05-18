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
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * 
	 * a constructor that takes values for all fields except currY as input parameters
	 */

	public Osprey(int x, int y, int width, int height) {
		super(x, y, width, height);
		//createImage();
		this.imgFileName = Constants.ANIMATION_OSPREY;
	//	this.img = imgs[0];
		Osprey.xSpeed = -10;
		this.ySpeed = 0;
		this.isDiving = false;
		distance = 0;
		MAX_Y_SPEED = (int)(height/3);
		this.setType(Type.OSPREY);
	}

	
	
	/**
	 * this method will be called whenever the user presses the dive button
	 * at which point the bird will dive into the water and possibly collect 
	 * fish or trash. the logic for this action will be contained here.
	 * 
	 * @author tim Mazzarelli
	 */
	public void dive() {
		if (this.hitbox.ypoints[0] <= Constants.OSPREY_WATER_LEVEL) {
			this.isDiving = !this.isDiving;
			this.ySpeed = Constants.OSPREY_DIVESPEED;
			this.currY = this.hitbox.ypoints[0];
			this.hitbox.translate(0, this.ySpeed);
			
		}
		
	}
	
	/**
	 * moves the osprey according to location and ySpeed determined by key inputs
	 * 
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void move() {	
		this.hitbox.translate(0, this.ySpeed);
		if (this.hitbox.ypoints[2] >= Constants.FRAME_Y) {
			this.ySpeed = -this.ySpeed;
		}	
		distance -= Osprey.xSpeed; 
		if ((this.hitbox.ypoints[0] <= this.currY) && (this.isDiving == true)) {
			System.out.println("hello");
			this.isDiving = !this.isDiving;
			this.ySpeed = 0;
		}
		boundaries();
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
	 * @return ySpeed
	 */
	public int getySpeed() {
		return ySpeed;
	}


	/**
	 * 
	 * @param ySpeed
	 */
	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
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

	
	


	/*
	
	@Override
	public void resetPoly() {
		int x1 = this.hitbox.xpoints[0];
		int x2 = this.hitbox.xpoints[1];
		int x3 = this.hitbox.xpoints[2];
		int x4 = this.hitbox.xpoints[3];
		int y1 = this.hitbox.ypoints[0];
		int y2 = this.hitbox.ypoints[1];
		int y3 = this.hitbox.ypoints[2];
		int y4 = this.hitbox.ypoints[3];
		this.hitbox.reset();
		this.hitbox.addPoint(x1, y1);
		this.hitbox.addPoint(x2, y2);
		this.hitbox.addPoint(x3, y3);
		this.hitbox.addPoint(x4, y4);
	}
	
	*/
	
	// creates image for Osprey
//	private BufferedImage[] createImage(){
//		
//		try {
//			if (Constants.BOOL_HARVEY) imgs[2] = ImageIO.read(new File(Constants.IMG_THARVEY));
//			else {  
//			//	imgs[0] = ImageIO.read(new File(Constants.IMG_OSPREY));
//			//	imgs[1] = ImageIO.read(new File(Constants.IMG_OSPREY_DIVE));
//			}
//			return imgs;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
