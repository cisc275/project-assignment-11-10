package GameFiles;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * View that scrolls sideways for the Osprey game 
 */

public class SideScrollView extends View{
    
	/**
	 * panel on which our game is drawn
	 */
	DrawPanel drawPanel = new DrawPanel();
	
	/**
	 * array list of our game objects
	 */
    ArrayList<GameObject> game;
    
    /**
     * SideScrollView object
     */
    SideScrollView ssv = this;
   
    /**
     * win screen image
     */
    BufferedImage youWin;
    
    /**
     * image of the current minimap
     */
    BufferedImage currentMap;
    
    /**
     * how many bufferedImages we have
     */
    final int numOfMaps = 21;
    
    /**
     * how many lightning bolts we want to draw
     */
    final int numOfSpeeds = 6;
    
    /**
     * the maps all in one array
     */
    BufferedImage[] miniMaps = initMaps();
    /**
     * the bolts all in one array
     */
    BufferedImage[] speeds = initSpeeds();
    
    /**
     * what number map we are on
     */
    int mapNum = 0;
    
    int speedNum = 0;
   
 
    /**
     * creates the view using the arraylist of game objects
     * @param g
     */
    public SideScrollView(ArrayList<GameObject> g){
		frame = new JFrame();
		setUpScreen(frame);
		game = g;
    	frame.add(drawPanel);
    	drawPanel.setOpaque(true);
    	pack();
    	youWin = createImage();
    	this.setSize(frame.getWidth(), frame.getHeight());
    	this.initTable(g);
      	
    }
    
    /**
     * updates the view according to our arraylist of game objects
     * 
     */
    
    public void updateView(ArrayList<GameObject> g) {
    	game = g;
    	mapNum = (int)((Osprey.distance/Osprey.maxDistance)*numOfMaps);
    //	System.out.println(Osprey.distance/Osprey.maxDistance);
    	if(mapNum>numOfMaps-1)
    		mapNum = numOfMaps-1;
    	drawPanel.repaint();
    	speedNum = (int)((double)(Osprey.xSpeed)/(Constants.OSPREY_MAX_SPEED-Constants.OSPREY_MIN_SPEED)*numOfSpeeds);
    }
    
    /**
     * creates gameOver image
     * @return BufferedImage
     */
	
	private BufferedImage createImage(){
		BufferedImage bufferedImage;
		//System.out.println("i am running");
    	try {
    		bufferedImage = ImageIO.read(new File("img/Winner.png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	}
	
	/**
	 * class that gives us our JPanel to draw
	 */
    
    private class DrawPanel extends JPanel {
    	
    	/**
    	 * draws our game
    	 * @param g
    	 */
		protected void paintComponent(Graphics g) {
			if (!Mate.caughtUp) {
				super.paintComponent(g);
				Color transparent = new Color(1f,0f,0f,.5f );
				g.setColor(transparent);
			    AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f);
		    	for (GameObject thing : game) {
		    		if (thing.visible != true) {}
			    		else {
			    			if (ssv.debugHitBoxes)g.drawPolygon(thing.hitbox);
			    			if (thing.hitbox.npoints == Constants.INVISIBLE_WALL_POINTS);
			    			if (thing.hitbox.npoints != Constants.INVISIBLE_WALL_POINTS) {	
			    				g.drawImage(ssv.getImg(thing, thing.curImg), thing.hitbox.xpoints[0] ,thing.hitbox.ypoints[0], this);
			    			}
			    			if (thing.hitbox.npoints > 6) {
				    			g.drawImage(ssv.getImg(thing, thing.curImg), thing.hitbox.xpoints[4], thing.hitbox.ypoints[4], this);
				    		}
		    		}
		    	}
		    	g.drawImage(miniMaps[mapNum], View.frame.getWidth() -miniMaps[mapNum].getWidth(), 0, this);
		    	
		    	for(int i=speedNum;i > 0;i--) {
		    		g.drawImage(speeds[speedNum], View.frame.getWidth()-(speeds[speedNum].getWidth()*i), miniMaps[mapNum].getHeight(), this);
		    	}
				}
			/*
			 * else if (Mate.caughtUp){
			 * 
			 * g.drawImage(youWin, 0, 0, this.getWidth(), this.getHeight(), this); }
			 */	
		}
    }
    	/**
    	 * the size of our screen (full screen)
    	 * @return Dimension
    	 */
		public Dimension getPreferredSize() {
			return new Dimension((int)Constants.getFRAME_X(), (int)Constants.getFRAME_Y());
		}
	
	/**
	 * adds key listener to controller to move osprey around
	 */
    public void addKeyListener(Controller controller) {
		frame.addKeyListener(controller);
	}
    
    /**
     * creates the array of buffered images for the minimap
     * @return BufferedImage[]
     * @author Andrew Thompson
     */
    public BufferedImage[] initMaps() {
    	BufferedImage[] maps = new BufferedImage[numOfMaps];
    	for(int i=0;i<numOfMaps;i++) {
    		BufferedImage map = null;
	    	try {
	    		map = ImageIO.read(new File("img/map/oMap"+i+".png"));
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	}
	    	maps[i] = map;
    	}
    	return maps;
    }
    public BufferedImage[] initSpeeds() {
    	BufferedImage[] speeds = new BufferedImage[numOfSpeeds];
    	for(int i=0;i<numOfSpeeds;i++) {
    		BufferedImage speed = null;
	    	try {
	    		speed = ImageIO.read(new File("img/fish/fish_tiny.png"));
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	}
	    	speeds[i] = speed;
    	}
    	return speeds;
    }
    
}
