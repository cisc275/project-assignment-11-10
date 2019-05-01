package GameFiles;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class BackgroundSideScroll extends Canvas{
	 private Background backOne;
	    private Background backTwo;
	 
	    private BufferedImage back;
	 
	    public BackgroundSideScroll() {
	        backOne = new Background();
	        backTwo = new Background(backOne.getImageWidth(), 0);
	 
	       
	    }
	 
	    @Override
	    public void update(Graphics window) {
	        paint(window);
	    }
	 
	    public void paint(Graphics window) {
	        Graphics2D twoD = (Graphics2D)window;
	 
	        if (back == null)
	            back = (BufferedImage)(createImage(getWidth(), getHeight()));
	 
	        // Create a buffer to draw to
	        Graphics buffer = back.createGraphics();
	 
	        // Put the two copies of the background image onto the buffer
	        backOne.draw(buffer);
	        backTwo.draw(buffer);

	        // Draw the image onto the window
	        twoD.drawImage(back, null, 0, 0);
	 
	    }
	 
	}

}
