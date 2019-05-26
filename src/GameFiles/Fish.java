package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * represents fish that will give both birds a boost
 *
 */
public class Fish extends Collectable {
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * @param hitbox
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */

	public Fish(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.imgFileName = Constants.ANIMATION_FISH;
		this.curImg = randy.nextInt(imgFileName.length);
	}
	
	

	/** handles fish collision with osprey
	 * @param o
	 * @author Timothy Mazzarelli
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		Osprey.posHitOs = true; // for animation, positive hit
		resetPoly();
		o.setXSpeed((Osprey.getXSpeed() - Constants.FISH_AC));
		if (Osprey.xSpeed <= Constants.OSPREY_MAX_SPEED) { // don't want osprey moving too quick;y
			o.setXSpeed(Constants.OSPREY_MAX_SPEED);
			}
	}
	
	@Override
	public void move() {
		this.hitbox.translate(this.getxSpeed(), 0);
		if(this.hitbox.getBounds2D().getMaxX() <= 0) {
			resetPoly();
		}
		animate(Constants.FISH_ANIMATION_TICK_RATE);	
	}
	
	
//	 creates image for fish
//	
//	private BufferedImage createImage(){
//		BufferedImage bufferedImage;
//		//System.out.println("i am running");
//    	try {
//    		bufferedImage = ImageIO.read(new File(Constants.IMG_FISH));
//    		return bufferedImage;
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    	}
//    	return null;
//	}
}
