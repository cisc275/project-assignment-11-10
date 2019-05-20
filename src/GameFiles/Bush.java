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
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public Bush(int x, int y, int width, int height) {
		super(x,y,width,height);
		//this.img = createImage();
		this.imgFileName = Constants.ANIMATION_BUSH;
		this.curImg = randy.nextInt(imgFileName.length);
		this.setType(Type.BUSH);
	}
	
	/**
	 * calls ClapperRail handleCollision passing in this
	 * @param cr
	 * @author andrew thompson
	 */
	@Override
	public void handleCollision(ClapperRail cr) {
		cr.hidden = true;
	}
	
	
	/**
	 * handles collision with fox (prevents it from entering
	 * @param f
	 * @author Tim Mazzarelli
	 */
	
	@Override
	public void handleCollision(Fox f) {
		Fox.bushColl = true;
		//System.out.println("fox hits bush");
		f.boundaries();
	//	System.out.println("fox init speed: " + f.getxSpeed() + ", " + f.getySpeed());
		f.setxSpeed(-f.getxSpeed());
		f.setySpeed(-f.getySpeed());
	//	System.out.println("fox post speed: " + f.getxSpeed() + ", " + f.getySpeed());
	}
	
	@Override
	public void move() {
		animate(Constants.BUSH_ANIMATION_TICK_RATE);
	}
	
	/**
     * returns a BufferedImage that is unscaled
     * @author Mark Wolgin
     */
	//public BufferedImage createImage() {
	//	BufferedImage bufferedImage;
    //	try {
    //		bufferedImage = ImageIO.read(new File(Constants.IMG_BROWN_SQUARE));
    //		return bufferedImage;
    //	} catch (IOException e) {
    //		e.printStackTrace();
    //	}
    //	return null;
	//}
	
	/**
	 * creates bush image
	 * 
	 */
	/*
	public BufferedImage getImage() {
		BufferedImage buffImg;
		try {
    		buffImg = ImageIO.read(new File(Constants.IMG_BUSH));
    		return buffImg;
		} catch (IOException e) {
    		e.printStackTrace();
    	}
		return null;
	}
*/
}
