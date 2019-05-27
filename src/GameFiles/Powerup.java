package GameFiles;

/**
 * @author wolginm
 *
 */
public class Powerup extends Collectable {

	
	/**
	 * whether or not a collision with a powerup has occured
	 */
	public static boolean power = false;
	
	public int count;
	
	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
	 */
	public Powerup(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.setxSpeed(Constants.POWERUP_SPEED);
		this.imgFileName = Constants.ANIMATION_CRAB;
		this.curImg = randy.nextInt(imgFileName.length);
		count = 0;
	}

	/**
	 * @param cr Game ClapperRail
	 * 
	 * deals with collision with respect to ClapperRail
	 * 
	 * @author tim mazzarelli
	 */
	@Override
	public void handleCollision(ClapperRail cr) {
		resetPoly();
		cr.setxSpeed(Constants.CLAPPER_RAIL_START_XSPEED);
		cr.setySpeed(Constants.CLAPPER_RAIL_START_YSPEED);
		power = true;
		count++;
		new Quiz(Constants.TOP_DOWN_STRING);		
	}
	
	/**
	 * @param o Game Osprey
	 * deals with collision with respect to Osprey
	 * @author tim mazzarelli
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		Model.quizHappened = true;
		power = true;
		resetPoly();
		count++;
		new Quiz(Constants.SIDE_SCROLL_STRING);
	
	}
	
	/**
	 * How the powerup moves, also how it animates itself
	 * similar to all collectables
	 * according to it's tickrate
	 * @author Tim Mazzarelli
	 */
	
	@Override
	public void move() {
		this.hitbox.translate(this.getxSpeed(), Constants.COLLECTABLE_YSPEED);
		if(this.hitbox.getBounds2D().getMaxX() <= Constants.FRAME_X - Constants.FRAME_X) {
			resetPoly();
		}
		if (count >= Constants.QUIZ_QUESTIONS) {
			this.setxSpeed(Constants.POWERUP_SPEED - Constants.POWERUP_SPEED);
		}
		this.animate(Constants.CRAB_ANIMATION_TICK_RATE);
	}
	


}
