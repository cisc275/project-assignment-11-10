package GameFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import GameFiles.OspreyMain.DrawPanel;

/**
 * Top down view for clapperrail
 *
 */
public class TopDownView extends View{
    DrawPanel drawPanel = new DrawPanel();
	
	public TopDownView() {
    	add(drawPanel);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(frameSize, frameSize);
    	setVisible(true);
    	pack();
	}
	
	public void updateView(ArrayList<GameObject> g) {}
	private class DrawPanel extends JPanel {
    	//int picNum = 0;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.gray);
			
			for(GameObject thing : game) {
		    	g.drawImage(thing.getImage(),thing.getX() ,thing.getY() , Color.gray, this);
			}
		}

		public Dimension getPreferredSize() {
			return new Dimension(frameSize, frameSize);
		}
	}
}
