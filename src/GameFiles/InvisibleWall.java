package GameFiles;


/**
 * class representing invisible wall in Osprey game between water
 * @author tmazz
 *
 */

public class InvisibleWall extends NonControllable {

	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
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
		if (!o.getisDiving()) {
			o.hitbox.reset();
			if (o.getySpeed() > Constants.OSPREY_INIT_YSPEED) {
				o.hitbox.addPoint(o.x, (int) (this.hitbox.getBounds2D().getMinY() - o.height));
				o.hitbox.addPoint(o.x, (int) this.hitbox.getBounds2D().getMinY());
				o.hitbox.addPoint(o.x + o.width, (int) this.hitbox.getBounds2D().getMinY());
				o.hitbox.addPoint(o.x + o.width, (int) (this.hitbox.getBounds2D().getMinY() - o.height));
			}
			else {
				o.hitbox.addPoint(o.x, (int) this.hitbox.getBounds2D().getMaxY());
				o.hitbox.addPoint(o.x, (int) (this.hitbox.getBounds2D().getMaxY()  + o.height) );
				o.hitbox.addPoint(o.x + o.width, (int) (this.hitbox.getBounds2D().getMaxY() + o.height));
				o.hitbox.addPoint(o.x + o.width, (int) this.hitbox.getBounds2D().getMaxY());
			}
		}
	}
}
