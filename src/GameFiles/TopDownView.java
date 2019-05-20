package GameFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Top down view for clapperrail
 *
 */
public class TopDownView extends View{
	
	/**
	 * JPanel the game is drawn upon
	 */
    DrawPanel drawPanel = new DrawPanel();
    
    /**
     * a Mark creation of the highest order, TDV object
     */
    TopDownView tdv = this;
    
    /**
     * the background image
     */
	BufferedImage background = createImage();
	
	BufferedImage escKey = createEsc();
	
	/**
     * static array of CR images for tracking lives
     */
	//public static BufferedImage[];
	
	
   
	/**
     * 
     * @param g Array list of GameObjects
     * constructs a view based on the array list it is given
     */
	public TopDownView(ArrayList<GameObject> g) {
		View.frame = new JFrame();
		setUpScreen(View.frame);
		game = g;
    	View.frame.add(drawPanel);
    	drawPanel.setOpaque(true);
    	pack();
    	this.initTable(g);
    	this.setSize(View.frame.getWidth(), View.frame.getHeight());
	}
	
	
	
	/**
	 * 
	 * @param g Array list of GameObjects
	 * calls paint component to create images based on the current ArrayList
	 */
	public void updateView(ArrayList<GameObject> g) {
		game = g; 
		drawPanel.repaint();
    	//System.out.println(" " + Constants.getFRAME_X()  + " " + Constants.getFRAME_Y() );

	}
	
	/**
	 * the class that draws our Jpanel for our game
	 * @author tmazz
	 *
	 */
	
	private class DrawPanel extends JPanel {
		
		/**
		 * this method paints our game upon our Draw(J)panel
		 * @param g
		 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.gray);
			g.drawImage(background, 0, 0, frame.getWidth(), frame.getHeight(), this);
			
			for (GameObject thing : game) {
			//	g.setClip(thing.hitbox);
				if (tdv.debugHitBoxes) g.drawPolygon(thing.hitbox);
				if (thing.visible)  g.drawImage(tdv.getImg(thing, thing.curImg),thing.hitbox.xpoints[0] ,thing.hitbox.ypoints[0], this);
			}	
			// trying to draw life counter
			  for (int i = 0; i < ClapperRail.lives; i++) { 
				  g.drawImage(createLives(), View.frame.getWidth() - 100*(i+1), 0, 100, 100, this); 
			  }
			 g.drawImage(escKey, 0, frame.getHeight()-100,250,100,this);
			
	
		}
			public Dimension getPreferredSize() {
			return new Dimension((int)Constants.getFRAME_X(), (int)Constants.getFRAME_Y());
		}
	}
	
	/**
	 * creates buffered image for background
	 * @return BufferedImage
	 */
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(Constants.IMG_CLAPPER_RAIL_BACKGROUND));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * creates buffered image for life display
	 * @return BufferedImage
	 */
	private BufferedImage createLives(){
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(Constants.IMG_CLAPPER_RAIL_LEFT_1));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * creates buffered image for esc button
	 * @return BufferedImage
	 */
	private BufferedImage createEsc(){
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(Constants.IMG_ESC_KEY));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	/**
	 * 
	 * @param controller
	 * adds the controller as a keyListener
	 */
	public void addKeyListener(Controller controller) {
		frame.addKeyListener(controller);
	}
	
}
