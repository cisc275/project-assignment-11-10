package GameFiles;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class Nest extends GameObject{
	
	protected int numSticks;
	
	public Nest(int x, int y, int width, int height, Polygon hitbox, BufferedImage img, int sticks) {
		super(x,y,width,height,hitbox,img);
		this.numSticks = sticks;
	}

}
