package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// mate of the osprey

public class Mate extends Bird {
	
	int xSpeed;
	
	// if the Osprey has gone far enough to catch his or her mate
	static boolean caughtUp;
	
	/**
	 * @param y
	 * @param x
	 * @param width
	 * @param height
	 * @param hitbox
	 * @param img
	 * @param xSpeed
	 * @param caughtUp
	 * 
	 * a constructor that takes values for all fields as input parameters
	 */
	
	public Mate(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, int xSpeed, boolean caughtUp) {
		super(x,y,width,height, hitbox, img);
		this.img = createImage();
		this.xSpeed = xSpeed;
		Mate.caughtUp = false;
	
	}
	
	/**
	 * handles moving when the osprey has caught up
	 * @author tim Mazzarelli
	 */

	public void move() {
		if (Osprey.distance >= 500) {
			this.hitbox.translate(this.xSpeed, 0);
		}
		else {
			this.hitbox.translate(0, 0);
			}
	}


	/**
	 * handles collision with osprey, game has been one and now to the quiz
	 * @param o
	 * @author tim Mazzarelli
	 */

@Override
public void handleCollision(Osprey o) {
	this.hitbox.reset();
	this.hitbox.addPoint(x, y);
	this.hitbox.addPoint(x, y + height);
	this.hitbox.addPoint(x + width, y + height);
	this.hitbox.addPoint(x + width, y);
	Mate.caughtUp = true;
}

// draw the mate

private BufferedImage createImage(){
	BufferedImage bufferedImage;
	//System.out.println("i am running");
	try {
		bufferedImage = ImageIO.read(new File("red_square.png"));
		return bufferedImage;
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}


}



