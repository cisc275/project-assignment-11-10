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
	
	public Mate(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.imgFileName = Constants.ANIMATION_MATE;
		Mate.caughtUp = false;
		this.xSpeed = -10;
	
	}
	
	/**
	 * handles moving when the osprey has caught up
	 * @author tim Mazzarelli
	 */

	public void move() {
		if (this.hitbox.xpoints[0] == Constants.OSPREY_STARTX) {
			this.hitbox.reset();
			Mate.caughtUp = true;
		}
		else if (Osprey.distance >= Osprey.maxDistance) {
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
	resetPoly();
	Mate.caughtUp = true;
	
}

// draw the mate

private BufferedImage createImage(){
	BufferedImage bufferedImage;
	//System.out.println("i am running");
	try {
		if (Constants.BOOL_HARVEY) bufferedImage = ImageIO.read(new File(Constants.IMG_MATE));
		else bufferedImage = ImageIO.read(new File(Constants.IMG_POLY_HARVEY));
		return bufferedImage;
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}


}



