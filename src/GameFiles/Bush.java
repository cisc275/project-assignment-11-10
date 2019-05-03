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
	 * @param imgPose
	 * @param width
	 * @param height
	 * @param xMin
	 * @param xMax
	 * @param yMin
	 * @param yMax
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
	
	@Override
	public void handleCollision(Fox f) {
		f.xSpeed = -f.xSpeed;
		f.ySpeed = -f.ySpeed;
		System.out.println(f.xSpeed);
		System.out.println(f.ySpeed);
		
	}
	
	
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
