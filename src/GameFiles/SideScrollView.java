package GameFiles;

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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * View that scrolls sideways for the Osprey game 
 */

public class SideScrollView extends View{
    DrawPanel drawPanel = new DrawPanel();
    ArrayList<GameObject> game;
    JFrame frame;
    Background backOne;
    Background backTwo;
    BufferedImage back;
    BufferedImage youWin;
    BufferedImage currentMap;
    final int numOfMaps = 10;
    BufferedImage[] miniMaps = initMaps();
    int mapNum = 0;
    
    public SideScrollView(ArrayList<GameObject> g, Background backOne, Background backTwo){
		frame = new JFrame();
		game = g;
    	frame.add(drawPanel);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameSize, frameSize);
    	frame.setVisible(true);
    	pack();
    	this.backOne = backOne;
    	this.backTwo = backTwo;
    	youWin = createImage();
    }
    
    public void updateView(ArrayList<GameObject> g) {
    	game = g;
    	backOne.setX(backOne.getX() + (int)Osprey.xSpeed);
    	backTwo.setX(backTwo.getX() + (int)Osprey.xSpeed);
    	mapNum = (int)((Osprey.distance/Osprey.maxDistance)*numOfMaps);
    	if(mapNum>numOfMaps-1)
    		mapNum = numOfMaps-1;
    	drawPanel.repaint();
    	
    }
    
	
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
    
    private class DrawPanel extends JPanel {

		protected void paintComponent(Graphics g) {
			if (Mate.caughtUp == false) {
			super.paintComponent(g);
			Color transparent = new Color(0, 0, 0, 0);
			g.setColor(transparent);
			Graphics2D twoD = (Graphics2D)g;
			back = (BufferedImage)(createImage(getWidth(), getHeight()));
			Graphics buffer = back.createGraphics();
			backOne.draw(buffer);
		    backTwo.draw(buffer);
		    twoD.drawImage(back, null, 0, 0);
			
		
	    	for (GameObject thing : game) {
		    	g.drawImage(thing.getScaledImg(), thing.hitbox.xpoints[0] ,thing.hitbox.ypoints[0], Color.gray, this);
	    	}
	    	g.drawImage(miniMaps[mapNum], frameSize-miniMaps[mapNum].getWidth(), 0, Color.gray,this);
		}
			else {
				super.paintComponent(g);
				g.setColor(Color.gray);
				g.drawImage(youWin, 0, 0, this);
				
			}
		}

		public Dimension getPreferredSize() {
			return new Dimension(frameSize, frameSize);
		}
	}
	
    public void addKeyListener(Controller controller) {
		frame.addKeyListener(controller);
	}
    
    public BufferedImage[] initMaps() {
    	BufferedImage[] maps = new BufferedImage[numOfMaps];
    	for(int i=0;i<numOfMaps;i++) {
    		BufferedImage map = null;
	    	try {
	    		map = ImageIO.read(new File("img/oMap"+i+".png"));
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	}
	    	maps[i] = map;
    	}
    	return maps;
    }
    
    
    /*
    public void addActionListener(Controller controller) {
    	frame.addActionListener(controller);
    }
    */
}
