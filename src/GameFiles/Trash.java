package GameFiles;

import java.awt.Polygon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * represents trash that user can collect
 */
public class Trash extends Collectable {
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */	
	public Trash(int x, int y, int width, int height) {
		super(x,y,width,height);
		//this.img = createImage();
		this.imgFileName = Constants.ANIMATION_TRASH;
		this.curImg = randy.nextInt(imgFileName.length);
		this.setType(Type.TRASH);
	}
	
	/**
	 * handles collision with the Osprey, resets and decrements Osprey speed
	 * @param Osprey o
	 * @author Tim Mazzarelli
	 */
	
	@Override
	public void handleCollision(Osprey o) {
		resetPoly();
		o.setXSpeed((Osprey.getXSpeed() + Constants.TRASH_AC));
		if (Osprey.xSpeed <= Constants.OSPREY_MIN_SPEED) {
			o.setXSpeed(Constants.OSPREY_MIN_SPEED);
		}
	}
	
//	private BufferedImage createImage(){
//		BufferedImage bufferedImage;
//		//System.out.println("i am running");
//    	try {
//    		bufferedImage = ImageIO.read(new File(Constants.IMG_TRASH));
//    		return bufferedImage;
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    	}
//    	return null;
//	}
	
}
