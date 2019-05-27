package GameFiles;

/**
 * represents trash that user can collect
 * @author Melvin Tejada
 */
public class Trash extends Collectable {
	/**
	 * @param y		The y location of the object
	 * @param x		The x location of the object
	 * @param width	The width of the object
	 * @param height	The height of the object
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */	
	public Trash(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.imgFileName = Constants.ANIMATION_TRASH;
		this.curImg = randy.nextInt(imgFileName.length);
	}
	
	/**
	 * handles collision with the Osprey, resets and decrements Osprey speed
	 * @param o The Osprey
	 * @author Tim Mazzarelli
	 */
	@Override
	public void handleCollision(Osprey o) {
		Osprey.negHitOs = true;
		resetPoly();
		o.setXSpeed((Osprey.getXSpeed() + Constants.TRASH_AC));
		if (Osprey.xSpeed >= Constants.OSPREY_MIN_SPEED) {
			o.setXSpeed(Constants.OSPREY_MIN_SPEED);
		}
	}
		
}
