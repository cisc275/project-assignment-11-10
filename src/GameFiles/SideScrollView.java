package GameFiles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
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
    //Action drawAction;

    public SideScrollView(){
    	add(drawPanel);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(frameSize, frameSize);
    	setVisible(true);
    	pack();
    }
    
    public void updateView(ArrayList<GameObject> g) {
    	game = g;
    	drawPanel.repaint();
    }
    
    private class DrawPanel extends JPanel {

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.gray);
			
	    	for (GameObject thing : game) {
		    	g.drawImage(thing.getImage(),thing.getX() ,thing.getY() , Color.gray, this);
	    	}
		}

		public Dimension getPreferredSize() {
			return new Dimension(frameSize, frameSize);
		}
	}
	
}
