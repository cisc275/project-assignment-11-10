package GameFiles;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import org.junit.jupiter.api.condition.OS;

/**
 * super class for all view objects  
 *
 */


public class View extends JFrame implements Serializable {

	/**
	 * serialVersionUID auto genorated
	 */
	private static final long serialVersionUID = 1055664864359735273L;
	
	
	
	ArrayList<GameObject> game;
	static JFrame frame; 
	Hashtable<GameObject, ArrayList<BufferedImage>> imgTable;
	
	

	public ArrayList<GameObject> getGame() {
		return game;
	}

	public void setGame(ArrayList<GameObject> game) {
		this.game = game;
	}
	
	public void updateView(ArrayList<GameObject> game) {
		
	}
	
	public void addKeyListener(Controller c) {
		
	}
	
	public void addActionListener(Controller c) {
		
	}
	
	/**
	 * Default setup and full screen.
	 * @param frame JFrame item passed from the View Object
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
		return imgTable.get(g).get(i);
	}
	
}
