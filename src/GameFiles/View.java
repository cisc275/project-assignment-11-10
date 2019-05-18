package GameFiles;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

//import org.junit.jupiter.api.condition.OS;

/**
 * super class for all view objects  
 *
 */
public class View extends JFrame implements Serializable {

	/**
	 * serialVersionUID auto generated
	 */
	private static final long serialVersionUID = 1055664864359735273L;
	
	
	/**
	 * array list of our game objects
	 */
	ArrayList<GameObject> game;
	
	/**
	 * the frame upon which our game is drawn
	 */
	static JFrame frame; 
	
	/**
	 * Hashtable that uses GameObject as a key and arraylist of BI's
	 * as its value
	 */
	Hashtable<GameObject, ArrayList<BufferedImage>> imgTable;


	public boolean debugHitBoxes;
	
	/**
	 * 
	 * @return ArrayList<GameObject> game
	 */

	public ArrayList<GameObject> getGame() {
		return game;
	}
	
	/**
	 * 
	 * @param game
	 */

	public void setGame(ArrayList<GameObject> game) {
		this.game = game;
	}
	
	/**
	 * overwritten in sub classes
	 * @param game
	 */
	
	public void updateView(ArrayList<GameObject> game) {
		
	}
	
	/**
	 * overwritten in subclasses
	 * @param c
	 */
	
	public void addKeyListener(Controller c) {
		
	}
	
	/**
	 * overwritten in subclasses
	 * @param c
	 */
	public void addActionListener(Controller c) {
		
	}
	
	/**
	 * Default setup and full screen.
	 * @param frame JFrame item passed from the View Object
	 * @author Mark Wolgin
	 */
	public void setUpScreen(JFrame frame) {
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	if (System.getProperty("os.name").equals("Linux")) {
        	frame.setSize(Constants.LINUX_SCREEN_SCALE_X * Constants.LINUX_SCREEN_SIZE, Constants.LINUX_SCREEN_SCALE_Y * Constants.LINUX_SCREEN_SIZE);
        	frame.setVisible(true);
    	}
    	else {
        	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        	frame.setUndecorated(true);
        	frame.pack();
        	frame.setVisible(true);
    	}
    	//System.out.println(System.getProperty("os.name"));

    	Constants.setFrameX(frame.getWidth());
    	Constants.setFrameY(frame.getHeight());
	}
	
	public void initTable(ArrayList<GameObject> objects) {
		imgTable = new Hashtable<GameObject, ArrayList<BufferedImage>>();
		for (GameObject g: objects) {
			imgTable.put(g, getScaledImgs(g));
		}
	}
	
	
	/**
	 * @param g The GameObject to be scaled
	 * @return 	The default scale of the image
	 * @author Mark Wolgin
	 */
	public ArrayList<BufferedImage> getScaledImgs(GameObject g) {
		ArrayList<BufferedImage> toReturn = new ArrayList<BufferedImage>();
		BufferedImage ig, scaledImg;
		try {
			for (String s : g.imgFileName) {
				ig = ImageIO.read(new File(s));
	    		scaledImg = new BufferedImage(g.getWidth(), g.getHeight(), BufferedImage.TRANSLUCENT);
			    Graphics2D g2 = scaledImg.createGraphics();
			    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			    g2.drawImage(ig, 0, 0, g.getWidth(), g.getHeight(), null);
			    g2.dispose();
			    toReturn.add(scaledImg);
			}
    	} catch (IOException e) {
    		System.out.println("Image Load Failed " + g.imgFileName);
    		e.printStackTrace();
    	}
		
		return toReturn;
	}
	
	public BufferedImage getImg(GameObject g, int i) {
		ArrayList<BufferedImage> LoBI = imgTable.get(g);
		BufferedImage toReturn;
		
		if (LoBI == null) toReturn = this.addImage(g, i);
		else {
			if (LoBI.size() <= i) toReturn = addImageToArray(g);
			else toReturn = LoBI.get(i);
		}
		
		return toReturn;
	}

	/**
	 * Adds the GameObject and new ArrayList to the Hashtable if it was added after initTable was called.
	 * NOTE: This adds the image to the ArrayList.
	 * @param g GameObject to add the image of
	 * @param i	The location in the array that was tried.
	 * @return	Returns the newly created image
	 * @author Mark Wolgin
	 */
	private BufferedImage addImage(GameObject g, int i) {
		ArrayList<BufferedImage> toReturn = new ArrayList<BufferedImage>();
		BufferedImage ig, scaledImg;
		try {
			for (String s : g.imgFileName) {
				ig = ImageIO.read(new File(s));
	    		scaledImg = new BufferedImage(g.getWidth(), g.getHeight(), BufferedImage.TRANSLUCENT);
			    Graphics2D g2 = scaledImg.createGraphics();
			    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			    g2.drawImage(ig, 0, 0, g.getWidth(), g.getHeight(), null);
			    g2.dispose();
			    toReturn.add(scaledImg);
			}
    	} catch (IOException e) {
    		System.out.println("Image Load Failed " + g.imgFileName);
    		e.printStackTrace();
    	}
		imgTable.put(g, toReturn);
		return toReturn.get(i);
	}
	
	
	/**
	 * Adds an image (typicaly a new scaled version of it) to the ArrayList associated to the Hashtabele
	 * NOTE: This adds the image to the ArrayList.
	 * @param g GameObject to add the image of
	 * @return	The new image
	 * @author Mark Wolgin
	 */
	private BufferedImage addImageToArray(GameObject g) {
		BufferedImage newScaled;
		
		newScaled = new BufferedImage(g.getWidth(), g.getHeight(), BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = newScaled.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(imgTable.get(g).get(0), 0, 0, g.getWidth(), g.getHeight(), null);
	    g2.dispose();
	    imgTable.get(g).add(newScaled);
	    return newScaled;		
	}
}
