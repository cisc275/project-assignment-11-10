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
    }
    
    public void updateView(ArrayList<GameObject> g) {
    	game = g;
    	backOne.setX(backOne.getX() + (int)Osprey.xSpeed);
    	backTwo.setX(backTwo.getX() + (int)Osprey.xSpeed);
    	drawPanel.repaint();
    	
    }
    
    private class DrawPanel extends JPanel {

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.gray);
			Graphics2D twoD = (Graphics2D)g;
			back = (BufferedImage)(createImage(getWidth(), getHeight()));
			Graphics buffer = back.createGraphics();
			backOne.draw(buffer);
		    backTwo.draw(buffer);
		    twoD.drawImage(back, null, 0, 0);
			
		    System.out.println(Osprey.xSpeed);
			
		
	    	for (GameObject thing : game) {
	    		g.setClip(thing.hitbox);
		    	g.drawImage(thing.getImage(),thing.hitbox.xpoints[0] ,thing.hitbox.ypoints[0], Color.gray, this);
	    	}
		}

		public Dimension getPreferredSize() {
			return new Dimension(frameSize, frameSize);
		}
	}
	
    public void addKeyListener(Controller controller) {
		frame.addKeyListener(controller);
	}
    /*
    public void addActionListener(Controller controller) {
    	frame.addActionListener(controller);
    }
    */
}
