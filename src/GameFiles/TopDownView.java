package GameFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
    protected DrawPanel drawPanel = new DrawPanel();
    
    /**
     * a Mark creation of the highest order, TDV object
     */
    protected TopDownView tdv = this;
    
    /**
     * the background image
     */
    protected BufferedImage background = createImage();
	
	/**
	 * escape key image
	 */
    protected BufferedImage escKey = createEsc();
	
   
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
	 */
	
	private class DrawPanel extends JPanel {
		
		/**
		 * this method paints our game upon our Draw(J)panel
		 * @param g ArrayList of GameObjects
		 * @author Peter Jenny
		 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.gray);
			g.drawImage(background, Constants.VIEW_ORIGIN, Constants.VIEW_ORIGIN, frame.getWidth(), frame.getHeight(), this);
			
			for (GameObject thing : game) {
				if (tdv.debugHitBoxes) g.drawPolygon(thing.hitbox);
				if (thing.visible)  g.drawImage(tdv.getImg(thing, thing.curImg),(int) thing.hitbox.getBounds2D().getMinX() ,(int) thing.hitbox.getBounds2D().getMinY(), this);
			}	
			// trying to draw life counter
			  for (int i = 0; i < ClapperRail.lives; i++) { 
				  g.drawImage(createLives(), 
						  (int)(View.frame.getWidth() - (Constants.FRAME_X * Constants.LIVES_X)*(i+Constants.LIVES_OFFSET)), 
						  Constants.VIEW_ORIGIN, (int)(Constants.FRAME_X * Constants.LIVES_X), 
						  (int) (Constants.FRAME_Y * Constants.LIVES_Y), this); 
			  }
			 g.drawImage(escKey, Constants.VIEW_ORIGIN, frame.getHeight()- (int)(Constants.FRAME_Y * Constants.ESCAPE_KEY_Y),
					 (int)(Constants.FRAME_X * Constants.ESCAPE_KEY_X),
					 (int)(Constants.FRAME_Y * Constants.ESCAPE_KEY_Y),this);
			
	
		}
			public Dimension getPreferredSize() {
			return new Dimension((int)Constants.getFRAME_X(), (int)Constants.getFRAME_Y());
		}
	}
	
	/**
	 * creates buffered image for background
	 * @return New BufferedImage to draw
	 * @author Peter Jenny
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
	 * @return New BufferedImage to draw
	 * @author Peter Jenny
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
	 * @return New BufferedImage to draw
	 * @author andrew thompson
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
	 * Adds a KeyListener to the controller
	 * @param controller The controller of the world.
	 * adds the controller as a keyListener
	 */
	public void addKeyListener(Controller controller) {
		frame.addKeyListener(controller);
	}
	
}
