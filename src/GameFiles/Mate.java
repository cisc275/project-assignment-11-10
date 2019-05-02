package GameFiles;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mate extends Bird {
	
	int xSpeed;
	static boolean caughtUp;
	
	public Mate(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, int xSpeed, boolean caughtUp) {
	super(x,y,width,height, hitbox, img);
	this.img = createImage();
	this.xSpeed = xSpeed;
	Mate.caughtUp = false;
	this.setType(Type.AIRCURRENT);
}

public void move() {
	
	if (Osprey.distance >= 500) {
	this.hitbox.translate(this.xSpeed, 0);
	}
	else {this.hitbox.translate(0, 0);}
}



@Override
public void handleCollision(Osprey o) {
	this.hitbox.reset();
	this.hitbox.addPoint(x, y);
	this.hitbox.addPoint(x, y + height);
	this.hitbox.addPoint(x + width, y + height);
	this.hitbox.addPoint(x + width, y);
	this.caughtUp = true;
}


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



