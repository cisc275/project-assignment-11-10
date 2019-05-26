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
	 * used to calculate pause after collision with bush
	 */
	public int bushPause = 0;
	
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
		this.imgFileName = Constants.ANIMATION_FOX_LEFT;
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
				if(bushPause <= 5) {
					bushPause += 1;
				}
				else {
					bushColl = false;
					bushPause = 0;
				}
			}
		}
		else if (!Model.inTutoral){
			
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
					xSpeed = -xSpeed;
					break;
				case 1 :
					break;
				default :
					System.out.println("bad rand");
				}
				switch(multY) {
				case 0 :
					ySpeed = -ySpeed;
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
		// tutorial movement
		else {
			//this.xSpeed = 1;
			this.ySpeed = -10;
		}
		
		if (this.xSpeed == 0 && this.ySpeed == 0) {
			this.xSpeed = 1;
			this.ySpeed = 1;
		}
		this.hitbox.translate(3 *(int) this.xSpeed,3 * (int) this.ySpeed);
		boundaries();
		
		if(this.xSpeed < 0) {
			if (Model.inTutoral) this.imgFileName = Constants.ANIMATION_FOX_LEFT_BAD;
			else this.imgFileName = Constants.ANIMATION_FOX_LEFT;
		}
		else if(this.xSpeed > 0) {
			if (Model.inTutoral) this.imgFileName = Constants.ANIMATION_FOX_RIGHT_BAD;
			else this.imgFileName = Constants.ANIMATION_FOX_RIGHT;
		}
		animate(Constants.FOX_ANIMATION_TICK_RATE);
	}
	
	@Override
	public void boundaries() {
		if (Model.inTutoral) {
			
		} else {
			if (this.hitbox.ypoints[0] <= 0) {
				int x1 = this.hitbox.xpoints[0];
				int x2 = this.hitbox.xpoints[1];
				int x3 = this.hitbox.xpoints[2];
				int x4 = this.hitbox.xpoints[3];
				
				this.hitbox.reset();
				this.hitbox.addPoint(x1, 0);
				this.hitbox.addPoint(x2, height);
				this.hitbox.addPoint(x3, height);
				this.hitbox.addPoint(x4, 0);
								
			}
			
			if (this.hitbox.ypoints[1] >= View.frame.getHeight()) {
				int x1 = this.hitbox.xpoints[0];
				int x2 = this.hitbox.xpoints[1];
				int x3 = this.hitbox.xpoints[2];
				int x4 = this.hitbox.xpoints[3];
				
				this.hitbox.reset();
				this.hitbox.addPoint(x1, View.frame.getHeight() - height);
				this.hitbox.addPoint(x2, View.frame.getHeight());
				this.hitbox.addPoint(x3, View.frame.getHeight());
				this.hitbox.addPoint(x4, View.frame.getHeight() - height);			
			}
			if (this.hitbox.xpoints[3] >= View.frame.getWidth()) {
				int y1 = this.hitbox.ypoints[0];
				int y2 = this.hitbox.ypoints[1];
				int y3 = this.hitbox.ypoints[2];
				int y4 = this.hitbox.ypoints[3];
				
				this.hitbox.reset();
				this.hitbox.addPoint(View.frame.getWidth() - width, y1);
				this.hitbox.addPoint(View.frame.getWidth() - width, y2);
				this.hitbox.addPoint(View.frame.getWidth(), y3);
				this.hitbox.addPoint(View.frame.getWidth(), y4);		
			}
			
			if (this.hitbox.xpoints[0] <= 0) {
				int y1 = this.hitbox.ypoints[0];
				int y2 = this.hitbox.ypoints[1];
				int y3 = this.hitbox.ypoints[2];
				int y4 = this.hitbox.ypoints[3];
				
				this.hitbox.reset();
				this.hitbox.addPoint(0, y1);
				this.hitbox.addPoint(0, y2);
				this.hitbox.addPoint(width, y3);
				this.hitbox.addPoint(width, y4);		
			}
		}
		
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
