package GameFiles;

import java.awt.Color;
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

//import GameFiles.ClapperRailMain.DrawPanel;
/*
 * int currY;
	int xloc = 200;
    int yloc = 200;
    int xIncr = 0;
    int yIncr = 0;
    boolean isDiving = false;
    
    int fish_xloc = 700;
    int trash1_xloc = 300;
    int trash2_xloc = 500;
    int trash3_xloc = 100;
    
    int fish_yloc = 550;
    int trash1_yloc = 550;
    int trash2_yloc = 550;
    int trash3_yloc = 550;
    
    final int picSize = 500; //don't think this will be necessary
    final int frameStartSize = 800;
    final int drawDelay = 30; //msec (don't know if this necessary)
 */


/**
 * View that scrolls sideways for the Osprey game 
 */

public class SideScrollView extends View{
    DrawPanel drawPanel = new DrawPanel();
    Action drawAction;

    public SideScrollView(){
    	drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			drawPanel.repaint();
    		}
    	};
    	add(drawPanel);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(frameSize, frameSize);
    	setVisible(true);
    	pack();
    }
    
    public void update(ArrayList<GameObject> g) {
    	game = g;
    }
    
    private class DrawPanel extends JPanel {
    	//int picNum = 0;

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
