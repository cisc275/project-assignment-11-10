package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * represents the bush(es) that the clapperrail can use to hide
 *
 */
public class Bush extends NonControllable {
	

	/**
	 * @param x			x location on screen
	 * @param y			y location on screen
	 * @param width		image width
	 * @param height	image height
	 * 
	 *               a constructor that takes values for all fields as input
	 *               parameters
	 */
	public Bush(int x, int y, int width, int height) {
		super(x,y,width,height);
		//this.img = createImage();
		this.imgFileName = Constants.ANIMATION_BUSH;
		this.curImg = randy.nextInt(imgFileName.length);
	}
	
	/**
	 * calls ClapperRail handleCollision passing in this
	 * @param cr Game ClapperRail
	 * @author andrew thompson
	 */
	@Override
	public void handleCollision(ClapperRail cr) {
		cr.hidden = true;
	}
	
	
	/**
	 * handles collision with fox (prevents it from entering
	 * @param f Game Fox
	 * @author Tim Mazzarelli
	 */	
	@Override
	public void handleCollision(Fox f) {
		Fox.bushColl = true;
		f.boundaries();
		f.setxSpeed(-f.getXSpeed());
		f.setYSpeed(-f.getYSpeed());
	}
	
	
	/**
	 * bush doesn't avtually move, it just animates the bush for the tutorial
	 * @author andrew thompson
	 */
	@Override
	public void move() {
		animate(Constants.BUSH_ANIMATION_TICK_RATE);
	}
	
}
