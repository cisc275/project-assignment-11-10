package GameFiles;


/**
 * class representing invisible wall in Osprey game between water
 * @author tmazz
 *
 */

public class InvisibleWall extends NonControllable {

	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * 
	 * Constructor for Invisible wall taking in all parameters
	 */
	
	public InvisibleWall(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.hitbox.addPoint(x, y);
	}
	
	/**
	 * handles collision with Osprey, you can't go through the invisible wall unless
	 * you are diving
	 * @param Osprey o
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		if (!o.isDiving) {
			o.hitbox.reset();
			o.hitbox.addPoint(o.x, this.hitbox.ypoints[0] - o.height);
			o.hitbox.addPoint(o.x, this.hitbox.ypoints[0]);
			o.hitbox.addPoint(o.x + o.width, this.hitbox.ypoints[0]);
			o.hitbox.addPoint(o.x + o.width, this.hitbox.ypoints[0] - o.height);
		}
	}
}
