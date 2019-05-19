package GameFiles;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * represents the Fox object in the clapperrail game 
 *
 */
public class Fox extends Controllable {
	/**
	 * the speed with which you move left and right
	 */
	private double xSpeed;
	
	/**
	 * the speed with which you move up and down
	 */
	private double ySpeed;
	
	/** 
	 * speed of fox (pythagorean theorem)
	 */
	private double speed;
	
	/**
	 * for smoothing out the speed
	 */
	private int randSmooth;
	
	/**
	 * used for accessing clapper rail x and y coordinates
	 */
	
	private ClapperRail c;
	
	/**
	 * used to make bushes inaccessible by the fox when clapperrail is not hidden, true when the fox is colliding with a bush
	 */
	public static boolean bushColl = false;
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * @param c
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public Fox(int x, int y, int width, int height, ClapperRail c) {
		super(x,y,width,height);
		this.c = c;
		this.xSpeed = 1;
		this.ySpeed = -2;
		this.imgFileName = Constants.ANIMATION_FOX;
		this.curImg = randy.nextInt(imgFileName.length);
		//try {
    	//	this.img = ImageIO.read(new File(Constants.IMG_FOX));
		//} catch (IOException e) {
    	//	e.printStackTrace();
    	//}
	}
	
	/**
	 * overrides super method and checks arraylist for any possible collisions
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
	 * handles collision with clapperrail
	 * @param c
	 * @author tim Mazzarelli
	 */
	@Override
	public void handleCollision(ClapperRail c) {
		ClapperRail.lives -= 1;
		c.resetPoly();
		this.resetPoly();
		xSpeed = Constants.FOX_INIT_XSPEED;
		ySpeed = Constants.FOX_INIT_YSPEED;
	
	}
	
	/**
	 * calculates distance between fox and clapperrail
	 * @param g
	 * @author tim Mazzarelli
	 */
		
	public double distance() {	
		int xDistance = this.hitbox.xpoints[0] - c.hitbox.xpoints[0];
		int	yDistance = this.hitbox.ypoints[0] - c.hitbox.ypoints[0];
		return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
		}
		
	/**
	 * moves the fox according to calculated xSpeed and ySpeed 
	 * based on clapperrail position, assigns random movement if 
	 * CR is hidden
	 * @param g
	 * @author tim Mazzarelli
	 */
	
	@Override
	public void move() {
		
		if(!c.hidden) {
			if(!bushColl) {
				this.xSpeed = ((c.hitbox.xpoints[0] - this.hitbox.xpoints[0]) * 
						(Math.sqrt(Math.pow(this.xSpeed, 2) + Math.pow(this.ySpeed,  2))) / distance());
				this.ySpeed = ((c.hitbox.ypoints[0] - this.hitbox.ypoints[0]) * 
						(Math.sqrt(Math.pow(this.xSpeed, 2) + Math.pow(this.ySpeed,  2))) / distance());
			}
			else {
				bushColl = false;
			}
		}
		else {
			
			int smoother = randSmooth/50;
			int multX = (int) (Math.random() * 2);
			int multY = (int) (Math.random() * 2);	
			// ensures non-zero random movement
			switch((int)xSpeed) {
			case 0 :
				xSpeed = ySpeed;
				break;
			}
			switch((int)ySpeed) {
			case 0 :
				ySpeed = xSpeed;
				break;
			}
			// assigns random movement
			switch(smoother) {
			case 1 :
				randSmooth = 0;
				switch(multX) {
				case 0 :
					xSpeed *= -1;
					break;
				case 1 :
					break;
				default :
					System.out.println("bad rand");
				}
				switch(multY) {
				case 0 :
					ySpeed *= -1;
					break;
				case 1 :
					break;
				default :
					System.out.println("bad rand");
				}
				break;
			case 0 :
				
				randSmooth += 1;
			}
		}	
		
		if (this.xSpeed == 0 && this.ySpeed == 0) {
			this.xSpeed = 1;
			this.ySpeed = 1;
		}
		this.hitbox.translate(2 *(int) this.xSpeed,2 * (int) this.ySpeed);
		boundaries();
	}

	/**
	 * @return the xSpeed
	 */
	public double getxSpeed() {
		return xSpeed;
	}

	/**
	 * @param xSpeed the xSpeed to set
	 */
	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * @return the ySpeed
	 */
	public double getySpeed() {
		return ySpeed;
	}

	/**
	 * @param ySpeed the ySpeed to set
	 */
	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @return the c
	 */
	public ClapperRail getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(ClapperRail c) {
		this.c = c;
	}
	
}	
