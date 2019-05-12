package GameFiles;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Background{
	private BufferedImage image;
	 
    private int x;
    private int y;
    
   
    public Background() {
        this(0,0);
    }
    
    /**
     * @param x
     * @param y
     * 
     * constructor for Background
     */
 
    public Background(int x, int y) {
        this.x = x;
        this.y = y;
        
        // Try to open the image file background.png
        try {
            image = ImageIO.read(new File(Constants.IMG_BACKGROUND));
            image = (BufferedImage) image.getScaledInstance(Constants.FRAME_X, Constants.FRAME_Y, Image.SCALE_SMOOTH);
        }
        catch (Exception e) { System.out.println(e); }
     
 
    }
 
    /**
     * Method that draws the image onto the Graphics object passed
     * @param window
     * @author Tim Mazzarelli
     */
    public void draw(Graphics window) {
    	
    	if (this.x <= -image.getWidth()) {
            this.x += image.getWidth() * 2;
        }
    	
    	System.out.println(image.getWidth());
        window.drawImage(image, getX(), getY(), Constants.FRAME_X, Constants.FRAME_Y, null);        
 
    }
    
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getImageWidth() {
        return image.getWidth();
    }

	
 
}
