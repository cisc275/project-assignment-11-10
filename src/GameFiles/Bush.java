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
	 * @param hitbox
	 * @param img
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public Bush(int x, int y, int width, int height,Polygon hitbox, BufferedImage img) {
		super(x,y,width,height, hitbox, img);
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
	 * @author Tim 
	 */
	
	@Override
	public void handleCollision(Fox f) {
		f.xSpeed = -f.xSpeed;
		f.ySpeed = -f.ySpeed;
		
		
	}
	
	/**
	 * creates bush image
	 * 
	 */
	
	public BufferedImage getImage() {
		BufferedImage buffImg;
		try {
    		buffImg = ImageIO.read(new File("bush.png"));
    		return buffImg;
		} catch (IOException e) {
    		e.printStackTrace();
    	}
		return null;
	}

}
