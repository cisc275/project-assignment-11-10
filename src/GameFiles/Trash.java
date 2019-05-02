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
	
	final static int AC = 1;
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
	 * @param id
	 * @param benefit
	 * @param type
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public Trash(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, int xSpeed) {
		super(x,y,width,height, hitbox, img, xSpeed);
		this.img = createImage();
		this.setType(Type.TRASH);
	}
	
	public void move() {
		this.hitbox.translate(this.xSpeed, 0);
		if((this.hitbox.xpoints[3] <= 0)) {
			this.hitbox.reset();
			this.hitbox.addPoint(x, y);
			this.hitbox.addPoint(x, y + height);
			this.hitbox.addPoint(x + width, y + height);
			this.hitbox.addPoint(x + width, y);
			System.out.println(this.hitbox.getBounds());
				
		}
	}
	
	@Override
	public void handleCollision(Osprey o) {
		this.hitbox.reset();
		this.hitbox.addPoint(x, y);
		this.hitbox.addPoint(x, y + height);
		this.hitbox.addPoint(x + width, y + height);
		this.hitbox.addPoint(x + width, y);
		if (Osprey.xSpeed <= -2) {
		o.setXSpeed(Osprey.getXSpeed() + AC);
		}
		else {};
	}
	
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("green_square.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}

	
}
