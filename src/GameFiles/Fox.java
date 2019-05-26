package GameFiles;


import java.util.ArrayList;


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
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * @param c         fox's clapper rail
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
	 */
	
	public Fox(int x, int y, int width, int height, ClapperRail c) {
		super(x,y,width,height);
		this.c = c;
		this.xSpeed = Constants.FOX_INIT_XSPEED;
		this.ySpeed = Constants.FOX_INIT_YSPEED;
		this.imgFileName = Constants.ANIMATION_FOX_LEFT;
		this.curImg = randy.nextInt(imgFileName.length);
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
		ClapperRail.lives += Constants.CLAPPER_RAIL_LIVE_LOSS;
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
		int xDistance = (int) (this.hitbox.getBounds2D().getMinX() - c.hitbox.getBounds2D().getMinX());
		int	yDistance = (int) (this.hitbox.getBounds2D().getMinY() - c.hitbox.getBounds2D().getMinY());
		return Math.sqrt(Math.pow(xDistance, Constants.FOX_SQUARED) + Math.pow(yDistance, Constants.FOX_SQUARED));
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
				this.xSpeed = ((c.hitbox.getBounds2D().getMinX() - this.hitbox.getBounds2D().getMinX()) * 
						(Math.sqrt(Math.pow(this.xSpeed, Constants.FOX_SQUARED) + Math.pow(this.ySpeed,  Constants.FOX_SQUARED))) / distance());
				this.ySpeed = ((c.hitbox.getBounds2D().getMinY() - this.hitbox.getBounds2D().getMinY()) * 
						(Math.sqrt(Math.pow(this.xSpeed, Constants.FOX_SQUARED) + Math.pow(this.ySpeed,  Constants.FOX_SQUARED))) / distance());
			}
			else {
				if(bushPause <= Constants.BUSH_PAUSE) {
					bushPause++;
				}
				else {
					bushColl = false;
					bushPause -= bushPause;
				}
			}
		}
		else if (!Model.inTutoral){
			
			int smoother = randSmooth/50;
			int multX = (int) (Math.random() * Constants.FOX_SQUARED);
			int multY = (int) (Math.random() * Constants.FOX_SQUARED);	
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
		else {	
			
			this.setYSpeed(Constants.FOX_T_SPEED);
		}
		
		if (this.xSpeed == 0 && this.ySpeed == 0) {
			this.setxSpeed(Constants.FOX_INIT_XSPEED);
			this.setySpeed(Constants.FOX_INIT_YSPEED);
		}
		this.hitbox.translate((int)(Constants.FOX_SPEED_MULTIPLIER *this.xSpeed),
				(int)(Constants.FOX_SPEED_MULTIPLIER * this.ySpeed));
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
			// top of screen
			if (this.hitbox.getBounds2D().getMinY() <= Constants.FRAME_Y - Constants.FRAME_Y) {
				int x1 = (int)this.hitbox.getBounds2D().getMinX();
				int x2 = (int)this.hitbox.getBounds2D().getMinX();
				int x3 = (int)this.hitbox.getBounds2D().getMaxX();
				int x4 = (int)this.hitbox.getBounds2D().getMaxX();
				
				this.hitbox.reset();
				this.hitbox.addPoint(x1, height - height);
				this.hitbox.addPoint(x2, height);
				this.hitbox.addPoint(x3, height);
				this.hitbox.addPoint(x4, height - height);
								
			}
			//bottom of screen
			if (this.hitbox.getBounds2D().getMaxY() >= Constants.FRAME_Y) {
				int x1 = (int)this.hitbox.getBounds2D().getMinX();
				int x2 = (int)this.hitbox.getBounds2D().getMinX();
				int x3 = (int)this.hitbox.getBounds2D().getMaxX();
				int x4 = (int)this.hitbox.getBounds2D().getMaxX();
				
				this.hitbox.reset();
				this.hitbox.addPoint(x1, Constants.FRAME_Y - height);
				this.hitbox.addPoint(x2, Constants.FRAME_Y);
				this.hitbox.addPoint(x3, Constants.FRAME_Y);
				this.hitbox.addPoint(x4, Constants.FRAME_Y - height);			
			}
			// right side of screen
			if (this.hitbox.getBounds2D().getMaxX() >= Constants.FRAME_X) {
				int y1 = (int)this.hitbox.getBounds2D().getMinY();
				int y2 = (int)this.hitbox.getBounds2D().getMaxY();
				int y3 = (int)this.hitbox.getBounds2D().getMaxY();
				int y4 = (int)this.hitbox.getBounds2D().getMinY();
				
				this.hitbox.reset();
				this.hitbox.addPoint(Constants.FRAME_X - width, y1);
				this.hitbox.addPoint(Constants.FRAME_X - width, y2);
				this.hitbox.addPoint(Constants.FRAME_X, y3);
				this.hitbox.addPoint(Constants.FRAME_X, y4);		
			}
			
			// left of screen
			if (this.hitbox.getBounds2D().getMinX() <= Constants.FRAME_X - Constants.FRAME_X) {
				int y1 = (int)this.hitbox.getBounds2D().getMinY();
				int y2 = (int)this.hitbox.getBounds2D().getMaxY();
				int y3 = (int)this.hitbox.getBounds2D().getMaxY();
				int y4 = (int)this.hitbox.getBounds2D().getMinY();
				
				this.hitbox.reset();
				this.hitbox.addPoint(width - width, y1);
				this.hitbox.addPoint(width - width, y2);
				this.hitbox.addPoint(width, y3);
				this.hitbox.addPoint(width, y4);		
			}
		}
		
	}

	/**
	 * @return the xSpeed
	 */
	public double getXSpeed() {
		return this.xSpeed;
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
	public double getYSpeed() {
		return this.ySpeed;
	}

	/**
	 * @param ySpeed the ySpeed to set
	 */
	public void setYSpeed(double ySpeed) {
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
